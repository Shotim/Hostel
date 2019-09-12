package runner.people.roomers;

import runner.building.Floor;
import runner.building.Room;
import runner.people.Human;
import runner.people.staff.Commandant;
import runner.people.staff.FloorWarden;
import runner.people.staff.SecurityGuard;

public class Student extends Human {
    public static final int MAX_COURSE = 4;
    public static final int MAX_REMARKS = 2;
    public int course;
    public int amountOfRemarks;
    public boolean isExpelled;
    public boolean paidForAccommodation;
    private int theRoomNumber;
    private int theFloorNumber;
    public int yearOfLiving;

    public Student(Room room) {
        super();
        newRoomer(room);
        studentInfo();
    }

    public void studentInfo() {
        System.out.println("id: " + this.getId() + "\ncourse: " + this.course + "\nyears of living: " + this.yearOfLiving + "\nfloor: " + this.theFloorNumber + "\nroom: " + this.theRoomNumber + "\n\n");
    }

    public Student(Student student) {
        super(student);
        settleInHostel();
        this.course = student.course;
        this.theRoomNumber = student.theRoomNumber;
        this.yearOfLiving = student.yearOfLiving;
    }

    private void newRoomer(Room room) {
        settleInHostel();
        this.course = (int) (MAX_COURSE * Math.random()) + 1;
        this.yearOfLiving = (int) (this.course * Math.random());
        this.theRoomNumber = room.number;
        this.theFloorNumber = room.floor;
        Commandant.approveCheckIn(this);
    }

    private void settleInHostel() {
        this.isExpelled = false;
        this.pass = true;
        payForAccommodation();
        removeRemarks();
    }

    public FloorWarden appointAWarden() {
        return new FloorWarden(this);
    }

    public void raiseTheCourse() {
        this.course++;
    }

    public void expel() {
        this.isExpelled = true;
    }

    private void payForAccommodation() {
        this.paidForAccommodation = true;
    }

    private void removeRemarks() {
        amountOfRemarks = 0;
    }

    public void receiveRemark() {
        amountOfRemarks++;
    }

    public boolean evict(Floor floor) {
        Commandant.approveEviction(this);
        SecurityGuard.helpEvict(this);
        System.out.println("the " + this.getId() + "-th student is living because he " + this.causeOfEviction());
        return this.getId() == floor.warden.getId();
    }

    private String causeOfEviction() {
        if (this.course > MAX_COURSE) {
            return "was graduated";
        } else if (this.amountOfRemarks == MAX_REMARKS) {
            return "received too much remarks";
        } else if (this.isExpelled) {
            return "was expelled from university";
        } else if (!this.paidForAccommodation) {
            return "doesn't pay for accommodation";
        }
        return "";
    }
}
