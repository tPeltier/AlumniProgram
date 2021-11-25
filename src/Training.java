public class Training extends Event {
    private String skill;
    private int openSeats;
    private int total;
  
    public Training() {
        super();
    }

    public Training(int id, String name, String time, int room, int numberOfParticipants, String startDate, Host host, String skill, int openSeats, int total) {
        super(id, name, time, room, numberOfParticipants, startDate, host);
        this.skill = skill;
        this.openSeats = openSeats;
        this.total = total;
    }

    /**
     * newskill from training
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
        return total;
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
        total = newTotal;
    }

    /**
     * set open seats for training
     */
    public void setOpenSeats(){
       openSeats = total - super.getNumberOfParticipants();
    }
    


}
