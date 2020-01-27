package server;

public class Connection implements Runnable {
	public Server server;
	public ServerSocket serverSocket;

	public Connection(Server server) {
		this.server = server;
		this.serverSocket = new ServerSocket( server.getPort() );
	}

	@Override
	public void run() {
		while(true){
			// TODO try / catch ?
			Socket sockNewClient = serverSocket.accept();
			ConnectedClient newClient = new ConnectedClient( server , sockNewClient);
			server.addClient(newClient);
			Thread threadNewClient = new Thread(newClient);
			threadNewClient.start();
		}
	}
}
