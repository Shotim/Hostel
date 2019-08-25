package runner.people.staff;

import runner.people.Human;
import runner.people.roomers.Student;

public class SecurityGuard extends Human {
    public static void checkPass(Human human) {
        if (human.pass) {
            System.out.println("Outsider tried to come in!");
        } else {
            System.out.println("The person with the pass was admitted!");
        }
    }

    public static void helpEvict(Student student) {
        System.out.println("The " + student.getId() + "-th student is evicted with the help of security guard");
    }
}
