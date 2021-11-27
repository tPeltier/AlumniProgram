import java.util.Date;


public class Donation {
    
    private int alumniId;
    private int eventId;
    private double amountDonated;
    private Date dateCreated;

    /**
     * Empty Donation constructor
     */
    public Donation() {

    }
    
    /**
     * Donation constructor for creating a donation
     * @param alumniId ID of the Alumni making the Donation
     * @param eventId ID of the Event that is being donated to
     * @param donationAmount Amount of money being donated
     */
    public Donation(int alumniId, int  eventId, double donationAmount) {
        dateCreated = new Date();
        this.alumniId = alumniId;
        this.eventId = eventId;
        this.amountDonated = donationAmount;
    }

    /**
     * Get ID of Alumni
     * @return Alumni's id
     */
    public int getAlumniId() {
        return alumniId;
    }

    /**
     * Get ID of the Event
     * @return Event ID
     */
    public int getEventId() {
        return eventId;
    }

    /**
     * Get amount donated to Event
     * @return Donated amount
     */
    public double getAmountDonated() {
        return amountDonated;
    }

    /**
     * Get creation date for Event
     * @return Creation date of Event
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "Date donation was made: " + dateCreated + " Amount Donated: " + amountDonated + " ID of Donator: " + alumniId + " ID of Event: " + eventId;
    }

    /**
     * Save the Donation's information
     * @return Donation's information formatted to save to text file
     */
    public String save() {
        String money = "" + amountDonated;
        return alumniId + "," + eventId + "," + money;
    }
}
