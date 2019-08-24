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
    public int theRoomNumber;
    public int theFloorNumber;
    public int yearOfLiving;

    public Student(Room room) {
        super();
        newRoomer(room);
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

    public void settleInHostel() {
        this.isExpelled = false;
        this.pass = true;
        payForAccommodation();
        removeRemarks();
    }

    public FloorWarden appointAWarden() {
        FloorWarden warden = new FloorWarden(this);
        return warden;
    }

    public void raiseTheCourse() {
        this.course++;
    }

    public void expel() {
        this.isExpelled = true;
    }

    public void payForAccommodation() {
        this.paidForAccommodation = true;
    }

    public void removeRemarks() {
        amountOfRemarks = 0;
    }

    public void getRemark() {
        amountOfRemarks++;
    }

    public void evict(Floor floor, Room room, FloorWarden floorWarden) {
        Commandant.approveEviction(this);
        room.freeTheBed(this);
        SecurityGuard.helpEvict(this);
        System.out.println("the " + this.getId() + "-th student is living because he " + this.causeOfEviction());
        if (this.getId() == floorWarden.getId()) {
            floorWarden.newFloorWarden(floor.floor);
        }
    }

    private String causeOfEviction() {
        if (this.course > MAX_COURSE) {
            return "was graduated";
        }
        if (this.amountOfRemarks == MAX_REMARKS) {
            return "received too much remarks";
        }
        if (this.isExpelled) {
            return "was expelled from university";
        }
        if (!this.paidForAccommodation) {
            return "doesn't pay for accommodation";
        }
        return "";
    }
}
