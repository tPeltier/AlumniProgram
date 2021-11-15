
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InOut {
    
    private Scanner in;
    private File alumniFile;
    private Scanner alumniFileIn; 
    private PrintWriter alumniSaved;
    private File eventFile;
    private Scanner eventFileIn;
    private PrintWriter eventSaved; 
    /**
     * Initiate File, Scanner and PrintWriter
     * @throws FileNotFoundException
     */
    public InOut() throws FileNotFoundException{
        alumniFile = new File("alumni.txt");
        alumniFileIn = new Scanner(alumniFile).useDelimiter(",");
        // alumniSaved = new PrintWriter("alumni.txt");
        eventFile = new File("events.txt");
        eventFileIn = new Scanner(eventFile);
        // eventSaved = new PrintWriter("events.txt");
        in = new Scanner(System.in);
    }


    public void displayAlumni() {
        while (alumniFileIn.hasNext()) {
            System.out.println(alumniFileIn.next());
        }
    }

    public void existingAlumni() {
        while (alumniFileIn.hasNext()){
            
        }
    }
    /**
     * Get User Text Input
     * @return User input : nextLine
     */
    public String stringInput() {
        return in.nextLine();
    }

    /**
     * Get User Integer Input
     * @return User input : int
     */
    public int intInput() {
        return in.nextInt();
    }

    /**
     * Get User Double Input
     * @return User input : double
     */
    public double doubleInput() {
        return in.nextDouble();
    }

}
