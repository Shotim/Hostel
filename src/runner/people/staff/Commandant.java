package runner.people.staff;

import runner.people.Human;
import runner.people.roomers.Student;

public class Commandant extends Human {

    public static void approveCheckIn(Student student) {
        System.out.println("Commendant approved check-in of student with id = " + student.getId());
    }

    public static void approveEviction(Student student) {
        System.out.println("Commendant approved evitction of student with id = " + student.getId());
    }
}
