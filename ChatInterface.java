import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatInterface extends Remote {
    void sendMessage(String clientName, String message) throws RemoteException;
    String receiveMessages() throws RemoteException;
}
