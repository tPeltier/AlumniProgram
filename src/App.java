import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] group3) throws FileNotFoundException{
        File inputFile = new File("input.txt");
        Scanner fileIn = new Scanner(inputFile);
        PrintWriter saved = new PrintWriter("saved.txt");
        LinkedList names = new LinkedList<>();
        System.out.println("Print Your Name Below:");
        System.out.println("Timothy");
        System.out.println("Andrew");

        System.out.println("Expected Name List:");
        while (fileIn.hasNextLine()) {
            String s = fileIn.nextLine();
            names.add(s);
            System.out.println(s);
        }
        saved.println(names.toString());
        saved.close();
        fileIn.close();
    }
}
