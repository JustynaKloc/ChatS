import java.util.*;

public class ChatServiceServerImpl implements ChatServiceServer {

    List<String> messageListToSend = new ArrayList<>();
    HashMap<String, List<String>> users = new HashMap<>();

    @Override
    public String writeMessage(String message, String id) {

        if (!users.containsKey(id)) {
            users = MessageStorage.addNewUser(id, users);
        }
        users.entrySet().stream().forEach(item->item.getValue().add(id + ": " + message));
        System.out.println("--SERVER--");
        System.out.println(id + " wrote: ");
        System.out.println(message);
        return "Hello from server: " + message;
    }

    @Override
    public List<String> getMessages(String id) {
        messageListToSend = new ArrayList(users.get(id));
        users.get(id).clear();
        return messageListToSend;
    }

    @Override
    public String[] getMessagesXMLRPC(String id) {
        if (!users.get(id).isEmpty()) {
            String[] messagesArrayToSend = new String[users.get(id).size()];
            messagesArrayToSend = users.get(id).toArray(messagesArrayToSend);
            users.get(id).clear();
            return messagesArrayToSend;
        }
        return new String[0];
    }

    @Override
    public boolean isIdFree(String id){
        return !users.containsKey(id);
    }

    @Override
    public boolean createNewUser(String id){
        users.put(id,new ArrayList<>());
        return true;
    }
}

