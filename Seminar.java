public class Seminar {
    String sName;
    int sNum;
    boolean popularity;

    public Seminar(String name, int num){
        sName = name;
        sNum = num;
    }

    public int getNum(){
        return sNum;
    }

    public String toString() {
        return sName;
    }
}
