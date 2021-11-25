
import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class App {
    public static void main(String[] group3) throws FileNotFoundException{

        // InOut io = new InOut();
        // UI user = new UI();
        // user.userInterface();
        
        LocalDateTime date1 = LocalDateTime.of(2016, 8, 12, 12, 12);
        
        System.out.println(date1.toString());
        System.out.println(date1.getMonthValue() + "-" + date1.getDayOfMonth() + "-" + date1.getYear() + " @ " + date1.getHour() + ":" + date1.getMinute());
    }
}