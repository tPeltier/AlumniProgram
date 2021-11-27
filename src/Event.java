import java.util.ArrayList;
import java.time.LocalDateTime;

public class Event {
    private int id;
    private String name;
    private int room;
    private int numberOfParticipants;
    private LocalDateTime startDate;
    private Host host;
    private Alumni guestSpeaker;
    private ArrayList<String> attendants;

    // constructors
    public Event() {
        // empty
    }


    // existing event
    public Event(int id, String name, int room, int numberOfParticipants, LocalDateTime startDate,
            ArrayList<String> attendant, Host host) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.numberOfParticipants = numberOfParticipants;
        this.startDate = startDate;
        this.attendants = attendant;
        this.host = host;
    }

    // adding event
    public Event(int id, String name, int room, int numberOfParticipants, LocalDateTime startDate, Host host) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.numberOfParticipants = numberOfParticipants;
        this.startDate = startDate;
        this.host = host;
        attendants = new ArrayList<>();
    }


    // getters and setters

    /**
     * get guest speaker
     * @return guest speaker
     */
    public Alumni getAlumni(){
        return guestSpeaker;
    }

    /**
     * set guest speaker
     * @param alumni passing value of guest speaker
     */
    public void setAlumni(Alumni alumni){
        guestSpeaker = alumni;
    }

    /**
     *get id of event
     * @return id of event
     */
    public int getId() {
        return this.id;
    }

    /**
     * gets id of host
     * @return host id
     */
    public int getHostId() {
        return host.getId();
    }

    /**
     * gets name of event
     * @return event name
     */
    public String getName() {
        return this.name;
    }

    /**
     * set name of event
     * @param name passing value of event name
     */
    public void setName(String name) {
        this.name = name;
    }


    public int getYear() {
        return startDate.getYear();
    }

    public int getMonth() {
        return startDate.getMonthValue();
    }

    public int getDay() {
        return startDate.getDayOfMonth();
    }

    public int getHour() {
        return startDate.getHour();
    }

    public int getMinute() {
        return startDate.getMinute();
    }

    // testing
    public void setTime(int year, int month, int day, int hour, int minute) {
        this.startDate = LocalDateTime.of(year, month, day, hour, minute);
    }

    /**
     * get room of event
     * @return room of event
     */
    public int getRoom() {
        return this.room;
    }

    /**
     * set room of event
     * @param room passing value of the event room
     */
    public void setRoom(int room) {
        this.room = room;
    }

    /**
     * gets number of participants for event
     * @return number of participants for the event
     */
    public int getNumberOfParticipants() {
        return this.numberOfParticipants;
    }

    /**
     * set number of participants for event
     * @param numberOfParticipants passing values for number of participants for event
     */
    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }


    // make human readable
    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public void setStartDate(int year, int month, int dayOfMonth, int hour, int minute) {
        startDate = LocalDateTime.of(year, month, dayOfMonth, hour, minute);

    }

    public void addAttendant(String name) {
        attendants.add(name);
    }

    @Override
    // TODO fix the display of date time
    // TODO MAKE HUMAN READABLE
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", time='" + startDate.getHour() + ":"
                + startDate.getMinute() + "'" + ", room='" + getRoom() + "'" + ", numberOfParticipants='"
                + getNumberOfParticipants() + "'" + ", startDate='" + getStartDate() + "'" + "}";
    }

    public String save() {
        return getId() + "," + getName() + "," + getRoom() + "," + getNumberOfParticipants();
    }

    public String saveDateTime() {
        return startDate.getYear() + "," + startDate.getMonthValue() + "," + startDate.getDayOfMonth() + "," + startDate.getHour() + "," + startDate.getMinute();
    }

    public String saveHost() {
        return host.save();
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
