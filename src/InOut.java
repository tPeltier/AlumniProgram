import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class InOut {
    
    private Scanner fileIn; 
    private Scanner in;
    private File inputFile;
    private PrintWriter saved;
    /**
     * Initiate File, Scanner and PrintWriter
     * @throws FileNotFoundException
     */
    public InOut() throws FileNotFoundException{
        inputFile = new File("input.txt");
        fileIn = new Scanner(inputFile);
        saved = new PrintWriter("saved.txt");
        in = new Scanner(System.in);
    }

    // TEMP METHOD AS DEMO
    public void displayFile(LinkedList<String> names) {
        while (fileIn.hasNextLine()) {
            String s = fileIn.nextLine();
            names.add(s);
            System.out.println(s);
        }
    }

    // TEMP METHOD AS DEMO
    public void printToFile(LinkedList<String> names) {
        saved.println(names.toString());
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

    /**
     * Close Scanner
     */
    public void closeFileScanner() {
        fileIn.close();
    }

    public void closeUserScanner() {
        in.close();
    }
    /**
     * Close PrintWriter and Overwrite file
     */
    public void saveToFile() {
        saved.close();
    }
}
