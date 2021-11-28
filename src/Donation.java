import java.time.LocalDateTime;
import java.util.Date;

public class Donation {

    private int alumniId;
    private int eventId;
    private double amountDonated;
    private Date dateCreated;
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
        dateCreated = new Date();
        this.alumniId = alumniId;
        this.eventId = eventId;
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
    public Date getDateCreated() {
        return dateCreated;
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

    public void dateToLDT() {
        String date = "" + dateCreated;
        date = date.replaceAll("\\s+", "");
        int month = monthToMonthValue();
        int dayOfMonth = Integer.parseInt(date.substring(6, 8));
        int hour = Integer.parseInt(date.substring(8, 10));
        int minute = Integer.parseInt(date.substring(11, 13));
        int second = Integer.parseInt(date.substring(14, 16));
        int year = Integer.parseInt(date.substring(19, date.length()));
        ldt = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
    }

    public int monthToMonthValue() {
        int month = 0;
        String date = "" + dateCreated;
        date = date.replaceAll("\\s+", "");
        String m = date.substring(3, 6);
        if (m.equals("Jan"))
            month = 1;
        if (m.equals("Feb"))
            month = 2;
        if (m.equals("Mar"))
            month = 3;
        if (m.equals("Apr"))
            month = 4;
        if (m.equals("May"))
            month = 5;
        if (m.equals("Jun"))
            month = 6;
        if (m.equals("Jul"))
            month = 7;
        if (m.equals("Aug"))
            month = 8;
        if (m.equals("Sep"))
            month = 9;
        if (m.equals("Oct"))
            month = 10;
        if (m.equals("Nov"))
            month = 11;
        if (m.equals("Dec"))
            month = 12;
        return month;
    }

    /**
     * Format DateTime information to be human readable
     * 
     * @return DateTime info in human readable format
     */
    public String formatDateTime() {
        dateToLDT();
        return ldt.getMonthValue() + "-" + ldt.getDayOfMonth() + "-" + ldt.getYear() + " at " + ldt.getHour() + ":"
                + ldt.getMinute() + ":" + ldt.getSecond();
    }

    @Override
    public String toString() {
        return "Date donation was made: " + formatDateTime() + " Amount Donated: " + amountDonated + " ID of Donator: "
                + alumniId + " ID of Event: " + eventId;
    }

    /**
     * Save the Donation's information
     * 
     * @return Donation's information formatted to save to text file
     */
    public String save() {
        String money = "" + amountDonated;
        return alumniId + "," + eventId + "," + money;
    }
}
