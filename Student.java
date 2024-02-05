/**
 * Ethan Hu
 * 2023/02/04
 * Senior Seminar
 * Student Class-information of a student
 */

import java.util.ArrayList;

public class Student {
	private String nameString;//name
	private Seminar[] choices;//what they chose
    private Seminar[] attends=new Seminar[5];//what they actually attend
    private int ns=0;
    
    //constructor
    public Student(String name, Seminar[] choice){
        nameString = name;
        choices = choice;
        for(int i=0;i<5;i++){
            attends[i]=null;
        }
    }
    //number of unscheduled blocks
    public int ns(){
        for(int i=0;i<5;i++){
            if(attends[i].getNum()==19){
                ns++;
            }
        }
        return ns;
    }
    
    public String getName(){
        return nameString;
    }

    public Seminar[] getChoices(){
        return choices;
    }

    public Seminar[] getAttends(){
        return attends;
    }
    //set a block in their schedule as a seminar
    public void setSchedule(int i, Seminar a){
        attends[i]=a;
        a.attend();
    }

    //print their choices
    public String toString() {
        return nameString+" "+choices[0].getNum()+" "+choices[1].getNum()+" "+choices[2].getNum()+" "+choices[3].getNum()+" "+choices[4].getNum();
    }
    //print their schedule
    public String schedule(){
        return nameString+" "+attends[0].getNum()+" "+attends[1].getNum()+" "+attends[2].getNum()+" "+attends[3].getNum()+" "+attends[4].getNum();
    }
    
}
