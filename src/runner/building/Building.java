package runner.building;

public class Building {
    public Floor[] building;
    int floorAmount;
    int roomAmountOnTheFloor;

    public Building(int floorAmount, int roomAmountOnTheFloor) {
        this.building = new Floor[floorAmount];
        this.floorAmount = floorAmount;
        this.roomAmountOnTheFloor = roomAmountOnTheFloor;
        for (int floorCounter = 0; floorCounter < floorAmount; floorCounter++) {
            this.building[floorCounter] = new Floor(this, floorCounter);
        }
    }

    public void showRoomers() {
        for (Floor floor : this.building) {
            floor.showRoomers();
        }
    }

    public void roomCleaning() {
        for (Floor floor : this.building) {
            floor.roomCleaning();
        }
    }
}
