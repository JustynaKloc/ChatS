import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageStorage {

    public static HashMap addNewUser (String id, HashMap<String, List<String>> users){
        List <String> messagesOfUser = new ArrayList<>();
        users.put(id, messagesOfUser);
        return users;
    }
}
