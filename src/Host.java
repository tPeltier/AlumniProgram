
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

    public String getTopic() {
        return topic;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
