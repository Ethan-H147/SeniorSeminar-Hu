/**
 * Ethan Hu
 * 2023/02/04
 * Senior Seminar
 * Seminar Class- basic information needed for a seminar session, with some getters
 */

public class Seminar {
    String sName;
    int sNum;
    int picked;
    int attended;
    
    //constructor
    public Seminar(String name, int num){
        sName = name;
        sNum = num;
    }
    //see if a seminar is popular(picked over 32 times)
    public boolean isPop(){
        return picked>32;
    }
    //if there are 32 students it's full
    public boolean isFull(){
        return attended>=32;
    }
    //return the number
    public int getNum(){
        return sNum;
    }
    //counter for pick
    public void pick(){
        picked++;
    }
    //counter for attend, used in checking whether it's full
    public void attend(){
        attended++;
    }
    //counter -1
    public void quit(){
        attended--;
    }
    //return the number of students taking it
    public int getAttended(){
        return attended;
    }
    
    public String toString() {
        return sName+" "+attended+"\n";
    }
}
