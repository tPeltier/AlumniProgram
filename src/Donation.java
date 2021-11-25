import java.util.Date;


public class Donation {
    
    private int alumniId;
    private int eventId;
    private double amountDonated;
    private Date dateCreated;

    public Donation() {

    }
    
    public Donation(int alumniId, int  eventId, double donationAmount) {
        dateCreated = new Date();
        this.alumniId = alumniId;
        this.eventId = eventId;
        this.amountDonated = donationAmount;
    }

    /**
     * get id of alumni
     * @return alumni's id
     */
    public int getAlumniId() {
        return alumniId;
    }

    /**
     * get id of the event
     * @return event id
     */
    public int getEventId() {
        return eventId;
    }

    /**
     * gets amount donated for event
     * @return donated amount
     */
    public double getAmountDonated() {
        return amountDonated;
    }

    /**
     * gets creation date for event
     * @return creation date of event
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "Date donation was made: " + dateCreated + " Amount Donated: " + amountDonated + " ID of Donator: " + alumniId + " ID of Event: " + eventId;
    }

    public String save() {
        String money = "" + amountDonated;
        return alumniId + "," + eventId + "," + money;
    }
}
