import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ChatImplementation extends UnicastRemoteObject implements ChatInterface {
    private List<String> messages;

    protected ChatImplementation() throws RemoteException {
        super();
        messages = new ArrayList<>();
    }

    @Override
    public void sendMessage(String clientName, String message) throws RemoteException {
        messages.add(clientName + ": " + message);
        System.out.println(clientName + " sent a message: " + message);
    }

    @Override
    public String receiveMessages() throws RemoteException {
        StringBuilder allMessages = new StringBuilder();
        for (String message : messages) {
            allMessages.append(message).append("\n");
        }
        return allMessages.toString();
    }
}
