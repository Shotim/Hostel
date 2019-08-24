package runner.building;

public class Floor {
    public Room[] floor;
    public int floorNumber;

    Floor(Building building, int floorNumber) {
        this.floor = new Room[building.roomAmountOnTheFloor];
        this.floorNumber = floorNumber;
    }

    void checkIn(Building building) {
        for (int roomCounter = 0; roomCounter < building.roomAmountOnTheFloor; roomCounter++) {
            floor[roomCounter]=new Room(this, roomCounter);
        }
    }
}
