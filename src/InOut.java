import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class InOut {
    
    private File inputFile;
    private Scanner fileIn; 
    private PrintWriter saved;

    public InOut() throws FileNotFoundException{
        inputFile = new File("input.txt");
        fileIn = new Scanner(inputFile);
        saved = new PrintWriter("saved.txt");
    }

    public void printFile(LinkedList names) {
        while (fileIn.hasNextLine()) {
            String s = fileIn.nextLine();
            names.add(s);
            System.out.println(s);
        }
    }
    public void printToFile(LinkedList names) {
        saved.println(names.toString());
    }
    public void close() {
        saved.close();
        fileIn.close();
    }
}
