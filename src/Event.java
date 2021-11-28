import java.util.ArrayList;
import java.time.LocalDateTime;

public class Event implements CommonMethods {
    private int id;
    private int room;
    private int openSpots;
    private int totalSpots;
    private int spotsFilled;
    private String name;
    private LocalDateTime startDate;
    private Host host;
    private Alumni guestSpeaker;
    private ArrayList<String> attendants;

    /**
     * Empty Event constructor
     */
    public Event() {
        // empty
    }

    // existing event
    /**
     * Constructor for existing Events
     * 
     * @param id          Event ID
     * @param name        Event Name
     * @param room        Room where Event is happening
     * @param spotsFilled Number of people participating
     * @param startDate   LocalDateTime information about the Event
     * @param attendant   ArrayList of attending members names
     * @param host        Host object for the host of the Event
     */
    public Event(int id, String name, int room, int totalSpots, LocalDateTime startDate,
            ArrayList<String> attendant, Host host) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.totalSpots = totalSpots;
        this.openSpots = totalSpots - attendant.size();
        this.spotsFilled = attendant.size();
        this.startDate = startDate;
        this.attendants = attendant;
        this.host = host;
    }

    // adding event
    /**
     * Constructor for adding Events
     * 
     * @param id          Event ID
     * @param name        Event Name
     * @param room        Room where Event is happening
     * @param spotsFilled Number of people participating
     * @param startDate   LocalDateTime information about the Event
     * @param host        Host object for the host of the Event
     */
    public Event(int id, String name, int room, int totalSpots, LocalDateTime startDate, Host host) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.totalSpots = totalSpots;
        this.startDate = startDate;
        this.host = host;
        attendants = new ArrayList<>();
    }

    /**
     * Get guest speaker obj
     * 
     * @return Guest speaker Alumni object
     */
    public Alumni getAlumni() {
        return guestSpeaker;
    }

    /**
     * Set the guest speaker
     * 
     * @param alumni Alumni to be guest speaker
     */
    public void setAlumni(Alumni alumni) {
        guestSpeaker = alumni;
    }

    /**
     * Get ID of Event
     * 
     * @return ID of Event
     */
    public int getID() {
        return this.id;
    }

    /**
     * Gets ID of Host
     * 
     * @return Host ID
     */
    public int getHostId() {
        return host.getID();
    }

    public String getHost() {
        return host.toString();
    }

    /**
     * Gets name of Event
     * 
     * @return Event name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set name of Event
     * 
     * @param name Name of Event
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the year that the Event is occurring in
     * 
     * @return Year that the Event is held in
     */
    public int getYear() {
        return startDate.getYear();
    }

    /**
     * Get the month that the Event is occurring in
     * 
     * @return Month that the Event is held in
     */
    public int getMonth() {
        return startDate.getMonthValue();
    }

    /**
     * Get the day that the Event is occurring on
     * 
     * @return Day that the Event is held on
     */
    public int getDay() {
        return startDate.getDayOfMonth();
    }

    /**
     * Get the hour that the Event starts
     * 
     * @return Hour that the Event starts
     */
    public int getHour() {
        return startDate.getHour();
    }

    /**
     * Get the minute that the Event starts
     * 
     * @return Minute that the Event starts
     */
    public int getMinute() {
        return startDate.getMinute();
    }

    /**
     * Set the date / time information for the Event
     * 
     * @param year   Year of Event
     * @param month  Month of Event
     * @param day    Day of Event
     * @param hour   Starting hour of Event
     * @param minute Starting minute of Event
     */
    public void setTime(int year, int month, int day, int hour, int minute) {
        this.startDate = LocalDateTime.of(year, month, day, hour, minute);
    }

    // TODO these methods are the same, we need to pick one
    public void setStartDate(int year, int month, int dayOfMonth, int hour, int minute) {
        startDate = LocalDateTime.of(year, month, dayOfMonth, hour, minute);

    }

    /**
     * Get room number of Event
     * 
     * @return Room number of Event
     */
    public int getRoom() {
        return this.room;
    }

    /**
     * Set room number of event
     * 
     * @param room Room Number of Event
     */
    public void setRoom(int room) {
        this.room = room;
    }

    /**
     * Gets number of participants for Event
     * 
     * @return Number of participants for the Event
     */
    public int getSpotsFilled() {
        return this.spotsFilled;
    }

    /**
     * Set number of participants for event
     * 
     * @param spotsFilled Number of participants for the Event
     */
    public void setSpotsFilled() {
        spotsFilled = attendants.size();
    }

    public int getTotalSpots() {
        return this.totalSpots;
    }

    public void setTotalSpots(int totalSpots) {
        this.totalSpots = totalSpots;
    }

    public void setOpenSpots() {
        openSpots = totalSpots - attendants.size();
    }

    // change this to be total - filled
    public int getOpenSpots() {
        return this.openSpots;
    }

    /**
     * Add an attendants name to attending arrayList
     * 
     * @param name Name of attending Alumni
     */
    public void addAttendant(String name) {
        attendants.add(name);
    }

    public boolean checkForAttendance(String name) {
        boolean att = false;
        for (int i = 0; i < attendants.size(); i++) {
            if (name.equals(attendants.get(i))) {
                att = true;
            } else
                att = false;
        }
        return att;
    }

    /**
     * Format DateTime information to be human readable
     * 
     * @return DateTime info in human readable format
     */
    public String formatDateTime() {
        return startDate.getMonthValue() + "-" + startDate.getDayOfMonth() + "-" + startDate.getYear() + " at "
                + startDate.getHour() + ":" + startDate.getMinute();
    }

    @Override
    public String toString() {
        return "Event ID: " + getID() + " |" + " Event Name: " + getName() + " |" + " Event Date and Time: "
                + formatDateTime() + " |" + " Event Room Number: " + getRoom() + " |" + " Total Number of Spots: "
                + getTotalSpots() + " |" + " Number of Spots Open: " + getOpenSpots() + " |"
                + "Number of Spots Filled: " + getSpotsFilled();
    }

    /**
     * Save the Event's information
     * 
     * @return Event's information formatted to save to text file
     */
    public String save() {
        return getID() + "," + getName() + "," + getRoom() + "," + getTotalSpots();
    }

    /**
     * Save the Event's DateTime information
     * 
     * @return Event's DateTime information formatted to save to text file
     */
    public String saveDateTime() {
        return startDate.getYear() + "," + startDate.getMonthValue() + "," + startDate.getDayOfMonth() + ","
                + startDate.getHour() + "," + startDate.getMinute();
    }

    /**
     * Save the Event's Host
     * 
     * @return The save() call for the Host
     */
    public String saveHost() {
        return host.save();
    }

    /**
     * Save the Event's attendant list
     * 
     * @return Event's attendant list formatted to save to text file
     */
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
