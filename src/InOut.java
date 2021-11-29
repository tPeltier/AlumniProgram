
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
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
    private Scanner trainingFileIn;
    private File donationsFile;
    private File alumniFile;
    private File eventFile;
    private File passwordsFile;
    private File trainingFile;
    private PrintWriter alumniSaved;
    private PrintWriter eventSaved;
    private PrintWriter donationsSaved;
    private PrintWriter passwordsSaved;
    private PrintWriter trainingSaved;
    private TreeMap<Integer, Alumni> alumniMap;
    private TreeMap<Integer, Event> eventMap;
    private TreeMap<Integer, Training> trainingMap;
    private HashMap<Integer, String> passwords;
    private ArrayList<Donation> donationList;

    /**
     * Initiate File, Scanner and PrintWriter
     * Call Methods to fill Maps with existing information
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
        trainingFile = new File("training.txt");
        trainingFileIn = new Scanner(trainingFile);
        in = new Scanner(System.in);
        existingPasswords();
        existingAlumni();
        existingEvents();
        existingDonations();
        existingTrainingEvents();
    }

    /**
     * Save All Information to Files
     * Close all Scanners and PrintWriters
     * 
     * @throws FileNotFoundException
     */
    public void closeEverythingAndSave() throws FileNotFoundException {
        alumniSaved = new PrintWriter("temp.txt");
        eventSaved = new PrintWriter("temp2.txt");
        donationsSaved = new PrintWriter("temp3.txt");
        passwordsSaved = new PrintWriter("temp4.txt");
        trainingSaved = new PrintWriter("temp5.txt");

        for (Alumni alumni : alumniMap.values()) {
            alumniSaved.println(alumni.save());
        }

        for (Event event : eventMap.values()) {
            eventSaved.println(event.save());
            eventSaved.println(event.saveDateTime());
            eventSaved.println(event.saveHost());
            eventSaved.println(event.saveAttendants());

        }

        for (Donation donation : donationList) {
            donationsSaved.println(donation.save());
        }

        for (String pw : passwords.values()) {
            passwordsSaved.println(pw);
        }

        for (Training training : trainingMap.values()) {
            trainingSaved.println(training.save());
            trainingSaved.println(training.saveDateTime());
            trainingSaved.println(training.saveHost());
            trainingSaved.println(training.saveAttendants());
        }

        in.close();
        alumniFileIn.close();
        eventFileIn.close();
        alumniSaved.close();
        eventSaved.close();
        trainingSaved.close();
        donationsSaved.close();
        passwordsSaved.close();

    }

    // ==================== EXISTING ====================

    /**
     * Create and Fill a TreeMap with Alumni Objects from a text file
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
     * Create and fill a ArrayList with Donation Objects from text file
     */
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
     * Create and Fill a TreeMap with Events from a text file
     */
    public void existingEvents() {
        eventMap = new TreeMap<>();
        while (eventFileIn.hasNextLine()) {
            // event info
            String line = eventFileIn.nextLine();
            String[] s = line.split(",");
            int id = Integer.parseInt(s[0]);
            String name = s[1];
            int room = Integer.parseInt(s[2]);
            int totalSpots = Integer.parseInt(s[3]);
            // dateTime info
            String dateTimeString = eventFileIn.nextLine();
            LocalDateTime dateTime = extractDateTime(dateTimeString);
            // host info
            String h = eventFileIn.nextLine();
            Host host = extractHost(h);
            // attending alumni info
            String list = eventFileIn.nextLine();
            ArrayList<String> att = extractAttendants(list);

            Event e = new Event(id, name, room, totalSpots, dateTime, att, host);
            eventMap.put(id, e);
        }
    }

    /**
     * Create and Fill a HashMap with Passwords from text file
     */
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

    /**
     * Create and fill a TreeMap with Training Events from a text file
     */
    public void existingTrainingEvents() {
        trainingMap = new TreeMap<>();
        while (trainingFileIn.hasNextLine()) {
            String line = trainingFileIn.nextLine();
            String[] s = line.split(",");
            int id = Integer.parseInt(s[0]);
            String name = s[1];
            int room = Integer.parseInt(s[2]);
            int totalSpots = Integer.parseInt(s[3]);
            String skill = s[4];
            // dateTime info
            String dateTimeString = trainingFileIn.nextLine();
            LocalDateTime dateTime = extractDateTime(dateTimeString);

            // host info
            String h = trainingFileIn.nextLine();
            Host host = extractHost(h);
            // attending alumni info
            String list = trainingFileIn.nextLine();
            ArrayList<String> att = extractAttendants(list);

            Training t = new Training(id, name, room, totalSpots, dateTime, att, host, skill);
            trainingMap.put(id, t);
        }
    }

    /**
     * Extract Attendants from a string and add them to an ArrayList
     * 
     * @param list Line from text file containing Attendants
     * @return ArrayList of Attendants
     */
    private ArrayList<String> extractAttendants(String list) {
        String[] listArr = list.split(",");
        ArrayList<String> att = new ArrayList<>();
        for (int i = 0; i < listArr.length; i++) {
            att.add(listArr[i]);
        }
        return att;
    }

    /**
     * Extract LocalDateTime information from a string and create a LDT obj
     * 
     * @param dateTimeString Line from text file containing LDT info
     * @return LocalDateTime Object
     */
    private LocalDateTime extractDateTime(String dateTimeString) {
        String[] dt = dateTimeString.split(",");
        int year = Integer.parseInt(dt[0]);
        int month = Integer.parseInt(dt[1]);
        int dayOfMonth = Integer.parseInt(dt[2]);
        int hour = Integer.parseInt(dt[3]);
        int minute = Integer.parseInt(dt[4]);
        LocalDateTime dateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
        return dateTime;
    }

    /**
     * Extract Host information from a string and create a Host obj
     * 
     * @param h Line form text file containing Host info
     * @return Host object
     */
    private Host extractHost(String h) {
        String[] hArr = h.split(",");
        int hostId = Integer.parseInt(hArr[0]);
        String hostName = hArr[1];
        String hostAdd = hArr[2];
        String hostMaj = hArr[3];
        String hostGY = hArr[4];
        String hostJob = hArr[5];
        String hostOrg = hArr[6];
        String topic = hArr[7];
        int phone = Integer.parseInt(hArr[8]);
        String email = hArr[9];
        Host host = new Host(hostId, hostName, hostAdd, hostMaj, hostGY, hostJob, hostOrg, topic, phone, email);
        return host;
    }

    // ==================== GETTERS ====================

    // ----- ALUMNI -----

    /**
     * Get toString call for an Alumni Obj
     * 
     * @param id Alumni ID
     * @return Alumni toString
     */
    public String getAlumni(int id) {
        return alumniMap.get(id).toString();
    }

    /**
     * Get Mailing Address of Alumni
     * 
     * @param id Alumni ID
     * @return Alumni's Mailing Address
     */
    public String getAlumniAddress(int id) {
        return alumniMap.get(id).getAddress();
    }

    /**
     * Get Graduation Year of Alumni
     * 
     * @param id Alumni ID
     * @return Alumni's Graduation Year
     */
    public String getAlumniGradYear(int id) {
        return alumniMap.get(id).getGradYear();
    }

    /**
     * Get Job Tile of ALumni
     * 
     * @param id Alumni ID
     * @return Alumni's Job Title
     */
    public String getAlumniJob(int id) {
        return alumniMap.get(id).getJob();
    }

    /**
     * Get Major of ALumni
     * 
     * @param id Alumni ID
     * @return Alumni's Major
     */
    public String getAlumniMajor(int id) {
        return alumniMap.get(id).getMajor();
    }

    /**
     * Get Name of ALumni
     * 
     * @param id Alumni ID
     * @return Alumni's Name
     */
    public String getAlumniName(int id) {
        return alumniMap.get(id).getName();
    }

    /**
     * Get Employing Organization of Alumni
     * 
     * @param id Alumni ID
     * @return Alumni's Employing Organization
     */
    public String getAlumniOrg(int id) {
        return alumniMap.get(id).getOrganization();
    }

    // ----- EVENTS -----

    /**
     * Get toString call for an Event Obj
     * 
     * @param id Event ID
     * @return Event toString
     */
    public String getEvent(int id) {
        return eventMap.get(id).toString();
    }

    /**
     * Get Host of Event
     * 
     * @param id Event ID
     * @return Event's Host
     */
    public String getEventHost(int id) {
        return eventMap.get(id).getHost();
    }

    /**
     * Get Year of Event
     * 
     * @param id Event ID
     * @return Year in which Event takes place
     */
    public int getEventYear(int id) {
        return eventMap.get(id).getYear();
    }

    /**
     * Get Month of Event
     * 
     * @param id Event ID
     * @return Month in which Event takes place
     */
    public int getEventMonth(int id) {
        return eventMap.get(id).getMonth();
    }

    /**
     * Get Day of Event
     * 
     * @param id Event ID
     * @return Day on which Event takes place
     */
    public int getEventDay(int id) {
        return eventMap.get(id).getDay();
    }

    /**
     * Get Hour of Event
     * 
     * @param id Event ID
     * @return Hour that the Event starts
     */
    public int getEventHour(int id) {
        return eventMap.get(id).getHour();
    }

    /**
     * Get Minute of Event
     * 
     * @param id Event ID
     * @return Minute that the Event starts
     */
    public int getEventMin(int id) {
        return eventMap.get(id).getMinute();
    }

    /**
     * Get ID of Host of Event
     * 
     * @param id Event ID
     * @return Event's Host's ID
     */
    public int getHostId(int id) {
        return eventMap.get(id).getHostId();
    }
    // ----- TRAINING -----

    /**
     * Get toString call for a Training Obj
     * 
     * @param id Training ID
     * @return Training toString
     */
    public String getTraining(int id) {
        return trainingMap.get(id).toString();
    }

    /**
     * Get Host of Training
     * 
     * @param id Training ID
     * @return Training's Host's toString
     */
    public String getTrainingHost(int id) {
        return trainingMap.get(id).getHost();
    }

    // ----- RAND -----

    /**
     * Get Password for Alumni
     * 
     * @param id Alumni ID
     * @return ALumni's Password
     */
    public String getPassword(int id) {
        return passwords.get(id);
    }

    // ==================== SETTERS ====================

    // ----- ALUMNI -----

    /**
     * Set the Mailing Address for Alumni
     * 
     * @param id      Alumni ID
     * @param address New Mailing Address for Alumni
     */
    public void setAlumniAddress(int id, String address) {
        alumniMap.get(id).setAddress(address);
    }

    /**
     * Set the Graduation Year for Alumni
     * 
     * @param id       ALumni ID
     * @param gradYear New Graduation Year for Alumni
     */
    public void setAlumniGradYear(int id, String gradYear) {
        alumniMap.get(id).setGradYear(gradYear);
    }

    /**
     * Set the Job Title for ALumni
     * 
     * @param id  ALumni ID
     * @param job New Job Title for ALumni
     */
    public void setAlumniJob(int id, String job) {
        alumniMap.get(id).setJob(job);
    }

    /**
     * Set the Major for Alumni
     * 
     * @param id    ALumni ID
     * @param major New Major for ALumni
     */
    public void setAlumniMajor(int id, String major) {
        alumniMap.get(id).setMajor(major);
    }

    /**
     * Set Name for Alumni
     * 
     * @param id   Alumni ID
     * @param name New Name for Alumni
     */
    public void setAlumniName(int id, String name) {
        alumniMap.get(id).setName(name);
    }

    /**
     * Set Employing Organization for ALumni
     * 
     * @param id  Alumni ID
     * @param org New Employing Organization for ALumni
     */
    public void setAlumniOrg(int id, String org) {
        alumniMap.get(id).setOrganization(org);
    }

    // ----- EVENTS -----

    /**
     * Set a LocalDateTime for an Event
     * 
     * @param id     Event ID
     * @param year   Year in which Event is happening
     * @param month  Month in which Event is happening
     * @param day    Day on which Event is happening
     * @param hour   Hour that the Event starts
     * @param minute Minute that the Event starts
     */
    public void setEventDateTime(int id, int year, int month, int day, int hour, int minute) {
        eventMap.get(id).setTime(year, month, day, hour, minute);
    }

    /**
     * Set Name for Event
     * 
     * @param id   Event ID
     * @param name New Name for Event
     */
    public void setEventName(int id, String name) {
        eventMap.get(id).setName(name);
    }

    /**
     * Set a Room Number for Event
     * 
     * @param id   Event ID
     * @param room New Room Number for Event
     */
    public void setEventRoom(int id, int room) {
        eventMap.get(id).setRoom(room);
    }

    // ----- TRAINING -----

    /**
     * Set a LocalDateTime for a Training Event
     * 
     * @param id         Training ID
     * @param year       Year in which Training is happening
     * @param month      Month in which Training is happening
     * @param dayOfMonth Day on which Training is happening
     * @param hour       Hour that the Training starts
     * @param minute     Minute that the Training starts
     */
    public void setTrainingDate(int id, int year, int month, int dayOfMonth, int hour, int minute) {
        trainingMap.get(id).setStartDate(year, month, dayOfMonth, hour, minute);
    }

    /**
     * Set Name for Training Event
     * 
     * @param id   Training ID
     * @param name New Name for Training Event
     */
    public void setTrainingName(int id, String name) {
        trainingMap.get(id).setName(name);
    }

    /**
     * Set Room Number for Training Event
     * 
     * @param id   Training ID
     * @param room New Room Number for Training Event
     */
    public void setTrainingRoom(int id, int room) {
        trainingMap.get(id).setRoom(room);
    }

    /**
     * Set Skill for Training Event
     * 
     * @param id       Training ID
     * @param newSkill New Skill for Training Event
     */
    public void setTrainingSkill(int id, String newSkill) {
        trainingMap.get(id).setSkill(newSkill);
    }

    // ----- RAND ----

    /**
     * Set Password for an Alumni
     * 
     * @param id    Alumni ID
     * @param newPw New Password for Alumni
     */
    public void setPassword(int id, String newPw) {
        passwords.put(id, newPw);
    }

    /**
     * Set Total Number of Spots Available at an Event
     * 
     * @param id    Event ID
     * @param spots New Number of Total Available Spots
     */
    public void setNumOfTotalSpotsEvents(int id, int spots) {
        eventMap.get(id).setTotalSpots(spots);
    }

    /**
     * Set Total Number of Spots Available at an Training Event
     * 
     * @param id    Training ID
     * @param spots New number of Total Available Spots
     */
    public void setNumOfTotalSpotsTraining(int id, int spots) {
        trainingMap.get(id).setTotalSpots(spots);
    }

    // ==================== DISPLAY ====================

    /**
     * Display the Alumni Map
     */
    public void displayAlumni() {
        for (Alumni alumni : alumniMap.values()) {
            System.out.println(alumni.toString());
        }
    }

    /**
     * Display Attendants for an Event
     * 
     * @param eventID Event ID
     */
    public void displayAttendantsEvent(int eventID) {
        System.out.println(eventMap.get(eventID).displayAttendants());
    }

    /**
     * Display Attendants for a Training Event
     * 
     * @param trainingID Training ID
     */
    public void displayAttendantsTraining(int trainingID) {
        System.out.println(trainingMap.get(trainingID).displayAttendants());
    }

    /**
     * Display Events and Training Events that happen within a specified year
     * 
     * @param year Year to display
     */
    public void displayByYear(int year) {
        int check = Integer.parseInt(Integer.toString(year).substring(2, 4));
        System.out.println("Events happening in the year " + year);
        for (Event event : eventMap.values()) {
            if (event.getYear() == check)
                System.out.println(event.toString());
        }
        System.out.println("Training happening in the year " + year);
        for (Training training : trainingMap.values()) {
            if (training.getYear() == check)
                System.out.println(training.toString());
        }
    }

    /**
     * Displays the Donations made by an Alumni
     * 
     * @param id Alumni ID
     */
    public void displayDonationsAlumni(int id) {
        for (int i = 0; i < donationList.size(); i++) {
            if (id == donationList.get(i).getAlumniId()) {
                System.out.println("Donation amount" + donationList.get(i).getAmountDonated());
                System.out.println("Date and Time of Donation: " + donationList.get(i).formatDateTime());
            }
        }
    }

    /**
     * Displays the Donations for an Event
     * 
     * @param id Event ID
     */
    public void displayDonationsEvents(int id) {
        for (int i = 0; i < donationList.size(); i++) {
            if (id == donationList.get(i).getEventId()) {
                System.out.println("Donation amount" + donationList.get(i).getAmountDonated());
            }
        }

    }

    /**
     * Display the Events Map and their Host
     */
    public void displayEvents() {
        for (Event events : eventMap.values()) {
            System.out.println(events.toString());
            System.out.println(events.getHost());
        }
    }

    /**
     * Display Host's for both Events and Training
     */
    public void displayHosts() {
        System.out.println("The Hosts for Events are:");
        for (Event events : eventMap.values()) {
            System.out.println("For Event " + events.getID() + " " + events.getHost());
        }
        System.out.println("The Hosts for Trainings are:");
        for (Training training : trainingMap.values()) {
            System.out.println("For Training " + training.getID() + " " + training.getHost());
        }

    }

    /**
     * Display the Events and Training Events that an Alumni is attending
     * 
     * @param id Alumni ID
     */
    public void displayMyAttendance(int id) {
        System.out.println("My Events:");
        int counter = 0;
        for (Event event : eventMap.values()) {
            if (event.checkForAttendance(alumniMap.get(id).getName())) {
                System.out.println("You are attending " + event.getName() + " ID # " + event.getID());
                counter++;
            }
        }
        if (counter == 0)
            System.out.println("Not currently attending any Events");
        counter = 0;
        System.out.println("My Training:");
        for (Training training : trainingMap.values()) {
            if (training.checkForAttendance(alumniMap.get(id).getName())) {
                System.out.println("You are attending " + training.getName() + " ID # " + training.getID());
                counter++;
            }
        }
        if (counter == 0)
            System.out.println("Not currently attending any Training");
    }

    /**
     * Display Training Events and their Host
     */
    public void displayTraining() {
        for (Training training : trainingMap.values()) {
            System.out.println(training.toString());
            System.out.println(training.getHost());
        }
    }

    // ==================== CHECKERS ====================

    /**
     * Check to see if an ALumni's ID exists in the ALumni map
     * 
     * @param id Alumni ID
     * @return Whether the Alumni is in the map or not
     */
    public boolean checkId(int id) {
        for (Alumni alumni : alumniMap.values()) {
            if (id == alumni.getID())
                return true;
        }
        return false;
    }

    /**
     * Check to see if an Alumni is already attending an Event
     * 
     * @param id      Alumni ID
     * @param eventID Event ID
     * @return Whether the ALumni is already attending
     */
    public boolean alreadyAttendingEvent(int id, int eventID) {
        if (eventMap.get(eventID).checkForAttendance(alumniMap.get(id).getName()))
            return true;
        else
            return false;
    }

    /**
     * Check to see if an Alumni is already attending a Training Event
     * 
     * @param id         Alumni ID
     * @param trainingID Training ID
     * @return Whether the Alumni is already attending
     */
    public boolean alreadyAttendingTraining(int id, int trainingID) {
        if (trainingMap.get(trainingID).checkForAttendance(alumniMap.get(id).getName()))
            return true;
        else
            return false;
    }

    /**
     * Checks to see if the Event being requested is in the map
     * @param eventID ID of Event to be checked
     * @return true if Event is in map, false if Event is not in map
     */
    public boolean isExistingEvent(int eventID) {
        if (eventMap.containsKey(eventID)) {
            return true;
        } else return false;
    }

    /**
     * Checks to see if the Training Event being requested is in the map
     * @param eventID ID of Training Event to be checked
     * @return true if Event is in map, false if Training Event is not in map
     */
    public boolean isExistingTraining(int eventID) {
        if (trainingMap.containsKey(eventID)) {
            return true;
        } else return false;
    }
    // ==================== CREATE ====================

    /**
     * Create and place an Alumni Object into the AlumniMap
     * 
     * @param name         Alumni's Name
     * @param address      Alumni's Mailing Address
     * @param major        Alumni's Major
     * @param gradYear     Alumni's Graduation Year
     * @param job          Alumni's Job Title
     * @param organization Alumni's Employing Organization
     * @param password     Alumni's Password
     * @return Alumni's ID
     */
    public int createAlumni(String name, String address, String major, String gradYear, String job,
            String organization,
            String password) {
        int id = alumniMap.lastKey();
        id++;
        Alumni a = new Alumni(id, name, address, major, gradYear, job, organization, password);
        alumniMap.put(id, a);
        return id;
    }

    /**
     * Create and place an Event Object into the EventMap
     * 
     * @param name       Event's Name
     * @param room       Event's Room Number
     * @param totalSpots Total spots available at the Event
     * @param startDate  Starting date for the Event
     * @param host       Event's Host
     */
    public void createEvent(String name, int room, int totalSpots, LocalDateTime startDate, Host host) {
        int id = eventMap.lastKey();
        id++;
        Event e = new Event(id, name, room, totalSpots, startDate, host);
        eventMap.put(id, e);
    }

    /**
     * Create and place a Training Event into the TrainingMap
     * 
     * @param name       Training Event's Name
     * @param room       Training Event's Room Number
     * @param totalSpots Total spots available at the Training Event
     * @param startDate  Starting date for the Training Event
     * @param host       Training Event's Host
     * @param skill      Skill being taught at the Training Event
     */
    public void createTrainingEvent(String name, int room, int totalSpots, LocalDateTime startDate, Host host,
            String skill) {
        int id = trainingMap.lastKey();
        id++;
        Training t = new Training(id, name, room, totalSpots, startDate, host, skill);
        trainingMap.put(id, t);
    }

    // ==================== DELETE ====================

    /**
     * Delete Specified Alumni from ALumniMap
     * 
     * @param id Alumni ID
     */
    public void deleteAlumni(int id) {
        alumniMap.remove(id);
    }

    /**
     * Delete Specified Event from EventMap
     * 
     * @param id Event ID
     */
    public void deleteEvent(int id) {
        eventMap.remove(id);
    }

    /**
     * Delete Specified Training Event from TrainingMap
     * 
     * @param id
     */
    public void deleteTraining(int id) {
        trainingMap.remove(id);
    }

    // ==================== ADDERS ====================

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
     * Register an ALumni (by Name) for an Event
     * 
     * @param id   Event ID
     * @param name Name of attending ALumni
     */
    public void joinEvent(int id, String name) {
        eventMap.get(id).addAttendant(name);
    }

    /**
     * Register an ALumni (by Name) for an Training Event
     * 
     * @param id   Training Event ID
     * @param name Name of attending ALumni
     */
    public void joinTraining(int id, String name) {
        trainingMap.get(id).addAttendant(name);
    }

    // ==================== INPUT====================

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
                System.out.println(" ----------------------------------------------------- ");
                System.out.printf("\"%s\" is not a valid number%n", s);
                System.out.println(" ----------------------------------------------------- ");
            }
            n = in.nextInt();
            if (n < 0) {
                System.out.println(" ----------------------------------------------------- ");
                System.out.println(n + " is not a valid number.");
                System.out.println(" ----------------------------------------------------- ");
            }
            in.nextLine();

        } while (n < 0);
        return n;
    }

    /**
     * Get User Integer Input within a boundary
     * 
     * @return User input : int
     */
    public int intInput(int boundary) {
        int n = 0;
        if (!in.hasNextInt()) {
            String s = in.next();
            System.out.println(" ----------------------------------------------------- ");
            System.out.printf("\"%s\" is not a valid number%n", s);
            System.out.println(" ----------------------------------------------------- ");
            return n;
        }
        n = in.nextInt();
        if (n > boundary || n < 1) {
            System.out.println(" ----------------------------------------------------- ");
            System.out.println(n + " is not a valid number.");
            System.out.println(" ----------------------------------------------------- ");
        }
        in.nextLine();
        return n;
    }

    /**
     * Get User Long input
     * @return User input : Long
     */
    public long longInput() {
        long n;
        do {
            while (!in.hasNextLong()) {
                String s = in.next();
                System.out.println(" ----------------------------------------------------- ");
                System.out.printf("\"%s\" is not a valid number%n", s);
                System.out.println(" ----------------------------------------------------- ");
            }
            n = in.nextLong();
            if (n < 0) {
                System.out.println(" ----------------------------------------------------- ");
                System.out.println(n + " is not a valid number.");
                System.out.println(" ----------------------------------------------------- ");
            }
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
                System.out.println(" ----------------------------------------------------- ");
                System.out.printf("\"%s\" is not a valid number%n", s);
                System.out.println(" ----------------------------------------------------- ");
            }
            n = in.nextDouble();
            if (n < 0) {
                System.out.println(" ----------------------------------------------------- ");
                System.out.println(n + " is not a valid number.");
                System.out.println(" ----------------------------------------------------- ");
            }
            in.nextLine();

        } while (n < 0);
        return n;
    }
}
