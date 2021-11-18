
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class InOut {

    private Scanner in;
    private Scanner alumniFileIn;
    private Scanner eventFileIn;
    private File alumniFile;
    private File eventFile;
    private PrintWriter alumniSaved;
    private PrintWriter eventSaved;
    private TreeMap<Integer, Alumni> alumniMap;
    private TreeMap<Integer, Events> eventMap;

    /**
     * Initiate File, Scanner and PrintWriter
     * 
     * @throws FileNotFoundException
     */
    public InOut() throws FileNotFoundException {
        alumniFile = new File("alumni.txt");
        alumniFileIn = new Scanner(alumniFile);
        eventFile = new File("events.txt");
        eventFileIn = new Scanner(eventFile);
        in = new Scanner(System.in);
        existingAlumni();
        existingEvents();
    }

    public void closeEverythingAndSave() {
        in.close();
        alumniFileIn.close();
        alumniSaved.close();
        eventFileIn.close();
        eventSaved.close();

    }
    public void existingEvents() {
        eventMap = new TreeMap<>();
        Events e = new Events();
        while (eventFileIn.hasNextLine()) {
            String line = eventFileIn.nextLine();
            String[] s = line.split(",");
            int id = Integer.parseInt(s[0]);
            String name = s[1];
            String time = s[2];
            int room = Integer.parseInt(s[3]);
            int numberOfParticipants = Integer.parseInt(s[4]);
            String startDate = s[5];
            String list = eventFileIn.nextLine();
            String[] listArr = list.split(",");
            ArrayList<String> att = new ArrayList<>();
            for (int i = 0; i < listArr.length; i++) {
                att.add(listArr[i]);
            }
            e = new Events(id, name, time, room, numberOfParticipants, startDate, att);
            eventMap.put(id, e);
        }
    }

    public void existingAlumni() {
        alumniMap = new TreeMap<>();
        Alumni a = new Alumni();
        while (alumniFileIn.hasNextLine()) {
            String line = alumniFileIn.nextLine();
            String[] s = line.split(",");
            int id = Integer.parseInt(s[0]);
            String name = s[1];
            String address = s[2];
            String major = s[3];
            String gradYear = s[4];
            String job = s[5];
            String organization = s[6];
            a = new Alumni(id, name, address, major, gradYear, job, organization);
            alumniMap.put(id, a);
        }
    }

    public void displayEvents() {
        for (Events events : eventMap.values()) {
            System.out.println(events.toString());
        }
    }

    public void displayAlumni() {
        for (Alumni alumni : alumniMap.values()) {
            System.out.println(alumni.toString());
        }
    }

    // ---------- getters -------------- 

    public String getAlumniName(int id) {
        return alumniMap.get(id).getName();
    } 

    public String getAlumniAddress(int id) {
        return alumniMap.get(id).getAddress();
    }

    public String getAlumniMajor(int id) {
        return alumniMap.get(id).getMajor();
    }

    public String getAlumniGradYear(int id) {
        return alumniMap.get(id).getGradYear();
    }

    public String getAlumniJob(int id) {
        return alumniMap.get(id).getJob();
    }

    public String getAlumniOrg(int id) {
        return alumniMap.get(id).getOrganization();
    }
    
    // ---------- setters-------------- 
    public void setAlumniName(int id, String name) {
        alumniMap.get(id).setName(name);
    }

    public void setAlumniAddress(int id, String address) {
        alumniMap.get(id).setAddress(address); 
    }
    
    public void setAlumniMajor(int id, String major) {
        alumniMap.get(id).setMajor(major);
    }
    
    public void setAlumniGradYear(int id, String gradYear) {
        alumniMap.get(id).setGradYear(gradYear); 
    }

    public void setAlumniJob(int id, String job) {
        alumniMap.get(id).setJob(job); 
    }

    public void setAlumniOrg(int id, String org) {
        alumniMap.get(id).setOrganization(org); 
    }

    public void addAlumni(String name, String address, String major, String gradYear, String job, String organization){
        Alumni a = new Alumni(name, address, major, gradYear, job, organization);
        int id = a.getId();
        alumniMap.put(id, a);
    }

    // ------- remove --------------
    public void deleteAlumni(int id){
        alumniMap.remove(id);
    }



    /**
     * Get User Text Input
     * 
     * @return User input : nextLine
     */
    public String stringInput() {
        return in.nextLine();

    }

    /**
     * Get User Integer Input
     * 
     * @return User input : int
     */
    public int intInput() {
        int n;
        do {
            while (!in.hasNextInt()) {
                String s = in.next();
                System.out.printf("\"%s\" is not a valid number", s);
            }
            n = in.nextInt();
        } while (n < 0);
        return n;
    }

    /**
     * Get User Double Input
     * 
     * @return User input : double
     */
    public double doubleInput() {
        double n;
        do {
            while (!in.hasNextDouble()) {
                String s = in.next();
                System.out.printf("\"%s\" is not a valid number", s);
            }
            n = in.nextDouble();
        } while (n < 0);
        return n;
    }

}
