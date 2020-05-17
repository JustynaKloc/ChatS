import java.util.List;

public interface ChatServiceServer {
    String writeMessage(String message, String id);

    List <String> getMessages(String id);

    String[] getMessagesXMLRPC(String id);

    boolean isIdFree(String id);

    boolean createNewUser(String id);
}