package runner.people.staff;

import runner.people.Human;
import runner.people.roomers.Student;

public class SecurityGuard extends Human {
    public static boolean checkPass(Human human) {
        return human.pass;
    }

    public static void helpEvict(Student student){
        System.out.println("The "+student.getId()+"-th student is evicted with the help of security guard");
    }
}
