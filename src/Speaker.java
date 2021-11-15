
public class Speaker {
    String name;
    String topic;
    int phoneNumber;
    String emailAddress;
    Object untitledField;

    public Speaker(String name, String topic, int phoneNumber, String emailAddress, Object untitledField) {
        this.name = name;
        this.topic = topic;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.untitledField = untitledField;
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

    public Object getUntitledField() {
        return untitledField;
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

    public void setUntitledField(Object untitledField) {
        this.untitledField = untitledField;
    }
    
}
