
import java.io.FileNotFoundException;


public class App {
    public static void main(String[] group3) throws FileNotFoundException{

        InOut io = new InOut();
        // io.displayAlumni();
        Alumni[] a = new Alumni[2];
        for (int i = 0; i < a.length; i++) {
           a[i] = io.existingAlumni(); 
           System.out.println(a[i].toString());
        }
        Events[] e = new Events[2];
        for (int i = 0; i < e.length; i++) {
            e[i] = io.existingEvents();
            System.out.println(e[i].toString());
        }
    }
}