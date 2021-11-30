import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class UI {
    private int id;
    private final InOut io;

    /**
     * Constructor for UI
     * 
     * @throws FileNotFoundException
     */
    public UI() throws FileNotFoundException {
        io = new InOut();
    }

    // ==================== MENUS ====================
    /**
     * Starts and loops the user interface until the user closes the program
     * 
     * @throws FileNotFoundException
     */
    public void userInterface() throws FileNotFoundException {
        System.out.println("Hello and Welcome to the Alumni Program!");
        boolean isRunning = true;
        while (isRunning) {
            login();
            loggedIn();
        }

    }

    /**
     * Allows the Alumni to login and assigns their ID to the ID variable
     * 
     * @throws FileNotFoundException
     */
    public void login() throws FileNotFoundException {
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("1. Login to an Existing Account \n2. Create a New Account \n3. Exit");
            int choice = io.intInput(3);
            switch (choice) {
                case 1:
                    System.out.println("-Please enter your ID and Password to Log In-");
                    System.out.println("ID:");
                    id = io.intInput();
                    try {
                        if (!io.checkId(id))
                            throw new InvalidEntry("-!-NOT AN EXISTING ID NUMBER-!-");
                    } catch (InvalidEntry p) {
                        System.out.println(p.getMessage());
                        break;
                    }

                    System.out.println("Password:");
                    String password = io.stringInput();
                    String expectedPw = io.getPassword(id);

                    try {
                        if (password.equals(expectedPw)) {
                            loggedIn = true;
                        } else {
                            throw new InvalidEntry("-!-INVALID PASSWORD-!-");
                        }
                    } catch (InvalidEntry p) {
                        System.out.println(p.getMessage());
                    }
                    break;
                case 2:
                    id = createAlumni();
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
     * Main menu that is accessed after logging in. Allows Alumni to navigate to
     * Alumni or Event interface.
     * 
     * @throws FileNotFoundException
     */
    public void loggedIn() throws FileNotFoundException {
        boolean run = true;
        while (run) {
            System.out.println(" ----------------------------------------------------- ");
            System.out.println("Welcome " + io.getAlumniName(id) + "! Where would you like to go?");
            System.out.println("1. Alumni Menu \n2. Event Menu \n3. Logout");
            int choice = io.intInput(3);
            switch (choice) {
                case 1:
                    run = alumniInterface();
                    break;
                case 2:
                    eventInterface();
                    break;
                case 3:
                    // TODO emoji broke D:
                    // System.out.println("Thanks for using the premium Alumni service
                    // \uD83E\uDD70");
                    System.out.println("Thank You for using the Premium Alumni Service! :D");
                    System.out.println("----------------------------------------------------- ");
                    run = false;
                    break;
            }
        }
    }

    /**
     * Interface for Handling basic Alumni functions. list/edit/delete
     * 
     * @return True or False based on if the Alumni deletes their account
     */
    public boolean alumniInterface() {
        System.out.println("-Alumni Interface-\n" + "Please enter a choice:");
        boolean run = true;
        int choice = 0;
        while (run) {
            System.out.println(" ----------------------------------------------------- ");
            System.out.println(
                    "1. Display a list of Current Alumni \n2. See what Events and Training I'm attending\n3. Edit My Profile Information \n"
                            + "4. Delete my Account \n5. Return to the Main Menu");
            choice = io.intInput(5);
            switch (choice) {
                case 1:
                    // list of alumni
                    io.displayAlumni();
                    break;
                case 2:
                    // Display my Events and Training
                    io.displayMyAttendance(id);
                    break;
                case 3:
                    // edit Alumni
                    editAlumni();
                    break;
                case 4:
                    // Delete Alumni
                    deleteAlumni();
                    run = false;
                    break;
                case 5:
                    run = false;
                    // go back to main menu
                    break;
            }
        }
        // if user deletes account, log out
        return choice != 4;
    }

    /**
     * Handles basic Event and Training Event functionality. List/Edit/Delete/Donate
     */
    public void eventInterface() {
        System.out.println("-Event Interface-\n" + "Please enter a choice:");
        boolean run = true;
        while (run) {
            System.out.println(" ----------------------------------------------------- ");
            System.out.println(
                    "1. Display a list of Events \n2. Sign up to attend an Event or Training \n3. Make a Donation to an Event\n"
                            + "4. See my Donations \n5. Create Event or Training \n6. Edit Event or Training Event \n7. Delete Event or Training\n8. Return to the Main Menu");
            int choice = io.intInput(8);
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

    // ==================== SUBMENUS ====================

    /**
     * Allows the Alumni to choose Whether to join an Event or Training Event
     */
    public void attendEventSubMenu() {
        System.out.println(
                "What you would like to do? \n1. Attend an Event \n2. Attend a Training Event \n3. Return to the Menu ");
        int choice = io.intInput(3);
        switch (choice) {
            case 1:
                // attend event
                io.displayEvents();
                System.out.println("What Event would you like to attend?");
                int eventID = io.intInput();
                if (!io.isExistingEvent(eventID)) {
                    System.out.println("-!-THIS EVENT DOES NOT EXIST-!-");
                } else {
                    if (io.alreadyAttendingEvent(id, eventID)) {
                        System.out.println("-!-YOU ARE ALREADY ATTENDING THIS EVENT-!-");
                    } else {
                        io.joinEvent(eventID, id);
                    }
                }
                break;
            case 2:
                // attend training
                io.displayTraining();
                System.out.println("What Training Event would you like to attend?");
                int trainingID = io.intInput();
                if (!io.isExistingTraining(trainingID)) {
                    System.out.println("-!-THIS TRAINING EVENT DOES NOT EXIST-!-");
                } else {
                    if (io.alreadyAttendingTraining(id, trainingID)) {
                        System.out.println("-!-YOU ARE ALREADY ATTENDING THIS TRAINING EVENT-!-");
                    } else {
                        io.joinTraining(trainingID, id);
                    }
                }
                break;
            case 3:
                // exit to menu
                break;
        }
    }

    private void displayAttendantsSubMenu() {
        System.out.println(
                "Would you like to view attendants for an Event or a Training?\n1. Events\n2. Training\n3. Exit");
        int choice = io.intInput(3);
        switch (choice) {
            case 1:
                // Display attendants for an Event
                io.displayEvents();
                System.out.println("What Event would you like to check?");
                int eventID = io.intInput();
                if (!io.isExistingEvent(eventID)) {
                    System.out.println("-!-THIS EVENT DOES NOT EXIST-!-");
                } else {
                    io.displayAttendantsEvent(eventID);
                }
                break;
            case 2:
                // Display attendants for a Training
                io.displayTraining();
                System.out.println("What Training would you like to check?");
                int trainingID = io.intInput();
                if (!io.isExistingTraining(trainingID)) {
                    System.out.println("-!-THIS TRAINING EVENT DOES NOT EXIST-!-");
                } else {
                    io.displayAttendantsTraining(trainingID);
                }
                break;
            case 3:
                // Return to Menu
                break;
        }
    }

    /**
     * Allows the Alumni to choose to create an Event or Training event
     */
    public void eventCreationSubMenu() {
        System.out.println(
                "What you would to? \n1. Create Event \n2. Create Training Event \n3. Return to the Menu");
        int choice = io.intInput(3);
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
     * Allows the Alumni to choose between displaying a list of events and Training
     * events
     */
    public void eventViewerSubMenu() {
        System.out.println(
                "What you would like to do? \n1. Display Events \n2. Display Training Events \n3. Display Events in a given year\n4. Display All Hosts\n5. Display Attendants for a given Event or Training\n6. Return to the Menu ");
        int choice = io.intInput(6);
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
                // Display Events and Training by Year
                io.displayByYear();
                break;
            case 4:
                // Display Hosts for both events and trainings
                io.displayHosts();
                break;
            case 5:
                // Display Attendants for a given Event or Training
                displayAttendantsSubMenu();
                break;
            case 6:
                // Return to the menu
                break;
        }
    }

    // ==================== EDIT ====================

    /**
     * Allows Alumni to Edit everything but their ID number
     */
    public void editAlumni() {
        boolean run = true;

        while (run) {
            System.out.println(
                    "What would you like to change? \n1. Edit Name \n2. Edit Address \n3. Edit Major \n4. Edit Graduation Year \n5. Edit Job \n6. Edit Organization \n7. Change Password \n8. Exit");
            int choice = io.intInput(8);
            switch (choice) {
                case 1:
                    // edit name
                    System.out.println("Enter a new Name:");
                    io.setAlumniName(id, io.stringInput());
                    break;

                case 2:
                    // edit address
                    System.out.println("Enter a new Address:");
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
                    io.setAlumniGradYear(id, io.intInput());
                    break;

                case 5:
                    // edit job
                    System.out.println("Enter a new Job:");
                    io.setAlumniJob(id, io.stringInput());
                    break;

                case 6:
                    // edit organization
                    System.out.println("Enter a new Organization:");
                    io.setAlumniOrg(id, io.stringInput());
                    break;
                case 7:
                    // change password
                    System.out.println("Enter a new Password:");
                    io.setPassword(id, io.stringInput());
                    break;
                case 8:
                    // exit
                    System.out.println(io.getAlumni(id));
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
                "What you would like to do? \n1. Edit events \n2. Edit Training Events \n3. Return to the Main Menu ");
        int choice = io.intInput(3);
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
        io.displayEvents();
        System.out.println("Enter the Event ID:");
        eventID = io.intInput();
        if (!io.isExistingEvent(eventID)) {
            System.out.println("-!-THIS EVENT DOES NOT EXIST-!-");
        } else {
            while (!owner) {
                try {
                    if (id != io.getHostId(eventID)) {
                        throw new InvalidEntry("-!-YOU DO NOT OWN THIS EVENT-!-");
                    } else
                        owner = true;
                } catch (InvalidEntry e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
            while (run) {
                System.out.println(
                        "What would you like to change?: \n1. Event Name \n2. Event Time \n3. Event Room \n4. Total Number of Spots\n5. Event Date \n6. Exit");
                int choice = io.intInput(6);
                switch (choice) {
                    case 1:
                        // edit name
                        System.out.println("Enter Name of Event:");
                        io.setEventName(eventID, io.stringInput());
                        break;

                    case 2:
                        // edit time
                        // TODO only allow 0-23 and 0-59
                        System.out.println("Enter Time of Event:");
                        System.out.println(" ----------------------------------------------------- ");
                        int hour;
                        int minute;
                        do {
                            System.out.println("Enter the Hour in 0-23:");
                            hour = io.intInput();
                        } while (hour > 23);
                        do {
                            System.out.println("Enter the Minute in 0-59:");
                            minute = io.intInput();
                        } while (minute > 59);
                        io.setEventDateTime(eventID, io.getEventYear(id), io.getEventMonth(id), io.getEventDay(id),
                                hour,
                                minute);
                        break;

                    case 3:
                        // edit room
                        System.out.println("Enter Event Room:");
                        io.setEventRoom(eventID, io.intInput());
                        break;

                    case 4:
                        // edit number of participants
                        System.out.println("Enter Total Number of Spots Available:");
                        io.setNumOfTotalSpotsEvents(id, io.intInput());
                        break;

                    case 5:
                        // edit date
                        System.out.println("Enter Date of Event");
                        System.out.println(" ----------------------------------------------------- ");
                        int year;
                        int month;
                        int day;
                        do {
                            System.out.println("Enter a Year:");
                            year = io.intInput();
                        } while (year < 1000);
                        do {
                            System.out.println("Enter the Month:");
                            month = io.intInput();
                        } while (month > 12);
                        do {
                            System.out.println("Enter the Day:");
                            day = io.intInput();
                        } while (day > 31);
                        io.setEventDateTime(eventID, year, month, day, io.getEventHour(id), io.getEventMin(id));
                        break;

                    case 6:
                        // exit
                        System.out.println(io.getEvent(eventID));
                        run = false;
                        break;
                }
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
        io.displayTraining();
        System.out.println("Enter the Training Event ID:");
        trainingEventID = io.intInput();
        if (!io.isExistingTraining(trainingEventID)) {
            System.out.println("-!-THIS TRAINING EVENT DOES NOT EXIST-!-");
        } else {
            while (!owner) {

                try {
                    if (id != io.getHostId(trainingEventID)) {
                        throw new InvalidEntry("-!-YOU DO NOT OWN THIS TRAINING EVENT-!-");
                    } else
                        owner = true;
                } catch (InvalidEntry e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
            while (run) {
                System.out.println(
                        "What would you like to change?: \n1. Training Event Name \n2. Training Event Time \n3. Training Event Room \n4. Total Number of Spots\n5. Event Date \n6. Edit Skill \n7. Exit");
                int choice = io.intInput(7);
                switch (choice) {
                    case 1:
                        // edit name
                        System.out.println("Enter Name of Event:");
                        io.setTrainingName(trainingEventID, io.stringInput());
                        break;

                    case 2:
                        // edit time
                        System.out.println("Enter Time of Event");
                        System.out.println(" ----------------------------------------------------- ");
                        int hour;
                        int minute;
                        do {
                            System.out.println("Enter the Hour in 0-23:");
                            hour = io.intInput();
                        } while (hour > 23);
                        do {
                            System.out.println("Enter the Minute in 0-59");
                            minute = io.intInput();
                        } while (minute > 59);
                        io.setTrainingDate(trainingEventID, io.getEventYear(id), io.getEventMonth(id),
                                io.getEventDay(id),
                                hour,
                                minute);
                        break;

                    case 3:
                        // edit room
                        System.out.println("Enter Event Room:");
                        io.setTrainingRoom(trainingEventID, io.intInput());
                        break;

                    case 4:
                        // edit number of participants
                        System.out.println("Enter Total Number of Spots Available:");
                        io.setNumOfTotalSpotsTraining(id, io.intInput());
                        break;

                    case 5:
                        // edit date
                        System.out.println("Enter Date of Event");
                        System.out.println(" ----------------------------------------------------- ");
                        int year;
                        int month;
                        int day;
                        do {
                            System.out.println("Enter a Year:");
                            year = io.intInput();
                        } while (year < 1000);
                        do {
                            System.out.println("Enter the Month:");
                            month = io.intInput();
                        } while (month > 12);
                        do {
                            System.out.println("Enter the Day:");
                            day = io.intInput();
                        } while (day > 31);
                        io.setTrainingDate(trainingEventID, year, month, day, io.getEventHour(id), io.getEventMin(id));
                        break;
                    case 6:
                        // edit skill
                        System.out.println("Enter a New Skill");
                        String skill = io.stringInput();
                        io.setTrainingSkill(trainingEventID, skill);
                        break;

                    case 7:
                        // exit
                        System.out.println(io.getTraining(trainingEventID));
                        run = false;
                        break;
                }
            }
        }
    }

    // ==================== CREATE ====================

    /**
     * Allows the user to Create a new account and enter all their information
     * 
     * @return new Alumni Object
     */
    public int createAlumni() {
        System.out.println("Enter the Name of the Alumni:");
        String name = io.stringInput();
        System.out.println("Enter the Address of the Alumni:");
        String address = io.stringInput();
        System.out.println("Enter the Major of the Alumni:");
        String major = io.stringInput();
        System.out.println("Enter the Alumna's Graduation Year:");
        int gradYear = io.intInput();
        System.out.println("Enter the Alumna's current Job Title:");
        String job = io.stringInput();
        System.out.println("Enter the company that the Alumni Currently works for:");
        String organization = io.stringInput();
        String password;
        String checkPw;
        do {
            System.out.println("Enter a Password:");
            password = io.stringInput();
            checkPw = "";
            System.out.println("Re-Enter Password:");
            checkPw = io.stringInput();
        } while (!password.equals(checkPw));
        return io.createAlumni(name, address, major, gradYear, job, organization, password);

    }

    /**
     * Allows the Alumni to Create an event that they will host and enter all
     * relevant information
     */
    public void createEvent() {
        System.out.println("Enter the Name of Event:");
        String name = io.stringInput();

        LocalDateTime dateTime = makeDateTime();

        System.out.println("Enter the Room Number the Event is being held in:");
        int room = io.intInput();
        System.out.println("Enter the Total Number of Spots Available:");
        int totalSpots = io.intInput();
        System.out.println("Enter the your Area of Expertise:");
        String topic = io.stringInput();
        System.out.println("Enter a Phone Number where you can be reached:");
        long phone = io.longInput();
        System.out.println("Enter an Email Address where you can be reached:");
        String email = io.stringInput();
        Host host = new Host(id, io.getAlumniName(id), io.getAlumniAddress(id), io.getAlumniMajor(id),
                io.getAlumniGradYear(id), io.getAlumniJob(id), io.getAlumniOrg(id), topic, phone, email);
        io.createEvent(name, room, totalSpots, dateTime, host);
    }

    /**
     * Allows the Alumni to Create a training event and enter all the relevant
     * information
     */
    public void createTrainingEvent() {
        System.out.println("Enter the Name of Training Event:");
        String name = io.stringInput();

        LocalDateTime dateTime = makeDateTime();

        System.out.println("Enter the Room Number the Training Event is being held in:");
        int room = io.intInput();
        System.out.println("Enter Total Number of Spots Available:");
        int totalSpots = io.intInput();
        System.out.println("Enter the your Area of Expertise:");
        String topic = io.stringInput();
        System.out.println("Enter the Skill being Trained at the Training Event:");
        String skill = io.stringInput();
        System.out.println("Enter a Phone Number where you can be reached:");
        long phone = io.longInput();
        System.out.println("Enter an Email Address where you can be reached: ");
        String email = io.stringInput();
        Host host = new Host(id, io.getAlumniName(id), io.getAlumniAddress(id), io.getAlumniMajor(id),
                io.getAlumniGradYear(id), io.getAlumniJob(id), io.getAlumniOrg(id), topic, phone, email);
        io.createTrainingEvent(name, room, totalSpots, dateTime, host, skill);
    }

    /**
     * Creates and returns a LocalDateTime Object
     * 
     * @return A new LocalDateTime object
     */
    private LocalDateTime makeDateTime() {
        int year;
        int month;
        int day;
        int hour;
        int minute;
        System.out.println("Enter Date of Event:");
        System.out.println(" ----------------------------------------------------- ");
        do {
            System.out.println("Enter a Year:");
            year = io.intInput();
        } while (year < 1000);
        do {
            System.out.println("Enter the Month:");
            month = io.intInput();
        } while (month > 12);
        do {
            System.out.println("Enter the Day:");
            day = io.intInput();
        } while (day > 31);
        do {
            System.out.println("Enter the Hour in 0-23:");
            hour = io.intInput();
        } while (hour > 23);
        do {
            System.out.println("Enter the Minute in 0-59");
            minute = io.intInput();
        } while (minute > 59);
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    // ----- donation stuff ------
    /**
     * Method for adding a donation to a specific event
     */
    public void addDonation() {
        System.out.println("Enter the Event ID:");
        int eventID = io.intInput();
        if (!io.isExistingEvent(eventID)) {
            System.out.println("-!-THIS EVENT DOES NOT EXIST-!-");
        } else {
            System.out.println("Enter the Amount you would like to Donate:");
            double amountDonated = io.doubleInput();
            io.addDonationToList(id, eventID, amountDonated);
        }
    }

    /**
     * Displays a list of the Alumna's donation
     */
    public void displayDonationsAlumni() {
        io.displayDonationsAlumni(id);
    }

    /**
     * Allows the Alumni to see Donations associated with events
     */
    public void displayDonationsEvents() {
        System.out.println("Enter the Event ID:");
        int id = io.intInput();
        if (!io.isExistingTraining(id)) {
            System.out.println("-!-THIS EVENT DOES NOT EXIST-!-");
        } else {
            io.displayDonationsEvents(id);
        }
    }

    // ==================== DELETION ====================

    /**
     * Method to allow Alumni to Delete their account
     */
    public void deleteAlumni() {
        io.getAlumni(id);
        System.out.println("---ARE YOU SURE YOU WANT TO DELETE THIS ALUMNI?---");
        System.out.println("(Y/N)");
        String confirmation = io.stringInput().toLowerCase();
        if (confirmation.charAt(0) == 'y') {
            io.deleteAlumni(id);
            System.out.println("-!-THIS ACCOUNT HAS BEEN REMOVED-!-");
        }
    }

    /**
     * Method for Deleting Events
     */
    public void deleteEvent() {
        boolean owner = false;
        int eventDeletionID = 0;
        io.displayEvents();
        System.out.println("Please enter the ID of the Event that you want to Delete:");
        eventDeletionID = io.intInput();
        if (!io.isExistingEvent(eventDeletionID)) {
            System.out.println("-!-THIS EVENT DOES NOT EXIST-!-");
        } else {
            while (!owner) {

                try {
                    if (id != io.getHostId(eventDeletionID)) {
                        throw new InvalidEntry("-!-YOU DO NOT OWN THIS EVENT-!-");
                    } else
                        owner = true;
                } catch (InvalidEntry e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
            io.getEvent(id);
            System.out.println("---ARE YOU SURE YOU WANT TO DELETE THIS EVENT?---");
            System.out.println("(Y/N)");
            String confirmation = io.stringInput().toLowerCase();
            if (confirmation.charAt(0) == 'y') {
                io.deleteEvent(eventDeletionID);
                System.out.println("-!-THIS EVENT HAS BEEN REMOVED-!-");
            }
        }
    }

    /**
     * Method for Deleting Training events
     */
    public void deleteTrainingEvent() {
        boolean owner = false;
        int trainingDeletionID = 0;
        io.displayTraining();
        System.out.println("Please enter the ID of the Training Event that you want to Delete:");
        trainingDeletionID = io.intInput();
        if (!io.isExistingTraining(trainingDeletionID)) {
            System.out.println("-!-THIS TRAINING EVENT DOES NOT EXIST-!-");

        } else {
            while (!owner) {
                try {
                    if (id != io.getHostId(trainingDeletionID)) {
                        throw new InvalidEntry("YOU DO NOT OWN THIS TRAINING EVENT");
                    } else
                        owner = true;
                } catch (InvalidEntry e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
            io.getTraining(id);
            System.out.println("---ARE YOU SURE YOU WANT TO DELETE THIS TRAINING EVENT?---");
            System.out.println("(Y/N)");
            String confirmation = io.stringInput().toLowerCase();
            if (confirmation.charAt(0) == 'y') {
                io.deleteTraining(trainingDeletionID);
                System.out.println("-!-THIS TRAINING EVENT HAS BEEN REMOVED-!-");
            }
        }
    }

    /**
     * Menu to let Alumni choose whether to delete an Event or Training event
     */
    public void deletionSubMenu() {
        System.out
                .println("Enter what you want to do? \n1. Delete Event \n2. Delete Training \n3. Return to Main Menu");
        int choice = io.intInput(3);
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
