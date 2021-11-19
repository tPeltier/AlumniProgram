
import java.util.Date;


public class Donation {
    
    private String personName;
    private String donationTowards;
    private Double ammountDonated;
    private java.util.Date dateCreated;
    //Still need receipt?? 

    
    public Donation() {
        super();
    }

    public String getPersonName() {
        return personName;
    }

    public String getDonationTowards() {
        return donationTowards;
    }

    public Double getAmmountDonated() {
        return ammountDonated;
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

    public void setAmmountDonated(Double ammountDonated) {
        this.ammountDonated = ammountDonated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    
}