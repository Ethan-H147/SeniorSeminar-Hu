public class Seminar {
    String sName;
    int sNum;
    int picked;
    boolean popularity=picked>32;

    public Seminar(String name, int num){
        sName = name;
        sNum = num;
    }

    public boolean isPop(){
        return popularity;
    }

    public int getNum(){
        return sNum;
    }

    public void pick(){
        picked++;
    }

    public String toString() {
        return sName+" "+picked;
    }
}
