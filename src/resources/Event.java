package resources;

import java.util.ArrayList;

import java.time.LocalDateTime;

/**
 * Holds information relevant to events
 */
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
    private ArrayList<Integer> attendants;

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
     * @param totalSpots  Number of spots available
     * @param startDate   LocalDateTime information about the Event
     * @param attendant   ArrayList of attending members names
     * @param host        Host object for the host of the Event
     * @param guestSpeaker ALumni object passed in as a guest speaker
     */
    public Event(int id, String name, int room, int totalSpots, LocalDateTime startDate,
            ArrayList<Integer> attendant, Host host, Alumni guestSpeaker) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.totalSpots = totalSpots;
        this.openSpots = totalSpots - attendant.size();
        this.spotsFilled = attendant.size();
        this.startDate = startDate;
        this.attendants = attendant;
        this.host = host;
        this.guestSpeaker = guestSpeaker;
    }

    // adding event
    /**
     * Constructor for adding Events
     * 
     * @param id          Event ID
     * @param name        Event Name
     * @param room        Room where Event is happening
     * @param totalSpots  Number of spots available
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

    // ==================== GETTERS ====================

    /**
     * Get guest speaker object
     * @return Guest speaker Alumni object
     */
    public String getGuestSpeaker() {
        if (guestSpeaker != null) {
            return "The Guest Speaker is: " + guestSpeaker.getName();
        } else {
            return "No Guest Speaker";
        }
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
     * Get the Host object of the Event
     * 
     * @return Host object
     */
    public Host getHost() {
        return host;
    }

    public String getHosttoString() {
        return host.toString();
    }

    /**
     * Gets ID of Host
     * 
     * @return Host ID
     */
    public int getHostId() {
        return host.getID();
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
     * Get ID of Event
     * 
     * @return ID of Event
     */
    public int getID() {
        return this.id;
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
     * Get the month that the Event is occurring in
     * 
     * @return Month that the Event is held in
     */
    public int getMonth() {
        return startDate.getMonthValue();
    }

    /**
     * Gets name of Event
     * 
     * @return Event name
     */
    public String getName() {
        return this.name;
    }

    // change this to be total - filled
    public int getOpenSpots() {
        return this.openSpots;
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
     * Gets number of participants for Event
     * 
     * @return Number of participants for the Event
     */
    public int getSpotsFilled() {
        return this.spotsFilled;
    }

    /**
     * Get the total number of spots available
     * 
     * @return number of total spots
     */
    public int getTotalSpots() {
        return this.totalSpots;
    }

    /**
     * Get the year that the Event is occurring in
     * 
     * @return Year that the Event is held in
     */
    public int getYear() {
        return startDate.getYear();
    }

    // ==================== SETTERS ====================

    /**
     * Set the guest speaker
     * 
     * @param alumni Alumni to be guest speaker
     */
    public void setGuestSpeaker(Alumni alumni) {
        guestSpeaker = alumni;
    }

    /**
     * Set name of Event
     * 
     * @param name Name of Event
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setOpenSpots() {
        openSpots = totalSpots - attendants.size();
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
     * Set number of participants for event
     * 
     *  Number of participants attending for the Event
     */
    public void setSpotsFilled() {
        spotsFilled = attendants.size();
    }

    /**
     * Set the date / time information for the Event
     * 
     * @param year   Year of Event
     * @param month  Month of Event
     * @param dayOfMonth Day of event
     * @param hour   Starting hour of Event
     * @param minute Starting minute of Event
     */
    public void setStartDate(int year, int month, int dayOfMonth, int hour, int minute) {
        startDate = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
    }

    /**
     * Set the total number of spots available
     * 
     * @param totalSpots New number of total spots
     */
    public void setTotalSpots(int totalSpots) {
        this.totalSpots = totalSpots;
    }

    // ==================== RAND ====================
    /**
     * Add an attendants name to attending arrayList
     * 
     * @param id ID of attending Alumni
     */
    public void addAttendant(int id) {
        attendants.add(id);
    }

    /**
     * Check the attendant arrayList for a specific id
     * 
     * @param id ID to be checked for
     * @return true if the id is in the list, false if not
     */
    public boolean checkForAttendance(int id) {
        boolean att = false;
        for (int i = 0; i < attendants.size(); i++) {
            if (id == (attendants.get(i))) {
                att = true;
            } else
                att = false;
        }
        return att;
    }

    /**
     * Get the ID # of the attendants for the event
     * 
     * @return ID's of attendants
     */
    public int getAttendants() {
        for (Integer id : attendants) {
            return id;
        }
        return 0;
    }

    /**
     * Format DateTime information to be human readable
     * 
     * @return DateTime info in human readable format
     */
    public String formatDateTime() {
        return startDate.getMonthValue() + "-" + startDate.getDayOfMonth() + "-" + startDate.getYear() + " at "
                + startDate.getHour() + ":" + startDate.getMinute() + "0";
    }

    /**
     * Check to see if there are ANY attendants for an event
     * 
     * @return true if arrayList is empty
     */
    public boolean isEmpty() {
        return attendants.size() == 0;
    }

    @Override
    public String toString() {
        return "ID: " + getID() + " | Name: " + getName() + " | Event Date and Time: "
                + formatDateTime() + " | Event Room Number: " + getRoom() + " | Total Number of Spots: "
                + getTotalSpots() + " | Number of Spots Open: " + getOpenSpots() + " | Number of Spots Filled: "
                + getSpotsFilled() + " | " + getGuestSpeaker();
    }

    // ==================== SAVING ====================
    /**
     * Save the Event's information
     * 
     * @return Event's information formatted to save to text file
     */
    public String save() {
        String guestSpeakerId = "0";
        if (guestSpeaker != null) guestSpeakerId = "" + guestSpeaker.getID();
        return getID() + "%" + getName() + "%" + getRoom() + "%" + getTotalSpots() + "%" + guestSpeakerId;
    }

    /**
     * Save the Event's DateTime information
     * 
     * @return Event's DateTime information formatted to save to text file
     */
    public String saveDateTime() {
        return startDate.getYear() + "%" + startDate.getMonthValue() + "%" + startDate.getDayOfMonth() + "%"
                + startDate.getHour() + "%" + startDate.getMinute();
    }

    /**
     * Save the ID of the guest alumni
     * 
     * @return id of the guest speaker
     */
    public String saveGuestSpeaker() {
        return "" + guestSpeaker.getID();
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
        if (isEmpty())
            return "%";
        else {
            for (int i = 0; i < attendants.size(); i++) {
                if (i == attendants.size() - 1) {
                    x += attendants.get(i);
                } else {
                    x += attendants.get(i) + "%";
                }
            }
        }
        return x;
    }

}
