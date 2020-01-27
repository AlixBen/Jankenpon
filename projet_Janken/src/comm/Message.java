package comm;

import java.io.Serializable;

public class Message implements Serializable {
	public String sender;
	public String content;
	public static final long serialVersionUID =1L;

	public Message(String sender, String content) {
		this.sender = sender;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Message{" +
				"sender='" + sender + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}
