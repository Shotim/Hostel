package runner.building;

public class Building {
    public Floor[] building;
    public int floorAmount;
    public int roomAmountOnTheFloor;

    Building(int floorAmount, int roomAmount) {
        this.building = new Floor[floorAmount];
        this.floorAmount=floorAmount;
        this.roomAmountOnTheFloor=roomAmount;
    }

    void checkIn() {
        for (int floorCounter = 0; floorCounter < this.floorAmount; floorCounter++) {
            this.building[floorCounter] = new Floor(this, floorCounter);
            this.building[floorCounter].checkIn(this);
        }
    }
}
