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
        this.cleanStatus = true;
        this.number = roomNumber;
        this.floor = floor.floorNumber;
        for (int i = 0; i < MAX_ROOM_CAPACITY; i++) {
            Student student = new Student(this);
            this.roomers.add(student);
        }
    }

    public void settleTheStudent(Student student) {
        Commandant.approveCheckIn(student);
        this.roomers.add(student);
    }

    boolean isSettled() {
        return roomers.size() == MAX_ROOM_CAPACITY;
    }

    public boolean isClean() {
        return this.cleanStatus;
    }

    void showRoomers() {
        if (this.roomers.size() != 0) {
            for (Student roomer : this.roomers) {
                roomer.studentInfo();
            }
        }
    }

    void Cleaning() {
        this.cleanStatus = Math.random() > 0.5;
    }
}
