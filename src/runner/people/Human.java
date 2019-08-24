package runner.people;

public abstract class Human {
    private int id;
    private static int lastID;
    public boolean pass;

    public Human() {
        setNewId();
    }

    public Human(Human human) {
        setId(human.getId());
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
