import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class InOut {
    
    private File inputFile;
    private Scanner fileIn; 
    private PrintWriter saved;

    /**
     * Initiate File, Scanner and PrintWriter
     * @throws FileNotFoundException
     */
    public InOut() throws FileNotFoundException{
        inputFile = new File("input.txt");
        fileIn = new Scanner(inputFile);
        saved = new PrintWriter("saved.txt");
    }

    // TEMP METHOD AS DEMO
    public void printFile(LinkedList names) {
        while (fileIn.hasNextLine()) {
            String s = fileIn.nextLine();
            names.add(s);
            System.out.println(s);
        }
    }

    // TEMP METHOD AS DEMO
    public void printToFile(LinkedList names) {
        saved.println(names.toString());
    }

    /**
     * Close Scanner
     */
    public void closeScanner() {
        fileIn.close();
    }

    /**
     * Close PrintWriter and Overwrite file
     */
    public void overrideFile() {
        saved.close();
    }
}
