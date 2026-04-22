import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    private static final String HOST = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        System.out.println("Connexion au serveur " + HOST + ":" + PORT + "...");

        try (
            Socket socket = new Socket(HOST, PORT);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Connecté ! " + in.readLine());

            String userInput;
            while (true) {
                System.out.print("Vous : ");
                userInput = scanner.nextLine();

                out.println(userInput);

                String response = in.readLine();
                System.out.println("Serveur : " + response);

                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
            }

        } catch (ConnectException e) {
            System.err.println("Impossible de se connecter. Le serveur est-il démarré ?");
        } catch (IOException e) {
            System.err.println("Erreur connexion : " + e.getMessage());
        }

        System.out.println("Déconnecté du serveur.");
    }
}