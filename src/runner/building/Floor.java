package runner.building;

import runner.people.roomers.Student;
import runner.people.staff.FloorWarden;

public class Floor {

    public Room[] floor;
    public int floorNumber;
    public FloorWarden warden;

    public Floor(Building building, int floorNumber) {
        this.floor = new Room[building.roomAmountOnTheFloor];
        this.floorNumber = floorNumber;
        for (int roomCounter = 0; roomCounter < building.roomAmountOnTheFloor; roomCounter++) {
            this.floor[roomCounter] = new Room(this, roomCounter);
            this.warden = new FloorWarden(this.floor[0].roomers.get(0));
        }
    }

    public void showRoomers() {
        for (Room room : this.floor) {
            room.showRoomers();
        }
    }

    public void roomCleaning() {
        for (Room room : this.floor) {
            room.cleaning();
        }
    }

    public void evictStudents(){
        for (Room room : this.floor) {
            if (room.roomers.size() != 0) {
                room.evictStudents(this);
            }
        }
    }
}
