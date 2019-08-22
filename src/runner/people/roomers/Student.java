package runner.people.roomers;

import runner.people.Human;

public class Student extends Human {
    int course;
    int amountOfRemarks;
    boolean isExpelled;
    boolean paidForAccomodation;
    int theRoomNumber;

    public Student(int course, int theRoomNumber) {
        super();
        settleInHostel();
        this.course = course;
        this.theRoomNumber = theRoomNumber;
    }

    public Student() {
        super();
        settleInHostel();
    }

    void settleInHostel() {
        this.isExpelled = false;
        this.pass = true;
        payForAccomodation();
        removeRemarks();
    }

    void raiseTheCourse() {
        this.course++;
    }

    void expel() {
        this.isExpelled = true;
    }

    void payForAccomodation() {
        this.paidForAccomodation = true;
    }

    void removeRemarks() {
        amountOfRemarks = 0;
    }

    void getRemark() {
        amountOfRemarks++;
    }

    //boolean evictionCandidate();
}
