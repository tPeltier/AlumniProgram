import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] group3) throws FileNotFoundException{
        InOut io = new InOut(); 
        LinkedList names = new LinkedList<>();
        System.out.println("Print Your Name Below:");
        System.out.println("Timothy");
        System.out.println("Andrew");

        System.out.println("Expected Name List:");
        io.printFile(names);
        io.printToFile(names);
        io.close();
    }
}
