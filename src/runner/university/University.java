package runner.university;

import runner.building.Building;
import runner.building.Floor;
import runner.building.Room;
import runner.people.roomers.Student;

public class University {
    public static void expelStudents(Building building) {
        for (Floor floor : building.building) {
            for (Room room : floor.floor) {
                for (Student roomer : room.roomers) {
                    if (Math.random() > 0.8) {
                        roomer.expel();
                    }
                }
            }
        }
    }

    public static void transferToTheNextCource(Building building) {
        for (Floor floor : building.building) {
            for (Room room : floor.floor) {
                if(room.roomers.size()!=0){
                    for (Student roomer : room.roomers) {
                        roomer.raiseTheCourse();
                    }
                }
            }
        }
    }
}
