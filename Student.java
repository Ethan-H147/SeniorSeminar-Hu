public class Student {
	private String nameString;
	private Seminar[] choices;
    private Seminar[] attends;

    public Student(String name, Seminar[] choice){
        nameString = name;
        choices = choice;
    }
    
    public String toString() {
        return nameString+" "+choices[0].getNum()+" "+choices[1].getNum()+" "+choices[2].getNum()+" "+choices[3].getNum()+" "+choices[4].getNum();
    }

    public String schedule(){
        return nameString+" "+attends[0].getNum()+" "+attends[1].getNum()+" "+attends[2].getNum()+" "+attends[3].getNum()+" "+attends[4].getNum();
    }
    
}