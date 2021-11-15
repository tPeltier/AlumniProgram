public class Events {

    String name;
    String time;
    int room;
    int numberOfParticipants;
    String startDate;



    // constructors 
    public Events(){

     }
     public Events(String name, String time,  int room, int numberOfParticipants, String startDate){
         this.name = name;
         this.time = time;
         this. room = room;
         this.numberOfParticipants = numberOfParticipants;
         this.startDate = startDate;
     }


// getters and setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRoom() {
        return this.room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getNumberOfParticipants() {
        return this.numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

}
      