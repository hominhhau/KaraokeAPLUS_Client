package client;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    private Socket socket;
    private ObjectOutputStream outObj;
    private ObjectInputStream in;
    private static final String SERVER_HOST = "MSI";
    private static final int SERVER_PORT = 7900;

    public Client() {

    }

    public void connect() throws IOException {
        socket = new Socket(SERVER_HOST, SERVER_PORT);
        outObj = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());

    }

    public ObjectOutputStream getOutObj() {
        return outObj;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public void close() {
        try {
            if (socket != null) {
                socket.close();
            }
            if (outObj != null) {
                outObj.close();
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reconnect() {
        close();
        try {
            connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
