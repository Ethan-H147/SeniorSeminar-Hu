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
      
      try {
        File myObj = new File("SrSeminar_RawData.csv");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          //System.out.println(data);
          myArray = data.split(",");
          name = myArray[8];
          int num = Integer.parseInt(myArray[9]);
          Seminar a = new Seminar(name, num);
          sList.add(a);
          //System.out.println(a);
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
      //System.out.print(sList);
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
          System.out.println(a);
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      System.out.println("Function");
      //System.out.print(grade);
      Scanner scan = new Scanner(System.in);
      String funct;
      do{
      funct= scan.nextLine();
    
    if(funct.equalsIgnoreCase("students")) {
      for(Student s:grade){
        for(int i=0;i<5;i++){
          if(!s.getChoices()[i].isPop()){
            s.setSchedule(i,s.getChoices()[i]);
          }
          else{
            s.setSchedule(i,sList.get(18));
          }
        }
        System.out.println(s.schedule());
      }
    }
      }
      while(!funct.equalsIgnoreCase("skip"));
    }
  
}
