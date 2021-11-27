import java.time.LocalDateTime;
import java.util.ArrayList;

public class Training extends Event {
    private String skill;
    private int openSeats;
    private int totalSeats;
  
    public Training() {
        super();
    }

    // new training
    public Training(int id, String name, int room, int numberOfParticipants, LocalDateTime startDate, Host host, String skill, int openSeats, int totalSeats) {
        super(id, name, room, numberOfParticipants, startDate, host);
        this.skill = skill;
        this.openSeats = openSeats;
        this.totalSeats = totalSeats;
    }

    // existing training
    public Training(int id, String name, int room, int numberOfParticipants, LocalDateTime startDate, ArrayList<String> att, Host host, String skill, int openSeats, int totalSeats) {
        super(id, name, room, numberOfParticipants, startDate, att, host);
        this.skill = skill;
        this.openSeats = openSeats;
        this.totalSeats = totalSeats;
    }

    /**
     * new skill from training
     * @return new skill from training
     */
    public String getSkill(){
        return skill;

    }

    /**
     * get open seats from training
     * @return open seats from training
     */
    public int getOpenSeats(){
        return openSeats;
    }

    /**
     * get total of training
     * @return total of training
     */
    public int getTotalSeats(){
        return totalSeats;
    }

    /**
     * set new skill from training
     * @param newSkill passing value of new skill from training
     */
    public void setSkill(String newSkill){
         skill = newSkill;
    }

    /**
     * set total of training
     * @param newTotal passing value for total of training
     */
    public void setTotalSeats(int newTotal){
        totalSeats = newTotal;
    }

    /**
     * set open seats for training
     */
    public void setOpenSeats(){
       openSeats = totalSeats - super.getNumberOfParticipants();
    }
    
    public String save() {
        // TODO figure out save order
       return  "";
    }

    @Override
    // TODO MAKE HUMAN READABLE
    public String toString() {
        return "{" +
            " ID ='" + super.getId() + "'" +
            ", Name ='" + super.getName() + "'" +
            ", Room ='" + super.getRoom() + "'" +
            ", Number of Participants ='" + super.getNumberOfParticipants() + "'" +
            ", Date ='" + super.getStartDate() + "'" +
            " skill='" + getSkill() + "'" +
            ", openSeats='" + getOpenSeats() + "'" +
            ", totalSeats='" + getTotalSeats() + "'" +
            "}";
    }
    


}
