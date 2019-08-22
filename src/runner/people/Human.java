package runner.people;

public abstract class Human {
    private int id;
    private static int lastID;
    public boolean pass;

    public Human(){
        setId();
    }

    void setId() {
        lastID++;
        this.id = lastID;
    }

    int getId() {
        return this.id;
    }
}
