public class Student {
	private String nameString;
	private int[] choices;

    public Student(String name, int[] choice){
        nameString = name;
        choices = choice;
    }

    
    public String toString() {
        return nameString+choices[0]+"\n";
    }
}