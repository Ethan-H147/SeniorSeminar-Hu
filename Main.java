/**
 * Ethan Hu
 * 2023/02/04
 * Senior Seminar
 * Main Class-core of the program, controlling the basic running logic
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main (String[] args){  
    String[] myArray;
    ArrayList<Student> grade = new ArrayList<Student>();
    ArrayList<Seminar> sList = new ArrayList<Seminar>();
    String name;
    int totalSeminar=19;
      //scan the list of seminars
      try {
        File myObj = new File("SrSeminar_RawData.csv");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          //System.out.println(data);
          myArray = data.split(",");
          //8th in the list
          name = myArray[8];
          int num = Integer.parseInt(myArray[9]);
          //scan the list of seminars
          Seminar a = new Seminar(name, num);
          sList.add(a);
          totalSeminar--;
          if(totalSeminar<1){
            break;
          }
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      try {
        File myObj = new File("SrSeminar_RawData.csv");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          //System.out.println(data);
          myArray = data.split(",");
          name = myArray[1];
          Seminar[] choice=new Seminar[5];
          for(int i=0;i<5;i++){
            int temp = Integer.parseInt(myArray[2+i])-1;
            if(temp==-1){
              temp=18;
            }
            choice[i]=sList.get(temp);
            sList.get(temp).pick();
          }
          Student a = new Student(name, choice);
          grade.add(a);
          //System.out.println(a);
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      
      //System.out.print(grade);

      for(Student s:grade){
        for(int i=0;i<5;i++){
          if(!s.getChoices()[i].isPop()){
            s.setSchedule(i,s.getChoices()[i]);//assign if the seminar is unpopular but on their choices
          }
          else{
            s.setSchedule(i,sList.get(18));//set as the placeholder
          }
        }
      }
      int tempIndex=0;
      int r=0;
      int t=0;

      for(Student s:grade){
        if(s.ns()==3){//students with 3 empty blocks
          r=2;
          for(int i=0;i<5;i++){
            if(s.getChoices()[i].isPop()){//only deal with popular ones 
              for(int j=0;j<5;j++){
                if(s.getAttends()[j].getNum()==19){
                  tempIndex=j;//return the index of the first placeholder
                  break;
                }
              }
              if(!s.getChoices()[i].isFull()&&!seminarExist(s.getAttends(), s.getChoices()[i])){//make sure it doesn't exceed 32 students
              s.setSchedule(tempIndex, s.getChoices()[i]);
              sList.get(18).quit();//remove the student from the placeholder
              }
              r--;
              if(r==0){
                break;//stop filling, leave some empty ones for later in order to balance, otherwise students on the top will get fulfilled but not the ones on the bottom
              }
            }
          }
        }
        else{//mainly for students with 4 empty blocks, if it finds the students with 2 it will just fill their schedule
          t=3;
          for(int i=0;i<5;i++){//same logic as above except for different values
            if(s.getChoices()[i].isPop()){
              for(int j=0;j<5;j++){
                if(s.getAttends()[j].getNum()==19){
                  tempIndex=j;
                  break;
                }
              }
              if(!s.getChoices()[i].isFull()&&!seminarExist(s.getAttends(), s.getChoices()[i])){
              s.setSchedule(tempIndex, s.getChoices()[i]);
              sList.get(18).quit();
              }
              t--;
              if(t==0){
                break;
              }
            }
          }
        }
      }

      Seminar rand=sList.get(18);//initialize a seminar for random assignment
      for(Student s:grade){
          for(int i=0;i<5;i++){
            if(s.getChoices()[i].isPop()){
              for(int j=0;j<5;j++){
                if(s.getAttends()[j].getNum()==19){
                  tempIndex=j;//the index of the first placeholder
                  break;
                }
              }
              if(!s.getChoices()[i].isFull()&&!seminarExist(s.getAttends(), s.getChoices()[i])){
              s.setSchedule(tempIndex, s.getChoices()[i]);//make sure their choices are still considered, if it still fits then put that in
              }
              else{
                do{
                  rand=sList.get((int)(Math.random()*18));//if not then randomly pick one
                }
                while(rand.isFull()||seminarExist(s.getAttends(), rand));//pick one that's not full and not already picked
                s.setSchedule(tempIndex, rand);
                sList.get(18).quit();
              }
            }
          }
        }
        //last round of filling holes
        for(Student s:grade){
          for(int i=0;i<5;i++){
            if(s.getAttends()[i]==sList.get(18)){//if there are still placeholders left, assign seminars
                do{
                  rand=sList.get((int)(Math.random()*18));
                }
                while(rand.isFull()||seminarExist(s.getAttends(), rand));
                s.setSchedule(i, rand);
                sList.get(18).quit();
              
            }
          }
        }

      System.out.println("Function(students/seminars/student search/seminar search)");
      Scanner scan = new Scanner(System.in);
      String funct;
  do{
      funct= scan.nextLine();
    //print the roster of students and their schedules
    if(funct.equalsIgnoreCase("students")) {
      for(Student s:grade){
        System.out.println(s.schedule());
      }
    }
    //print the list of seminars and how many students are taking them
    if(funct.equalsIgnoreCase("seminars")) {
      for(Seminar s:sList){
        if(s!=sList.get(18))
        System.out.println(s);
      }
    }
    //print a specific student and his schedule
    if(funct.equalsIgnoreCase("student search")){
      System.out.print("Enter full name: ");
            String searchName = scan.nextLine();
            if(searchStudent(grade, searchName)==-1){//doesn't exist
              System.out.print("Student doesn't exist.\n");
            }
            else{
              System.out.print(grade.get(searchStudent(grade, searchName)-1).schedule());
            }
    }
    //print a seminar and the list of students taking it
    if(funct.equalsIgnoreCase("seminar search")) {
      System.out.print("Enter seminar number: ");
            int searchSeminar = scan.nextInt()-1;
            System.out.println(sList.get(searchSeminar));
            Seminar temp = sList.get(searchSeminar);
            if(temp.getAttended()>16){
              System.out.print("2 Sessions\n");
            }
            else{System.out.print("1 Session\n");}
            for(Student s:grade){
              for(int i=0;i<5;i++){
                if(s.getAttends()[i]==temp){
                  System.out.println(s.getName());
                }
              }
            }
    }

}while(!funct.equalsIgnoreCase("skip"));
    

}
//method for returning the index of a specific student
public static int searchStudent(ArrayList<Student> sList, String name){
  for(int i=0; i<sList.size();i++){
    if (sList.get(i).getName().equalsIgnoreCase(name)){//check both last and first name
    return i+1;
    }
  }
return -1;
}
//help with assigning, see if the student already have the seminar
public static boolean seminarExist(Seminar[] sList, Seminar a){
  for(int i=0; i<sList.length;i++){
    if (sList[i]==a){//check both last and first name
    return true;
    }
  }
return false;
}

}
