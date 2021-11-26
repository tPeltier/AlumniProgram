import java.time.LocalDateTime;

public class Training extends Event {
    private String skill;
    private int openSeats;
    private int totalSeats;
  
    public Training() {
        super();
    }

    public Training(int id, String name, String time, int room, int numberOfParticipants, LocalDateTime startDate, Host host, String skill, int openSeats, int totalSeats) {
        super(id, name, room, numberOfParticipants, startDate, host);
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
    public int getTotal(){
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
    public void setTotal(int newTotal){
        totalSeats = newTotal;
    }

    /**
     * set open seats for training
     */
    public void setOpenSeats(){
       openSeats = totalSeats - super.getNumberOfParticipants();
    }
    


}
