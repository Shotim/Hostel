package runner.people.staff;

import runner.building.Floor;
import runner.building.Room;
import runner.people.roomers.Student;

public class FloorWarden extends Student {

    public FloorWarden(Student student) {
        super(student);
    }

    public void roomsCheck(Floor floor) {
        boolean wardenEvicted = false;
        for (Room room : floor.floor) {
            if (room.roomers.size() != 0) {
                if (!room.isClean()) {
                    for (Student roomer : room.roomers) {
                        roomer.getRemark();
                        if (roomer.amountOfRemarks == MAX_REMARKS) {
                            wardenEvicted = roomer.evict(floor);
                        }
                    }
                    room.roomers.removeIf(roomer -> (roomer.amountOfRemarks == MAX_REMARKS));
                    if (wardenEvicted) {
                        floor.warden.newFloorWarden(floor);
                    }
                }
            }
        }
    }

    public void payForLivingCheck(Floor floor) {
        boolean wardenEvicted = false;
        for (Room room : floor.floor) {
            if (room.roomers.size() != 0) {
                for (Student roomer : room.roomers) {
                    if (!roomer.paidForAccommodation) {
                        wardenEvicted = roomer.evict(floor);
                    }
                }
                room.roomers.removeIf(roomer -> (!roomer.paidForAccommodation));
                if (wardenEvicted) {
                    floor.warden.newFloorWarden(floor);
                }
            }
        }
    }

    public void newFloorWarden(Floor floor) {
        for (Room room : floor.floor) {
            if (room.roomers.size() != 0) {
                for (Student roomer : room.roomers) {
                    if (roomer.yearOfLiving > 0) {
                        floor.warden = roomer.appointAWarden();
                        room.roomers.remove(roomer);
                        room.roomers.add(floor.warden);
                        System.out.println("New floor warden was appointed with id - " + floor.warden.getId());
                        return;
                    }
                }
            }
        }
    }
}
