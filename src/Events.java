import java.util.ArrayList;

public class Events {

    private static int eventId = 0000;
    private int id;
    private String name;
    private String time;
    private int room;
    private int numberOfParticipants;
    private String startDate;
    private ArrayList<String> attendants;

    // constructors
    public Events() {

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

    // new event
    public Events(String name, String time, int room, int numberOfParticipants, String startDate) {
        eventId++;
        this.id = eventId;
        this.name = name;
        this.time = time;
        this.room = room;
        this.numberOfParticipants = numberOfParticipants;
        this.startDate = startDate;
        this.attendants = new ArrayList<>();
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

}
