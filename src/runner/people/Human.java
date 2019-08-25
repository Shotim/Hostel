package runner.people;

public class Human {
    private int id;
    private static int lastID;
    public boolean pass;

    public Human(String str) {
        this.id = 0;
        this.pass = (int) (2 * Math.random()) != 0;
    }

    public Human() {
        setNewId();
    }

    public Human(Human human) {
        setId(human.getId());
        this.pass = human.pass;
    }

    public void setNewId() {
        lastID++;
        this.id = lastID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
