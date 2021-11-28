import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class UI {
    private int id;
    private InOut io;

    /**
     * Constructor for UI
     * @throws FileNotFoundException
     */
    public UI() throws FileNotFoundException {
        io = new InOut();
    }

    /**
     * Starts and loops the user interface until the user closes the program
     * @throws FileNotFoundException
     */
    public void userInterface() throws FileNotFoundException {
        System.out.println("Hello and welcome to the Alumni program");
        boolean isRunning = true;
        while (isRunning) {
            login();
            loggedIn();
        }

    }

    /**
     * Allows the Alumni to login and assigns their ID to the ID variable
     * @throws FileNotFoundException
     */
    public void login() throws FileNotFoundException {
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("1. Login to existing account \n2. Create a new account \n3. Exit");
            int choice = io.intInput();
            if (choice <1 || choice > 3){
                System.out.println("please enter a valid number");
                choice = io.intInput();
            }
            switch (choice) {
                case 1:
                    System.out.println("Please log in by entering you ID and Password:");
                    System.out.println("ID: ");
                    id = io.intInput();
                    try {
                        if (!io.checkId(id))
                            throw new InvalidEntry("NOT AN EXISTING ID NUMBER");
                    } catch (InvalidEntry p) {
                        System.out.println(p.getMessage());
                        break;
                    }

                    System.out.println("Password: ");
                    String password = io.stringInput();
                    String expectedPw = io.getPassword(id);

                    try {
                        if (password.equals(expectedPw)) {
                            loggedIn = true;
                        } else {
                            throw new InvalidEntry("INVALID PASSWORD");
                        }
                    } catch (InvalidEntry p) {
                        System.out.println(p.getMessage());
                    }
                    break;
                case 2:
                    id = newAlumniInfo();
                    loggedIn = true;
                    break;
                case 3:
                    io.closeEverythingAndSave();
                    System.exit(0);
                    break;
            }
        }
    }
    /**
     * Main menu that is accessed after logging in. Allows Alumni to navigate to Alumni or Event interface.
     * @throws FileNotFoundException
     */
    public void loggedIn() throws FileNotFoundException {
        boolean run = true;
        while (run) {
            System.out.println(" ----------------------------------------------------- ");
            System.out.println("Welcome " + io.getAlumniName(id) + " what would you like to do?");
            System.out.println(
                    "Please enter a number for what you want to do \n1. for Alumni settings(Display, edit, and delete) \n"
                            + "2. for event settings(join, create) \n3. logout");
            int choice = io.intInput();
            if (choice <1 || choice > 3){
                System.out.println("please enter a valid number");
                choice = io.intInput();
            }
            switch (choice) {
                case 1:
                    run = alumniInterface();
                    break;
                case 2:
                    eventInterface();
                    break;
                case 3:
                    // TODO emoji broke D:
                    System.out.println("Thanks for using the premium Alumni service \uD83E\uDD70");
                    System.out.println("----------------------------------------------------- ");
                    run = false;
                    break;
            }
        }
    }

    /**
     * Interface for Handling basic Alumni functions. list/edit/delete
     * @return True or False based on if the Alumni deletes their account
     */
    public boolean alumniInterface() {
        System.out.println("Alumni Interface\n" + "please enter a choice");
        boolean run = true;
        int choice = 0;
        while (run) {
            System.out.println(" ----------------------------------------------------- ");
            System.out.println("1. See a list of current Alumni \n2. Edit your profile info \n"
                    + "3. Delete your account \n4. Go back to the main menu");
            choice = io.intInput();
            if (choice <1 || choice > 4){
                System.out.println("please enter a valid number");
                choice = io.intInput();
            }
            switch (choice) {
                case 1:
                    // list of alumni
                    io.displayAlumni();
                    break;
                case 2:
                    // edit Alumni
                    editAlumni();
                    break;
                case 3:
                    // Delete Alumni
                    deleteAlumni();
                    run = false;
                    break;
                case 4:
                    run = false;
                    // go back to main menu
                    break;
            }
        }
        if (choice == 3)
            return false;
        else
            return true;
    }

    /**
     * Handles basic Event and Training Event functionality. List/Edit/Delete/Donate
     */
    public void eventInterface() {
        System.out.println("Event Interface");
        boolean run = true;
        while (run) {
            System.out.println(" ----------------------------------------------------- ");
            System.out.println(
                    "1. See a list of events \n2. Sign up to attend an Event or training \n3. Make a donation \n"
                            + "4. See my donations \n5. Create Event or Training \n6. Edit event or training event \n7. Delete Event or Training\n8. Exit");
            int choice = io.intInput();
            if (choice <1 || choice > 8){
                System.out.println("please enter a valid number");
                choice = io.intInput();
            }
            switch (choice) {
                case 1:
                    // list of events and training
                    eventViewerSubMenu();
                    break;
                case 2:
                    // sign up for events or training
                   attendEventSubMenu();
                    break;
                case 3:
                    // make donation
                    // TODO maybe include Training
                    addDonation();
                    break;
                case 4:
                    // see my donations
                    displayDonationsAlumni();
                    break;
                case 5:
                    // Creates events and Training events
                    eventCreationSubMenu();
                    break;
                case 6:
                    // edit event or training
                    editEventSubMenu();
                    break;
                case 7:
                    // Delete events and training
                    deletionSubMenu();
                    break;
                case 8:
                    // go back to main menu
                    run = false;
                    break;
            }
        }
    }
    /**
     * Allows Alumni to Edit everything but their ID number
     */
    public void editAlumni() {
        boolean run = true;

        while (run) {
            System.out.println(
                    "what would you like to change? \n1. edit name \n2. edit address \n3. edit major \n4. edit gradYear \n5. edit job \n6. edit organization \n7. change password \n8. exit");
            int choice = io.intInput();
            if (choice <1 || choice > 8){
                System.out.println("please enter a valid number");
                choice = io.intInput();
            }
            switch (choice) {
                case 1:
                    // edit name
                    System.out.println("Enter a new name:");
                    io.setAlumniName(id, io.stringInput());
                    break;

                case 2:
                    // edit address
                    System.out.println("Enter a new Address");
                    io.setAlumniAddress(id, io.stringInput());
                    break;

                case 3:
                    // edit major
                    System.out.println("Enter a new Major:");
                    io.setAlumniMajor(id, io.stringInput());
                    break;

                case 4:
                    // edit gradYear
                    System.out.println("Enter a new Graduation Year:");
                    io.setAlumniGradYear(id, io.stringInput());
                    break;

                case 5:
                    // edit job
                    System.out.println("Enter a new Job:");
                    io.setAlumniJob(id, io.stringInput());
                    break;

                case 6:
                    // edit organization
                    System.out.println("Enter a new organization");
                    io.setAlumniOrg(id, io.stringInput());
                    break;
                case 7:
                    // change password
                    System.out.println("Enter a new password: ");
                    io.setPassword(id, io.stringInput());
                    break;
                case 8:
                    // exit
                    io.displayAlumni();
                    run = false;
                    break;
            }

        }

    }
    /**
     * Allows the user to choose between Editing Events or Editing Training Events
     */
    public void editEventSubMenu() {
        System.out.println(
                "Enter what you would like to do: \n1. Edit events \n2. Edit Training Events \n3. Go back to the main menu ");
        int choice = io.intInput();
        if (choice <1 || choice > 3){
            System.out.println("please enter a valid number");
            choice = io.intInput();
        }
        switch (choice) {
            case 1:
                // edit events
                editEvents();
                break;
            case 2:
                // edit training
                editTrainingEvents();
                break;
            case 3:
                // go back to menu
                break;
        }
    }
    /**
     * Menu for editing everything in events aside from the ID number
     */
    public void editEvents() {
        boolean run = true;
        boolean owner = false;
        int eventID = 0;
        while (!owner) {
            io.displayEvents();
            System.out.println("Enter the event id:");
            eventID = io.intInput();
            try {
                if (id != io.getHostId(eventID)) {
                    throw new InvalidEntry("YOU DID NOT OWN THIS EVENT");
                } else
                    owner = true;
            } catch (InvalidEntry e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        while (run) {
            System.out.println(
                    "What would you like to change?: \n1. event name \n2. event time \n3. event room \n4. Number of participants \n5. event date \n6. exit");
            int choice = io.intInput();
            if (choice <1 || choice > 6){
                System.out.println("please enter a valid number");
                choice = io.intInput();
            }
            switch (choice) {
                case 1:
                    // edit name
                    System.out.println("Enter name of event:");
                    io.setEventName(eventID, io.stringInput());
                    break;

                case 2:
                    // edit time
                    System.out.println("Enter time of event");
                    System.out.println("Enter the hour in 1-24");
                    int hour = io.intInput();
                    System.out.println("Enter the Minute");
                    int minute = io.intInput();
                    io.setEventDateTime(eventID, io.getEventYear(id), io.getEventMonth(id), io.getEventDay(id), hour,
                            minute);
                    break;

                case 3:
                    // edit room
                    System.out.println("Enter event room:");
                    io.setEventRoom(eventID, io.intInput());
                    break;

                case 4:
                    // edit number of participants
                    System.out.println("Enter number of participants:");
                    io.setEventNumberOfParticipants(eventID, io.intInput());
                    break;

                case 5:
                    // edit date
                    System.out.println("Enter date of event:");
                    System.out.println("Enter the year ");
                    int year = io.intInput();
                    System.out.println("Enter the month");
                    int month = io.intInput();
                    System.out.println("Enter the day");
                    int day = io.intInput();
                    io.setEventDateTime(eventID, year, month, day, io.getEventHour(id), io.getEventMin(id));
                    break;

                case 6:
                    // exit
                    System.out.println("NO CHANGES");
                    run = false;
                    break;
            }
        }
    }
    /**
     * Menu for Editing everything in the training event aside from the ID
     */
    public void editTrainingEvents() {
        boolean run = true;
        boolean owner = false;
        int trainingEventID = 0;
        while (!owner) {

            io.displayTraining();
            System.out.println("Enter the training event id:");
            trainingEventID = io.intInput();
            try {
                if (id != io.getHostId(trainingEventID)) {
                    throw new InvalidEntry("YOU DID NOT OWN THIS EVENT");
                } else
                    owner = true;
            } catch (InvalidEntry e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        while (run) {
            System.out.println(
                    "What would you like to change?: \n1. event name \n2. event time \n3. event room \n4. Number of participants \n5. event date \n6. exit");
            int choice = io.intInput();
            if (choice <1 || choice > 8){
                System.out.println("please enter a valid number");
                choice = io.intInput();
            }
            switch (choice) {
                case 1:
                    // edit name
                    System.out.println("Enter name of event:");
                    io.setTrainingName(trainingEventID, io.stringInput());
                    break;

                case 2:
                    // edit time
                    System.out.println("Enter time of event");
                    System.out.println("Enter the hour in 1-24");
                    int hour = io.intInput();
                    System.out.println("Enter the Minute");
                    int minute = io.intInput();
                    io.setTrainingDate(trainingEventID, io.getEventYear(id), io.getEventMonth(id), io.getEventDay(id),
                            hour,
                            minute);
                    break;

                case 3:
                    // edit room
                    System.out.println("Enter event room:");
                    io.setTrainingRoom(trainingEventID, io.intInput());
                    break;

                case 4:
                    // edit number of participants
                    System.out.println("Enter number of participants:");
                    io.setTrainingNumberOfParticipants(trainingEventID, io.intInput());
                    break;

                case 5:
                    // edit date
                    System.out.println("Enter date of event:");
                    System.out.println("Enter the year ");
                    int year = io.intInput();
                    System.out.println("Enter the month");
                    int month = io.intInput();
                    System.out.println("Enter the day");
                    int day = io.intInput();
                    io.setTrainingDate(trainingEventID, year, month, day, io.getEventHour(id), io.getEventMin(id));
                    break;
                case 6:
                    // edit skill
                    System.out.println("enter new skill");
                    String skill = io.stringInput();
                    io.setTrainingSkill(trainingEventID, skill);
                    break;
                case 7:
                    // edit number of seats
                    System.out.println("Enter the new number of seats");
                    int seats = io.intInput();
                    io.setNumOfTotalSeats(trainingEventID, seats);
                    break;
                case 8:
                    // exit
                    System.out.println("NO CHANGES");
                    run = false;
                    break;
            }
        }
    }
    /**
     * Allows the user to Create a new account and enter all their information
     * @return new Alumni Object
     */
    public int newAlumniInfo() {
        System.out.println("Enter the name of the Alumni");
        String name = io.stringInput();
        System.out.println("Enter the Address of the Alumni");
        String address = io.stringInput();
        System.out.println("Enter the Major of the Alumni");
        String major = io.stringInput();
        System.out.println("Enter the Alumni's graduation year");
        String gradYear = io.stringInput();
        System.out.println("Enter the Alumni's current occupation");
        String job = io.stringInput();
        System.out.println("Enter the company that the Alumni Currently works for");
        String organization = io.stringInput();
        System.out.println("Enter a password");
        String password = io.stringInput();
        return io.createAlumni(name, address, major, gradYear, job, organization, password);

    }
    /**
     * Allows the Alumni to Create an event that they will host and enter all relevant information
     */
    public void createEvent() {
        System.out.println("Enter the name of Event");
        String name = io.stringInput();

        System.out.println("Enter date of event:");
        System.out.println("Enter the year ");
        int year = io.intInput();
        System.out.println("Enter the month");
        int month = io.intInput();
        System.out.println("Enter the day");
        int day = io.intInput();
        System.out.println("Enter the hour");
        int hour = io.intInput();
        System.out.println("Enter the minute");
        int minute = io.intInput();
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute);

        System.out.println("Enter the room of Event");
        int room = io.intInput();
        System.out.println("Enter number of participants");
        int numberOfParticipants = io.intInput();
        System.out.println("Enter the topic of the Event:");
        String topic = io.stringInput();
        System.out.println("Enter a phone number where you can be reached: ");
        long phone = io.longInput();
        System.out.println("Enter an email where you can be reached: ");
        String email = io.stringInput();
        // TODO untuck this mess (there's got to be a better way, this copying of an
        // alumni into a host is dumb)
        Host host = new Host(id, io.getAlumniName(id), io.getAlumniAddress(id), io.getAlumniMajor(id),
                io.getAlumniGradYear(id), io.getAlumniJob(id), io.getAlumniOrg(id), topic, phone, email);
        io.createEvent(name, room, numberOfParticipants, dateTime, host);
    }
    /**
     * Allows the Alumni to Create a training event and enter all the relevant information
     */
    public void createTrainingEvent() {
        System.out.println("Enter the name of Event");
        String name = io.stringInput();

        System.out.println("Enter date of event:");
        System.out.println(" ----------------------------------------------------- ");
        System.out.println("Enter the year ");
        int year = io.intInput();
        System.out.println("Enter the month");
        int month = io.intInput();
        System.out.println("Enter the day");
        int day = io.intInput();
        System.out.println("Enter the hour");
        int hour = io.intInput();
        System.out.println("Enter the minute");
        int minute = io.intInput();
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute);

        System.out.println("Enter the room of Event");
        int room = io.intInput();
        System.out.println("Enter number of participants");
        int numberOfParticipants = io.intInput();
        System.out.println("Enter the topic of the Event:");
        String topic = io.stringInput();
        System.out.println("Enter the total number of seats");
        int totalSeats = io.intInput();
        System.out.println("Enter the Skill being trained");
        String skill = io.stringInput();
        System.out.println("Enter a phone number where you can be reached: ");
        long phone = io.longInput();
        System.out.println("Enter an email where you can be reached: ");
        String email = io.stringInput();
        // TODO untuck this mess (there's got to be a better way, this copying of an
        // alumni into a host is dumb)
        Host host = new Host(id, io.getAlumniName(id), io.getAlumniAddress(id), io.getAlumniMajor(id),
                io.getAlumniGradYear(id), io.getAlumniJob(id), io.getAlumniOrg(id), topic, phone, email);
        io.createTrainingEvent(name, room, numberOfParticipants, dateTime, host, skill, totalSeats, totalSeats);
    }
    /**
     * Allows the Alumni to choose to create an Event or Training event
     */
    public void eventCreationSubMenu() {
        System.out.println(
                "Enter what you would to: \n1. Create Event \n2. Create Training event \n3. Go back to the menu");
        int choice = io.intInput();
        if (choice <1 || choice > 3){
            System.out.println("please enter a valid number");
            choice = io.intInput();
        }
        switch (choice) {
            case 1:
                // Create event
                createEvent();
                break;
            case 2:
                // Create Training Event
                createTrainingEvent();
                break;
            case 3:
                // Exit to main menu
                break;
        }
    }
    /**
     * Allows the Alumni to choose between displaying a list of events and Training events
     */
    public void eventViewerSubMenu() {
        System.out.println("Enter what you would like to do: \n1. Display Events \n2. Display Training Events \n3. Return to menu ");
        int choice = io.intInput();
        if (choice <1 || choice > 3){
            System.out.println("please enter a valid number");
            choice = io.intInput();
        }
        switch (choice) {
            case 1:
                // Display events
                io.displayEvents();
                break;
            case 2:
                // Display training events
                io.displayTraining();
                break;
            case 3:
                // Return to the menu
                break;
        }
    }

    //TODO handle seats
    /**
     * Allows the Alumni to choose Whether to join an Event or Training Event
     */
    public void attendEventSubMenu() {
        System.out.println("Enter what you would like to do \n1. Attend an Event \n2. Attend a Training Event \n3. return to menu ");
        int choice = io.intInput();
        if (choice <1 || choice > 3){
            System.out.println("please enter a valid number");
            choice = io.intInput();
        }
        switch (choice) {
            case 1:
            //attend event
            io.displayEvents();
            System.out.println("What Event would you like to attend?");
            io.joinEvent(id, io.getAlumniName(io.intInput()));
                break;
            case 2:
            //attend training
            io.displayTraining();
            System.out.println("What Training Event would you like to attend?");
            io.joinTraining(id, io.getAlumniName(io.intInput()));
                break;
            case 3:
            //exit to menu
                break;
        }
    }

    // ----- donation stuff ------
    /**
     * Method for adding a donation to a specific event
     */
    public void addDonation() {
        System.out.println("Enter the event ID");
        int eventID = io.intInput();
        System.out.println("Enter the amount you would like to donate: ");
        double amountDonated = io.doubleInput();
        io.addDonationToList(id, eventID, amountDonated);
    }

    /**
     * Displays a list of the ALumnis donation
     */
    public void displayDonationsAlumni() {
        io.displayDonationsAlumni(id);
    }
    /**
     * Allows the Alumni to see Donations associated with events
     */
    public void displayDonationsEvents() {
        System.out.println("Enter the event id");
        int id = io.intInput();
        io.displayDonationsEvents(id);
    }

    // --------------Deletion---------------

    /**
     * Method to allow Alumni to Delete their account
     */
    public void deleteAlumni() {
        System.out.println("Are you sure you want to delete this Alumni y/n");
        String confirmation = io.stringInput().toLowerCase();
        if (confirmation.charAt(0) == 'y') {
            io.deleteAlumni(id);
            System.out.println("THIS ACCOUNT HAS BEEN REMOVED");
        }
    }
    /**
     * Method for Deleting Events
     */
    public void deleteEvent() {
        System.out.println("Please enter the ID of the event that you want to delete");
        int eventDeletionID = io.intInput();
        System.out.println("Are you sure you want to delete this event y/n");
        String confirmation = io.stringInput().toLowerCase();
        if (confirmation.charAt(0) == 'y') {
            io.deleteEvent(eventDeletionID);
        }
    }
    /**
     * Method for Deleting Training events
     */
    public void deleteTrainingEvent() {
        System.out.println("please enter the ID of the Training event that you want to delete");
        int trainingDeletionID = io.intInput();
        System.out.println("Are you sure you want to delete this Training Event y/n");
        String confirmation = io.stringInput().toLowerCase();
        if (confirmation.charAt(0) == 'y') {
            io.deleteTraining(trainingDeletionID);
        }
    }
    /**
     * Menu to let Alumni to choose whether to delete an Event or Training event
     */
    public void deletionSubMenu() {
        System.out
                .println("Enter what you want to do \n1. Delete Event \n2. Delete Training \n3. Go back to main menu");
        int choice = io.intInput();
        if (choice <1 || choice > 3){
            System.out.println("please enter a valid number");
            choice = io.intInput();
        }
        switch (choice) {
            case 1:
                // delete event
                deleteEvent();
                break;
            case 2:
                // delete Training
                deleteTrainingEvent();
                break;
            case 3:
                // exit to menu
                break;
        }
    }
}
