public class Seminar {
    String sName;
    int sNum;
    int picked;
    int attended;
    //boolean popularity=picked>32;

    public Seminar(String name, int num){
        sName = name;
        sNum = num;
    }

    public boolean isPop(){
        return picked>32;
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

    public String toString() {
        return sName+" "+picked;
    }
}
