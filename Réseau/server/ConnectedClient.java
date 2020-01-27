package server;

import comm.Message;

public class ConnectedClient implements Runnable{
	public static int idCounter = 0;
	public int id;
	public Server server;
	public Socket socket;
	public ObjectOutputStream out;
	public ObjectInputStream in;

	public ConnectedClient(Server server, Socket socket) {
		this.server = server;
		this.socket = socket;
		this.id = idCounter++;
		out = new ObjectOutputStream(socket.getOutputStream());
		System. out . println("Nouvelle connexion, id = " + id);
	}

	@Override
	public void run() {
		in = new ObjectInputStream(socket.getInputStream());
		boolean isActive = true;
		while (isActive ) {
			Message mess = (Message) in.readObject();
		}
	}
}
