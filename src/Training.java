import java.time.LocalDateTime;
import java.util.ArrayList;

public class Training extends Event {
    private String skill;
    private int openSeats;
    private int totalSeats;
  
    /**
     * Empty Training constructor
     */
    public Training() {
        super();
    }


    /**
     * Constructor for creating new Training objects
     * @param id ID of Training Event
     * @param name Name of Training Event
     * @param room Room number of Training Event
     * @param numberOfParticipants Participants of Training Event
     * @param startDate Date/Time of Training Event 
     * @param host Host obj of Training Event
     * @param skill Skill of Training Event
     * @param openSeats Open Seats at Training Event
     * @param totalSeats Total spots of Training Event
     */
    public Training(int id, String name, int room, int numberOfParticipants, LocalDateTime startDate, Host host, String skill, int openSeats, int totalSeats) {
        super(id, name, room, numberOfParticipants, startDate, host);
        this.skill = skill;
        this.openSeats = openSeats;
        this.totalSeats = totalSeats;
    }

    /**
     * Constructor for existing Training objects
     * @param id ID of Training Event
     * @param name Name of Training Event
     * @param room Room number of Training Event
     * @param numberOfParticipants Participants of Training Event
     * @param startDate Date/Time of Training Event 
     * @param att List of names of people attending Training Event
     * @param host Host obj of Training Event
     * @param skill Skill of Training Event
     * @param openSeats Open Seats at Training Event
     * @param totalSeats Total spots of Training Event
     */
    public Training(int id, String name, int room, int numberOfParticipants, LocalDateTime startDate, ArrayList<String> att, Host host, String skill, int openSeats, int totalSeats) {
        super(id, name, room, numberOfParticipants, startDate, att, host);
        this.skill = skill;
        this.openSeats = openSeats;
        this.totalSeats = totalSeats;
    }

    /**
     * Get the skill being taught at the Training
     * @return Skill of Training
     */
    public String getSkill(){
        return skill;

    }

    /**
     * Get open seats of Training
     * @return Open seats of Training
     */
    public int getOpenSeats(){
        return openSeats;
    }

    /**
     * Get total seats of Training
     * @return Total seats of Training
     */
    public int getTotalSeats(){
        return totalSeats;
    }

    /**
     * Set new skill from Training
     * @param newSkill Skill to be taught at Training
     */
    public void setSkill(String newSkill){
         skill = newSkill;
    }

    /**
     * Set total seats of Training
     * @param newTotal Total number of seats available
     */
    public void setTotalSeats(int newTotal){
        totalSeats = newTotal;
    }

    /**
     * Calculate open seats for training
     */
    public void setOpenSeats(){
       openSeats = totalSeats - super.getNumberOfParticipants();
    }
    
    /**
     * Save the Training's information
     * @return Training's information formatted to save to text file
     */
    public String save() {
        // TODO figure out save order
       return  "";
    }

    @Override
    public String toString() {
        return "Training ID: " + super.getID() + " Training Name: " + super.getName() + " Training Date and Time: " + super.formatDateTime() + " Training Room Number: " + super.getRoom() + " Skill taught at event: " + getSkill() + " Number of Participants: " + super.getNumberOfParticipants() + " Number of open seats: " + getOpenSeats() + " Number of total seats: " + getTotalSeats();
    }
    


}
