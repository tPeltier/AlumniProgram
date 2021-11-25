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
            ArrayList<String> attendant, Host host) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.room = room;
        this.numberOfParticipants = numberOfParticipants;
        this.startDate = startDate;
        this.attendants = attendant;
        this.host = host;
    }

    // adding event
    public Event(int id, String name, String time, int room, int numberOfParticipants, String startDate, Host host) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.room = room;
        this.numberOfParticipants = numberOfParticipants;
        this.startDate = startDate;
        this.host = host;
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

    /**
     * get event time
     * @return event time
     */
    public String getTime() {
        return this.time;
    }

    /**
     *set event time
     * @param time passing value of event time
     */
    public void setTime(String time) {
        this.time = time;
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
     * @param room pasing value of the event room
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

    /**
     * get start date of event
     * @return start date of event
     */
    public String getStartDate() {
        return this.startDate;
    }

    /**
     *  set star date of event
     * @param startDate passing values start date of event
     */
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
