import java.io.*;
import java.net.*;

public class Server {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        System.out.println("Serveur démarré sur le port " + PORT + "...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouveau client connecté : " + clientSocket.getInetAddress());

                // Un thread par client pour gérer plusieurs connexions
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }

        } catch (IOException e) {
            System.err.println("Erreur serveur : " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String message;
            out.println("Bienvenue ! Tapez vos messages (ou 'exit' pour quitter) :");

            while ((message = in.readLine()) != null) {
                System.out.println("Message reçu : " + message);

                if (message.equalsIgnoreCase("exit")) {
                    out.println("Au revoir !");
                    break;
                }

                out.println("Serveur reçu : " + message);
            }

        } catch (IOException e) {
            System.err.println("Erreur client : " + e.getMessage());
        } finally {
            try {
                socket.close();
                System.out.println("Client déconnecté.");
            } catch (IOException e) {
                System.err.println("Erreur fermeture socket : " + e.getMessage());
            }
        }
    }
}