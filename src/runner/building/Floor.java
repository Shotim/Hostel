package runner.building;

import runner.people.staff.FloorWarden;

public class Floor {
    public Room[] floor;
    int floorNumber;
    public FloorWarden warden;

    Floor(Building building, int floorNumber) {
        this.floor = new Room[building.roomAmountOnTheFloor];
        this.floorNumber = floorNumber;
        for (int roomCounter = 0; roomCounter < building.roomAmountOnTheFloor; roomCounter++) {
            this.floor[roomCounter] = new Room(this, roomCounter);
            this.warden = new FloorWarden(this.floor[0].roomers.get(0));
        }
    }

    void showRoomers() {
        for (Room room : this.floor) {
            room.showRoomers();
        }
    }

    void roomCleaning() {
        for (Room room : this.floor) {
            room.Cleaning();
        }
    }
}
