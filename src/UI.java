import java.io.FileNotFoundException;

public class UI {
    private InOut io;

    public UI() throws FileNotFoundException {
        io = new InOut();
    }

    // hi from me
    public void userInterface() {
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

    public void alumniInterface() {
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
                newAlumniInfo();
                break;
            case 3:
                // edit Alumni
                editAlumni();
                break;
            case 4:
                // Delete Alumni
                System.out.println("Enter the ID of the Alumni you would like to delete");
                io.deleteAlumni(io.intInput());
                break;
            case 5:
                // go back to main menu
                break;
            }

        }
    }

    public void eventInterface() {
        System.out.println("Event Interface");
        boolean run = true;
        while (run) {
            System.out.println(" ----------------------------------------------------- ");
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

    public void editAlumni() {
        boolean run = true;
        while (run) {
            System.out.println("Enter the id of who you want to change");
            io.displayAlumni();
            int id = io.intInput();
            System.out.println(
                    "what would you like to change? \n1. edit name \n2. edit address \n3. edit major \n4. edit gradYear \n5. edit job \n6. edit organization \n7. exit");
            int choice = io.intInput();

            switch (choice) {
            case 1:
                // edit name
                System.out.println("Enter a new name:");
                io.setAlumniName(id, io.stringInput());
                break;

            case 2:
                // edit address
                System.out.println("Enter a new Addres");
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
                System.out.println("Enter a new organizaton");
                io.setAlumniOrg(id, io.stringInput());
                break;

            case 7:
                // exit
                System.out.println("NO CHANGES");
                break;
            }

        }

    }

    public void newAlumniInfo() {
        System.out.println("Enter the name of the Alumni");
        String name = io.stringInput();
        System.out.println("Enter the Address of the Alumni");
        String address = io.stringInput();
        System.out.println("Enter the Major of the Alumni");
        String major = io.stringInput();
        System.out.println("Enter the Alumni's graduation year");
        String gradYear = io.stringInput();
        System.out.println("Enter the Alumnis current occupation");
        String job = io.stringInput();
        System.out.println("Enter the company that the Alumni Currently works for");
        String organization = io.stringInput();
        io.addAlumni(name, address, major, gradYear, job, organization);
    }
}
