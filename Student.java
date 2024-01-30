public class Student {
	private String nameString;
	private Seminar[] choices;
    private Seminar[] attends=new Seminar[5];
    private int ns=0;
    

    public Student(String name, Seminar[] choice){
        nameString = name;
        choices = choice;
        for(int i=0;i<5;i++){
            attends[i]=null;
        }
    }
    
    public int ns(){
        for(int i=0;i<5;i++){
            if(attends[i].getNum()==19){
                ns++;
            }
        }
        return ns;
    }

    public Seminar[] getChoices(){
        return choices;
    }

    public Seminar[] getAttends(){
        return attends;
    }

    public void setSchedule(int i, Seminar a){
        attends[i]=a;
        a.attend();
    }

    public String toString() {
        return nameString+" "+choices[0].getNum()+" "+choices[1].getNum()+" "+choices[2].getNum()+" "+choices[3].getNum()+" "+choices[4].getNum();
    }

    public String schedule(){
        return nameString+" "+attends[0].getNum()+" "+attends[1].getNum()+" "+attends[2].getNum()+" "+attends[3].getNum()+" "+attends[4].getNum();
    }
    
}
