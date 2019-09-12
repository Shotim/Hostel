package runner.building;

import runner.people.roomers.Student;
import runner.people.staff.Commandant;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private final static int MAX_ROOM_CAPACITY = 3;
    public List<Student> roomers = new ArrayList<Student>();
    private boolean cleanStatus;
    public int number;
    public int floor;

    public Room(Floor floor, int roomNumber) {
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

    public boolean isSettled() {
        return roomers.size() == MAX_ROOM_CAPACITY;
    }

    public boolean isClean() {
        return this.cleanStatus;
    }

    public void showRoomers() {
        if (this.roomers.size() != 0) {
            for (Student roomer : this.roomers) {
                roomer.studentInfo();
            }
        }
    }

    public void cleaning() {
        this.cleanStatus = Math.random() > 0.5;
    }

    public void evictStudents(Floor floor){
        for (Student roomer : this.roomers) {
            if (roomer.isExpelled || roomer.amountOfRemarks == Student.MAX_REMARKS || roomer.course > Student.MAX_COURSE) {
                roomer.evict(floor);
            }
        }
    }
}
