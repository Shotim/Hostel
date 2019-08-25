package runner;

import runner.building.Building;
import runner.building.Floor;
import runner.building.Room;
import runner.people.Human;
import runner.people.roomers.Student;
import runner.people.staff.SecurityGuard;
import runner.university.University;
import scanner.EnterFromConsole;

public class Hostel {
    private static int month = 0;
    private static final int END_OF_SEMESTER = 4;
    private static final int END_OF_COURSE = 2 * END_OF_SEMESTER;
    private static final int NEW_COURSE = 0;

    public static void main(String[] args) {
        Building building = start();
        building.showRoomers();
        monthRoutine(building);
        monthRoutine(building);
        monthRoutine(building);
        monthRoutine(building);
        monthRoutine(building);
    }

    private static Building start() {
        System.out.print("Enter number of floors in hostel:");
        int numberOfFloors = EnterFromConsole.enterInt();
        System.out.print("Enter number of rooms on a floor:");
        int numberOfRoomsOnTheFloor = EnterFromConsole.enterInt();

        Building building = new Building(numberOfFloors, numberOfRoomsOnTheFloor);
        for (Floor floor : building.building) {
            floor.warden.newFloorWarden(floor);
        }
        return building;
    }

    private static void monthRoutine(Building building) {
        month++;
        System.out.println("The " + month + "-th month is on");
        int numberOfOutsiders = (int) (10 * Math.random());
        for (int i = 0; i < numberOfOutsiders; i++) {
            SecurityGuard.checkPass(new Human(""));
        }

        evictStudents(building);

        for (Floor floor : building.building) {
            floor.warden.payForLivingCheck(floor);
            floor.warden.roomsCheck(floor);
        }
        building.roomCleaning();
        if (month == END_OF_SEMESTER) {
            University.expelStudents(building);
            if (month == END_OF_COURSE) {
                University.transferToTheNextCource(building);
                month = NEW_COURSE;
            }
        }
    }

    private static void evictStudents(Building building) {
        for (Floor floor : building.building) {
            for (Room room : floor.floor) {
                if (room.roomers.size() != 0) {
                    for (Student roomer : room.roomers) {
                        if (roomer.isExpelled || roomer.amountOfRemarks == Student.MAX_REMARKS || roomer.course > Student.MAX_COURSE) {
                            roomer.evict(floor);
                        }
                    }
                }
            }
        }
    }
}
