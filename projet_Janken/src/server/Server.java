package server;

import java.util.ArrayList;

public class Server {
	public int port;
	public List<ConnectedClients> clients;
// public List<Game> jeuEnCours;

	public Server(int port) {
		this.port = port;
		this.clients = new ArrayList<ConnectedClients>();
		Thread threadConnection = new Thread(new Connection( this));
		threadConnection.start();
	}

	public int getPort() {
		return port;
	}
}
