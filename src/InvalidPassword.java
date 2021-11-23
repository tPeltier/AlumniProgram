import javax.security.auth.login.AccountException;

public class InvalidPassword extends AccountException {
    
    public InvalidPassword(String message) {
        super(message);
    }
}
