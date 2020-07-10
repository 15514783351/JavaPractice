import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/10 9:15   戴宗明       1.0         None
 */


public class TCPCLient1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("172.18.171.234", 8880);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我准备发送了，请接受".getBytes());

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));
        socket.close();
    }
}
