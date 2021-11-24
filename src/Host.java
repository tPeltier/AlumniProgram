
public class Host extends Alumni {
    String topic;
    int phoneNumber;

    public Host(String topic, int phoneNumber) {
        super();
        this.topic = topic;
        this.phoneNumber = phoneNumber;
    }

    public Host() {
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
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
