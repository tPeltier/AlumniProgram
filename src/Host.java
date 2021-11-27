public class Host extends Alumni {
    String topic;
    long phoneNumber;
    String emailAddress;

    /**
     * Empty Host constructor
     */
    public Host() {
    }
    
    /**
     * Constructor for creating a Host
     * @param id ID of Host Alumni
     * @param name Name of Host Alumni
     * @param address Mailing address of Host Alumni
     * @param major Graduating major of Host Alumni
     * @param gradYear Graduating year of Host Alumni
     * @param job Job title of Host Alumni
     * @param organization Organization of Host Alumni
     * @param topic Topic of Event/Training
     * @param phoneNumber Contact phone number of Host Alumni
     * @param emailAddress Contact email of Host Alumni
     */
    public Host(int id, String name, String address, String major, String gradYear, String job,String organization, String topic, long phoneNumber, String emailAddress) {
        super(id, name, address, major, gradYear, job, organization);
        this.topic = topic;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    /**
     * Get ID of the Host
     * @return Host ID
     */
    public int getHostId() {
        return super.getID();
    }

    /**
     * Get topic of the Event that the Host is holding
     * @return Event topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Get Host phone number
     * @return Host phone number
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get email address of Host
     * @return Email address to Host
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Set topic of the Event that the Host is holding
     * @param topic Event topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Set phone number of Host
     * @param phoneNumber Phone number of Host
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Set email address of Host
     * @param emailAddress Email address of Host
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Save the Host's information
     * @return Host's information formatted to save to text file
     */
    public String save() {
        return super.getID() + "," + super.getName() + "," + super.getAddress() + "," + super.getMajor()  + "," + super.getGradYear() + "," + super.getJob() + "," + super.getOrganization()  + "," + getTopic() + "," + getPhoneNumber() + "," + getEmailAddress();
    }
}
