public class Student {
	private String nameString;
	private Seminar[] choices;

    public Student(String name, Seminar[] choice){
        nameString = name;
        choices = choice;
    }
    
    public String toString() {
        return nameString+" "+choices[1].getNum();
    }
}