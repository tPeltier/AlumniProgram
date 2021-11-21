import java.util.ArrayList;

public class Events {
    private int id;
    private String name;
    private String time;
    private int room;
    private int numberOfParticipants;
    // TODO change date format
    private String startDate;
    private Speaker speaker;
    private ArrayList<String> attendants;

    // constructors
    public Events() {
        //empty
    }

    // existing event
    public Events(int id, String name, String time, int room, int numberOfParticipants, String startDate,
            ArrayList<String> attendant) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.room = room;
        this.numberOfParticipants = numberOfParticipants;
        this.startDate = startDate;
        this.attendants = attendant;
    }

    public Events(int id, String name, String time, int room, int numberOfParticipants, String startDate) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.room = room;
        this.numberOfParticipants = numberOfParticipants;
        this.startDate = startDate;
    }



    // getters and setters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRoom() {
        return this.room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getNumberOfParticipants() {
        return this.numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void addAttendant(String name) {
        attendants.add(name);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", time='" + getTime() + "'" + ", room='"
                + getRoom() + "'" + ", numberOfParticipants='" + getNumberOfParticipants() + "'" + ", startDate='"
                + getStartDate() + "'" + "}";
    }

    public String save() {
        return getId() + "," + getName() + "," + getTime() + "," + getRoom() + "," + getNumberOfParticipants() + "," + getStartDate();
    }

    public String saveAttendants() {
        String x "";
        for (int i = 0; i < attendants.size(); i++) {
           x += attendants.get(i);
        }
        return x;
    }

}
