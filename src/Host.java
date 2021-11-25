
public class Host extends Alumni {
    String topic;
    int phoneNumber;
    String emailAddress;

    public Host(int id, String name, String address, String major, String gradYear, String job,String organization, String topic, int phoneNumber, String emailAddress) {
        super(id, name, address, major, gradYear, job, organization);
        this.topic = topic;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public Host() {
    }

    /**
     * get id of the host
     * @return host id
     */
    public int getHostId() {
        return super.getId();
    }

    /**
     * get host tipic
     * @return host topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * get host phone number
     * @return host phone number
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * get email address of host
     * @return email address to host
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * set host topic
     * @param topic passing value of host topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * set phone number of host
     * @param phoneNumber passing value for phone number of host
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * set email address of host
     * @param emailAddress passing value for email address of host
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String save() {
        return super.getId() + "," + super.getName() + "," + super.getAddress() + "," + super.getMajor()  + "," + super.getGradYear() + "," + super.getJob() + "," + super.getOrganization()  + "," + getTopic() + "," + getPhoneNumber() + "," + getEmailAddress();
    }
}
