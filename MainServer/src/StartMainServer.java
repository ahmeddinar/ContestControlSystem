
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class StartMainServer {

	private ServerSocket server;
	private Socket connection;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private int SERVER_PORT;
	
	public StartMainServer(int port) {
		
		this.SERVER_PORT = port;
		startRunning();
		
	}
	

	public void startRunning() {
		
		try {
			server = new ServerSocket(SERVER_PORT);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Server not startedwith port " + SERVER_PORT, "Error" ,JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void HasClient() {
		
		
		
	}


	public void closeCrap() {
		
		try {
			output.close();
			input.close();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void whileChatting() {

		String message = "You are now connected\n";
		sendMaeesage(message);
		
		do {
			try {
				message = (String) input.readObject();
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} while (!message.equals("CLIENT - END"));
		
	}

	public void waitForConnection() throws IOException {
		
		
		
		connection = server.accept();
		
		
		
	}
	
	
	public void setupStreams() throws IOException {
		
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		
	}
	
	
	public void sendMaeesage(String message) {

		try {
			output.writeObject("SERVER - " + message);
			output.flush();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		
	}


	
	public ServerSocket getServer(){
		return server;
	}

	
}
