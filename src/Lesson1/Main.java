package Lesson1;

public class Main {
    public static void main(String[] args) {

        Test test = new Test(13.0,150,21);


        Team team = new Team("GB",new Member[]{new Member("Nike", 12.8,160, 23),
                new Member("Anna", 13.1,150, 21), new Member("Tom", 13.2,150, 25)});

        test.doIt(team);



    }

}
