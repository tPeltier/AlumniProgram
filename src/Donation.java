import java.util.Date;


public class Donation {
    
    private int alumniId;
    private int eventId;
    private double amountDonated;
    private Date dateCreated;
    //Still need receipt?? 

    
    public Donation(int alumniId, int  eventId, double donationAmount) {
        dateCreated = new Date();
        this.alumniId = alumniId;
        this.eventId = eventId;
        this.amountDonated = donationAmount;
    }

    public int getAlumniId() {
        return alumniId;
    }

    public int getEventId() {
        return eventId;
    }

    public double getAmountDonated() {
        return amountDonated;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setAlumniId(int alumniId) {
        this.alumniId = alumniId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setAmountDonated(double amountDonated) {
        this.amountDonated = amountDonated;
    }
}
