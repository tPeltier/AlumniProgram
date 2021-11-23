
public class Host {
    String name;
    String topic;
    int phoneNumber;
    String emailAddress;

    public Host(String name, String topic, int phoneNumber, String emailAddress) {
        this.name = name;
        this.topic = topic;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
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
