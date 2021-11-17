import java.io.FileNotFoundException;

public class UI {
    private InOut io;

    public UI() throws FileNotFoundException {
        io = new InOut();
    }

    private void userInterface() {
        System.out.println("Hello and welcome to the Alumni program \nPlease enter what you would like to do");
        boolean run = true;
        while (run) {
            System.out.println(" ----------------------------------------------------- ");
            System.out.println(
                    "Please enter a number for what you want to do \n1. for Alumni settings(add, edit, and delete) \n"
                            + "2. for event settings(join, create) \n3. to exit the program");
            int choice = io.intInput();
            switch (choice) {
            case 1:
                alumniInterface();
                break;
            case 2:
                eventInterface();
                break;
            case 3:
                System.out.println("Thanks for using the premium Alumni service");
                run = false;
                break;
            }
        }
    }

    private void alumniInterface() {
        System.out.println("Alumni Interface\n" + "please enter a choice");
        boolean run = true;
        while (run) {
            System.out.println(" ----------------------------------------------------- ");
            System.out.println("1. See a list of current Alumni \n2. Add a new Alumni \n3. Edit Alumni \n"
                    + "4. Delete Alumni \n5. Go back to the main menu");
            int choice = io.intInput();
            switch (choice) {
            case 1:
                // list of alumni
                io.displayAlumni();
                break;
            case 2:
                // Add new alumni
                break;
            case 3:
                // edit Alumni
                break;
            case 4:
                // Delete Alumni
                break;
            case 5:
                // go back to main menu
                break;
            }

        }
    }

    private void eventInterface() {
        System.out.println("Event Interface");
        boolean run = true;
        System.out.println(" ----------------------------------------------------- ");
        while (run) {
            System.out.println("1. See a list of events \n2. Sign up to attend an Event \n3. Make a donation \n"
                    + "4. See my donations \n5. Sign up to speak\n6. Exit");
            int choice = io.intInput();
            switch (choice) {
            case 1:
                // list of events
                io.displayEvents();
                break;
            case 2:
                // sign up for events
                break;
            case 3:
                // make donation
                break;
            case 4:
                // see my donations
                break;
            case 5:
                // sign up to speak
                break;
            case 6:
                // go back to main menu
                break;
            }
        }
    }
}
