import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args)throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
while (true){
    Socket clientsocked = serverSocket.accept();
    OutputStreamWriter writer = new OutputStreamWriter(clientsocked.getOutputStream());
    writer.write("hello Rukaiia");
    writer.flush();
    writer.close();

}

    }
}