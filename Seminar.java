public class Seminar {
    String sName;
    int sNum;
    int picked;
    int attended;
    

    public Seminar(String name, int num){
        sName = name;
        sNum = num;
    }

    public boolean isPop(){
        return picked>32;
    }

    public boolean isFull(){
        return attended>=32;
    }

    public int getNum(){
        return sNum;
    }

    public void pick(){
        picked++;
    }

    public void attend(){
        attended++;
    }

    public void quit(){
        attended--;
    }

    public int getAttended(){
        return attended;
    }

    public String toString() {
        return sName+" "+attended+"\n";
    }
}
