
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class InOut {

    private Scanner in;
    private Scanner alumniFileIn;
    private Scanner eventFileIn;
    private Scanner donationsFileIn;
    private Scanner passwordFileIn;
    private File donationsFile;
    private File alumniFile;
    private File eventFile;
    private File passwordsFile;
    private PrintWriter alumniSaved;
    private PrintWriter eventSaved;
    private PrintWriter donationsSaved;
    private PrintWriter passwordsSaved;
    private TreeMap<Integer, Alumni> alumniMap;
    private TreeMap<Integer, Event> eventMap;
    private HashMap<Integer, String> passwords;
    private ArrayList<Donation> donationList;

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
        donationsFile = new File("donations.txt");
        donationsFileIn = new Scanner(donationsFile);
        passwordsFile = new File("passwords.txt");
        passwordFileIn = new Scanner(passwordsFile);
        in = new Scanner(System.in);
        existingPasswords();
        existingAlumni();
        existingEvents();
        existingDonations();
    }

    /**
     * Close all Scanners and PrintWriters
     * 
     * @throws FileNotFoundException
     */
    public void closeEverythingAndSave() throws FileNotFoundException {
        alumniSaved = new PrintWriter("temp.txt");
        eventSaved = new PrintWriter("temp2.txt");
        donationsSaved = new PrintWriter("temp3.txt");

        for (Alumni alumni : alumniMap.values()) {
            alumniSaved.println(alumni.save());
        }

        for (Event event : eventMap.values()) {
            eventSaved.println(event.save());
            eventSaved.println(event.saveAttendants());
        }

        for (Donation donation : donationList) {
            donationsSaved.println(donation.save());
        }

        // TODO SAVE DOWN PASSWORDS

        in.close();
        alumniFileIn.close();
        eventFileIn.close();
        alumniSaved.close();
        eventSaved.close();
        donationsSaved.close();

    }

    public void existingPasswords() {
        passwords = new HashMap<>();

        while (passwordFileIn.hasNextLine()) {
            String line = passwordFileIn.nextLine();
            String[] s = line.split(",");
            int id = Integer.parseInt(s[0]);
            String pw = s[1];
            passwords.put(id, pw);
        }

    }

    public String getPassword(int id) {
        return passwords.get(id);
    }

    public void setPassword(int id, String newPw) {
        passwords.put(id, newPw);
    }

    public boolean checkId(int id) {
        for (Alumni alumni : alumniMap.values()) {
            if (id == alumni.getId()) return true;
        }
        return false;
    }

    public void existingDonations() {
        donationList = new ArrayList<>();

        while (donationsFileIn.hasNextLine()) {
            String line = donationsFileIn.nextLine();
            String[] s = line.split(",");
            int alumniID = Integer.parseInt(s[0]);
            int eventID = Integer.parseInt(s[1]);
            double amount = Double.parseDouble(s[2]);
            new Donation(alumniID, eventID, amount);
            donationList.add(new Donation(alumniID, eventID, amount));
        }

    }

    /**
     * Create and Fill a TreeMap of Events pulled from a Text File
     */
    public void existingEvents() {
        eventMap = new TreeMap<>();
        Event e = new Event();
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
            e = new Event(id, name, time, room, numberOfParticipants, startDate, att);
            eventMap.put(id, e);
        }
    }

    /**
     * Create and Fill a TreeMap of Alumni pulled from a Text File
     */
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
            String password = getPassword(id);
            a = new Alumni(id, name, address, major, gradYear, job, organization, password);
            alumniMap.put(id, a);
        }
    }

    /**
     * Display the Events Map
     */
    public void displayEvents() {
        for (Event events : eventMap.values()) {
            System.out.println(events.toString());
        }
    }

    /**
     * Display the Alumni Map
     */
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

    public void addAlumni(String name, String address, String major, String gradYear, String job, String organization, String password) {
        int id = alumniMap.lastKey();
        id++;
        Alumni a = new Alumni(id, name, address, major, gradYear, job, organization, password);
        alumniMap.put(id, a);
    }

    // --------- Event Methods here ---------------

    public void joinEvent(int id, String name) {
        eventMap.get(id).addAttendant(name);
    }

    // -----------Edit Event Methods----------------

    /**
     * sets event name
     * 
     * @param id   event id
     * @param name event name
     */
    public void setName(int id, String name) {
        eventMap.get(id).setName(name);
    }

    /**
     * sets a name for the event
     * 
     * @param id   event id
     * @param time event time
     */
    public void setTime(int id, String time) {
        eventMap.get(id).setTime(time);
    }

    /**
     * sets a room for event
     * 
     * @param id   event id
     * @param room event room
     */
    public void setRoom(int id, int room) {
        eventMap.get(id).setRoom(room);
    }

    /**
     * sets the number of each participant in the event
     * 
     * @param id                   event id
     * @param numberOfParticipants event numberOfParticipants
     */
    public void setNumberOfParticipants(int id, int numberOfParticipants) {
        eventMap.get(id).setNumberOfParticipants(numberOfParticipants);
    }

    /**
     * sets event date
     * 
     * @param id   event id
     * @param date event date
     */
    public void setDate(int id, String date) {
        eventMap.get(id).setStartDate(date);
    }

    // ------- remove --------------
    public void deleteAlumni(int id) {
        alumniMap.remove(id);
    }

    public void deleteEvent(int id) {
        eventMap.remove(id);
    }

    public void createEvent(String name, String time, int room, int numberOfParticipants, String startDate) {
        int id = eventMap.lastKey();
        id++;
        Event e = new Event(id, name, time, room, numberOfParticipants, startDate);
        eventMap.put(id, e);
    }

    // ------- donation list methods ------

    /**
     * Add a Donation and put it in the Donation List
     * 
     * @param alumniId       ID of the ALumni making the donation
     * @param eventId        ID of the Event that the donation is going towards
     * @param donationAmount Amount of the Donation being made
     */
    public void addDonationToList(int alumniId, int eventId, double donationAmount) {
        donationList.add(new Donation(alumniId, eventId, donationAmount));
    }

    /**
     * Displays the Donations made by a certain Alumni
     * 
     * @param id ID of the Alumni
     */
    public void displayDonationsAlumni(int id) {
        for (int i = 0; i < donationList.size(); i++) {
            if (id == donationList.get(i).getAlumniId()) {
                System.out.println("Donation amount" + donationList.get(i).getAmountDonated());
            }
        }
    }

    /**
     * Displays the Donations for a certain Event
     * 
     * @param id ID of the Event
     */
    public void displayDonationsEvents(int id) {
        for (int i = 0; i < donationList.size(); i++) {
            if (id == donationList.get(i).getEventId()) {
                System.out.println("Donation amount" + donationList.get(i).getAmountDonated());
            }
        }

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
            in.nextLine();
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
