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

    public String getSkill(){
        return skill;

    }

    public int getOpenSeats(){
        return openSeats;
    }

    public int getTotal(){
        return total;
    }

    public void setSkill(String newSkill){
         skill = newSkill;
    }

    public void setTotal(int newTotal){
        total = newTotal;
    }

    public void setOpenSeats(){
       openSeats = total - super.getNumberOfParticipants();
    }
    


}
