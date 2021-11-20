import java.util.Date;


public class Donation {
    
    private String personName;
    private String donationTowards;
    private Double amountDonated;
    private Date dateCreated;
    //Still need receipt?? 

    
    public Donation() {
        dateCreated = new  Date();
    }

    public String getPersonName() {
        return personName;
    }

    public String getDonationTowards() {
        return donationTowards;
    }

    public Double getAmountDonated() {
        return amountDonated;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setDonationTowards(String donationTowards) {
        this.donationTowards = donationTowards;
    }

    public void setAmountDonated(Double amountDonated) {
        this.amountDonated = amountDonated;
    }
}
