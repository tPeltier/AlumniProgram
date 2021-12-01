import java.time.LocalDateTime;

public class Donation {

    private int alumniId;
    private int eventId;
    private double amountDonated;
    private LocalDateTime ldt;

    /**
     * Empty Donation constructor
     */
    public Donation() {

    }

    /**
     * Donation constructor for creating a donation
     * 
     * @param alumniId       ID of the Alumni making the Donation
     * @param eventId        ID of the Event that is being donated to
     * @param donationAmount Amount of money being donated
     */
    public Donation(int alumniId, int eventId, double donationAmount) {
        this.ldt = LocalDateTime.now();
        this.alumniId = alumniId;
        this.eventId = eventId;
        this.amountDonated = donationAmount;
    }

    /**
     * Existing Donation constructor
     * 
     * @param alumniID       ID of the Alumni making the Donation
     * @param eventID        ID of the Event that is being donated to
     * @param donationAmount Amount of money being donated
     * @param ldt            LocalDateTime obj of donation creation
     */
    public Donation(int alumniID, int eventID, double donationAmount, LocalDateTime ldt) {
        this.ldt = ldt;
        this.alumniId = alumniID;
        this.eventId = eventID;
        this.amountDonated = donationAmount;
    }

    // ==================== GETTERS ====================

    /**
     * Get amount donated to Event
     * 
     * @return Donated amount
     */
    public double getAmountDonated() {
        return amountDonated;
    }

    /**
     * Get ID of Alumni
     * 
     * @return Alumni's id
     */
    public int getAlumniId() {
        return alumniId;
    }

    /**
     * Get creation date for Event
     * 
     * @return Creation date of Event
     */
    public LocalDateTime getDateCreated() {
        return ldt;
    }

    /**
     * Get ID of the Event
     * 
     * @return Event ID
     */
    public int getEventId() {
        return eventId;
    }

    // ==================== RAND ====================

    /**
     * Format DateTime information to be human readable
     * 
     * @return DateTime info in human readable format
     */
    public String formatDateTime() {
        return ldt.getMonthValue() + "-" + ldt.getDayOfMonth() + "-" + ldt.getYear() + " at " + ldt.getHour() + ":"
                + ldt.getMinute() + ":" + ldt.getSecond();
    }

    @Override
    public String toString() {
        return " Amount Donated: " + amountDonated + " | Date donation was made: " + formatDateTime()
                + " | ID of Donator: "
                + alumniId + " | ID of Event: " + eventId;
    }

    /**
     * Save the Donation's information
     * 
     * @return Donation's information formatted to save to text file
     */
    public String save() {
        String donation = "" + amountDonated;
        return alumniId + "%" + eventId + "%" + donation + "%" + ldt.getYear() + "%" + ldt.getMonthValue() + "%"
                + ldt.getDayOfMonth() + "%" + ldt.getHour() + "%" + ldt.getMinute() + "%" + ldt.getSecond();
    }
}
