import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            ChatInterface chatService = new ChatImplementation();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ChatService", chatService);
            System.out.println("Chat server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
