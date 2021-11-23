import java.util.ArrayList;

public class Event {
    private int id;
    private String name;
    private String time;
    private int room;
    private int numberOfParticipants;
    // TODO change date format
    private String startDate;
    // TODO implement speaker
    private Host host;
    private Alumni guestSpeaker;
    private ArrayList<String> attendants;

    // constructors
    public Event() {
        // empty
    }

    // existing event
    public Event(int id, String name, String time, int room, int numberOfParticipants, String startDate,
            ArrayList<String> attendant) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.room = room;
        this.numberOfParticipants = numberOfParticipants;
        this.startDate = startDate;
        this.attendants = attendant;
    }

    // adding event
    public Event(int id, String name, String time, int room, int numberOfParticipants, String startDate) {
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
        return getId() + "," + getName() + "," + getTime() + "," + getRoom() + "," + getNumberOfParticipants() + ","
                + getStartDate();
    }

    public String saveAttendants() {
        String x = "";
        for (int i = 0; i < attendants.size(); i++) {
            if (i == attendants.size() - 1) {
                x += attendants.get(i);
            } else { 
                x += attendants.get(i) + ",";
            }
        }
        return x;
    }

}
