public class Training extends Events {
    private String skill;
    private int openSeats;
    private int total;
  
    public Training() {
        super();
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
         skill=newSkill;
    }

    public void setTotal(int newTotal){
        total=newTotal;
    }

    public void setOpenSeats(){
       openSeats=total-super.getNumberOfParticipants();
    }
    


}
