import java.io.IOException;
import java.net.ServerSocket;


public class CheckMainServer {
	
	private static boolean ok;
	private static int SERVER_PORT;
	

	public CheckMainServer(int port) {
		CheckMainServer.SERVER_PORT = port;
	}
	
	public boolean Ok() {
		
		try {
			new ServerSocket(SERVER_PORT);
			ok = true;
		} 
		catch (IOException e) {
			ok = false;
			e.printStackTrace();
		}
		
		return ok;
		
	}

}
