package runner.building;

import runner.people.roomers.Student;
import runner.people.staff.Commandant;

import java.util.ArrayList;

public class Room {
    private final static int MAX_ROOM_CAPACITY = 3;
    public ArrayList<Student> roomers = new ArrayList<Student>();
    private boolean cleanStatus;
    public int number;
    public int floor;

    Room(Floor floor, int roomNumber) {
        for (int i = 0; i < MAX_ROOM_CAPACITY; i++) {
            this.roomers.add(new Student(this));
        }
        this.cleanStatus = true;
        this.number = roomNumber;
        this.floor=floor.floorNumber;
    }

    public void settleTheStudent(Student student) {
        Commandant.approveCheckIn(student);
        this.roomers.add(student);
    }

    public void freeTheBed(Student student) {
        this.roomers.remove(student);
    }

    boolean isSettled() {
        return roomers.size() == MAX_ROOM_CAPACITY;
    }

    public boolean isClean() {
        return this.cleanStatus;
    }
}
