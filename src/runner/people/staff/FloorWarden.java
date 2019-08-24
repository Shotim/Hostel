package runner.people.staff;

import runner.building.Building;
import runner.building.Floor;
import runner.building.Room;
import runner.people.roomers.Student;

public class FloorWarden extends Student {

    public FloorWarden(Student student) {
        super(student);
    }

    public void roomsCheck(Building building) {
        for (Floor floor : building.building) {
            for (Room room : floor.floor) {
                if (!room.isClean()) {
                    for (Student roomer : room.roomers) {
                        roomer.getRemark();
                        if (roomer.amountOfRemarks == MAX_REMARKS) {
                            roomer.evict(floor, room, this);
                        }
                    }
                }
            }
        }
    }

    public void payForLivingCheck(Building building) {
        for (Floor floor : building.building) {
            for (Room room : floor.floor) {
                for (Student roomer : room.roomers) {
                    if (!roomer.paidForAccommodation) {
                        roomer.evict(floor, room, this);
                    }
                }
            }
        }
    }

    public void newFloorWarden(Room[] floor) {
        FloorWarden newFloorWarden;
        for (Room room : floor) {
            for (Student roomer : room.roomers) {
                if (roomer.yearOfLiving > 0) {
                    newFloorWarden = roomer.appointAWarden();
                    room.freeTheBed(roomer);
                    room.settleTheStudent(newFloorWarden);
                    System.out.println("New floor warden was appointed with id - " + newFloorWarden.getId());
                    return;
                }
            }
        }
    }
}
