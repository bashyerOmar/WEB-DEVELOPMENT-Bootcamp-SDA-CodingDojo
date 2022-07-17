package alfredBot;
import java.util.Date;

public class  AlfredQoutes {


    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        return String.format ("Hello, %s. Lovely to see you.",name);
    }

    public String guestGreeting(String name , String dayPeriod) { //overloading with dayPeriod
        return String.format ("Good %s , %s. Lovely to see you.",dayPeriod,name);
    }
    
    public String dateAnnouncement() {
        Date currentdate = new Date();
        return String.format ("It is currently %s",currentdate);
    }
    
    public String respondBeforeAlexis(String conversation) {

        if (conversation.indexOf("Alexis") != -1) { //Alexis found in the conversation
           return "Right away, sir";
        }else if (conversation.indexOf("Alfred") != -1){ // Alfred found in the conversation
           return "At your service";
        }
        
        return "with that I shall retire."; // neither Alexis nor Alfred in the conversation
    }
    
}

