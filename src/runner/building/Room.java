package runner.building;

import runner.people.roomers.Student;

import java.util.ArrayList;

public class Room {
    private static int lastRoomNumber;
    private final static int MAX_ROOM_CAPACITY = 3;
    private ArrayList<Student> roomers = new ArrayList<Student>();
    private int cleanStatus;
    int number;

    Room() {
        int course = 1;
        for (int i = 0; i < MAX_ROOM_CAPACITY; i++) {
            roomers.add(new Student(course, this.number));
        }
        this.cleanStatus = 5;
        lastRoomNumber++;
        this.number = lastRoomNumber;
    }

    void settleTheStudent(Student student) {
        this.roomers.add(student);
    }

    void freeTheBed(Student student) {
        this.roomers.remove(student);
    }

    boolean isSettled() {
        return roomers.size() == MAX_ROOM_CAPACITY;
    }
}
