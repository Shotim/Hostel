package runner.people.staff;

import runner.people.roomers.Student;

public class FloorWarden extends Student {
    FloorWarden(){
        super();
    }

    FloorWarden appointAWarden(Student student){
        return (FloorWarden) student;
    }
}
