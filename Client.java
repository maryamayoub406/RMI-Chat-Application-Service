import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            ChatInterface chatService = (ChatInterface) registry.lookup("ChatService");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name:");
            String clientName = scanner.nextLine();

            while (true) {
                System.out.println("1. Send Message\n2. View Messages\n3. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Enter your message:");
                        String message = scanner.nextLine();
                        chatService.sendMessage(clientName, message);
                        break;

                    case 2:
                        System.out.println("Chat Messages:");
                        System.out.println(chatService.receiveMessages());
                        break;

                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
