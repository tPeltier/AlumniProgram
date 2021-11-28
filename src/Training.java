import java.time.LocalDateTime;
import java.util.ArrayList;

public class Training extends Event {
    private String skill;

    /**
     * Empty Training constructor
     */
    public Training() {
        super();
    }

    // adding training
    /**
     * Constructor for creating new Training objects
     * 
     * @param id         ID of Training Event
     * @param name       Name of Training Event
     * @param room       Room number of Training Event
     * @param totalSpots Total spots available
     * @param startDate  Date/Time of Training Event
     * @param host       Host obj of Training Event
     * @param skill      Skill of Training Event
     * @param openSeats  Open Seats at Training Event
     * @param totalSeats Total spots of Training Event
     */
    public Training(int id, String name, int room, int totalSpots, LocalDateTime startDate, Host host, String skill) {
        super(id, name, room, totalSpots, startDate, host);
        this.skill = skill;
    }

    // existing training
    /**
     * Constructor for existing Training objects
     * 
     * @param id         ID of Training Event
     * @param name       Name of Training Event
     * @param room       Room number of Training Event
     * @param totalSpots Total spots available
     * @param startDate  Date/Time of Training Event
     * @param att        List of names of people attending Training Event
     * @param host       Host obj of Training Event
     * @param skill      Skill of Training Event
     * @param openSeats  Open Seats at Training Event
     * @param totalSeats Total spots of Training Event
     */
    public Training(int id, String name, int room, int totalSpots, LocalDateTime startDate, ArrayList<String> att,
            Host host, String skill) {
        super(id, name, room, totalSpots, startDate, att, host);
        this.skill = skill;
    }

    // ==================== GETTERS ====================

     /**
     * Get the skill being taught at the Training
     * 
     * @return Skill of Training
     */
    public String getSkill() {
        return skill;

    }

    // ==================== SETTERS ====================

    /**
     * Set new skill from Training
     * 
     * @param newSkill Skill to be taught at Training
     */
    public void setSkill(String newSkill) {
        skill = newSkill;
    }
    // ==================== RAND ====================

    @Override
    public String toString() {
        return "Training ID: " + super.getID() + " |" + " Training Name: " + super.getName() + " |"
                + " Training Date and Time: " + super.formatDateTime() + " |" + " Training Room Number: "
                + super.getRoom() + " |" + " Number of total seats: " + super.getTotalSpots() + " |"
                + " Number of Spots Open: " + super.getOpenSpots() + " |" + " Number of Spots Filled: "
                + super.getSpotsFilled() + " |" + " Skill taught at event: " + getSkill();
    }

    // ==================== SAVING ====================

    /**
     * Save the Training's information
     * 
     * @return Training's information formatted to save to text file
     */
    public String save() {
        return super.save() + "," + getSkill();
    }

}
