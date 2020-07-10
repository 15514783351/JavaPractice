/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/9 16:26   戴宗明       1.0         None
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP通信的服务器端：接受客户端的请求，独去客户端发送的数据，给客户端回写数据
 * 表示服务器的类:
 * java.net.ServerSocket:此类实现服务器套接字
 *
 * 构造方法：
 * ServerSocket(int port) 创建绑定到端口的服务器套接字.
 *
 * 服务器必须明确一件事情，必须的知道是哪个客户端请求的服务器
 * 所以可以使用accept方法获取到请求的客户端对象Socket
 * 成员方法：
 *     Socket accept()
 *     侦听并接受此套接字的链接
 *
 * 服务器的实现步骤：
 *      1. 创建服务器ServerSocket对象和系统要制定的端口号
 *      2. 使用ServerSocket对象中的方法accept，获取到请求的客户端对象Socket
 *      3. 使用Socket对象种的方法getInputStream()获取网络字节输入流InputStream对象
 *      4. 使用网络字节输入流InputStream对象种的方法read，读取客户端器发送的数据
 *      5. 使用Socket对象种的方法getOutputStream()获取网络字节输出流OutputStream对象
 *      6. 使用网络字节输出流OutputStream对象种的方法write，给客户端回写数据
 *      7. 释放资源(Socket， ServerSocket)
 */

public class TCPServer {
    public static void main(String[] args) throws IOException {
        // 1. 创建服务器ServerSocket对象和系统要制定的端口号
        ServerSocket serverSocket = new ServerSocket(8898);
        // 2. 使用ServerSocket对象中的方法accept，获取到请求的客户端对象Socket
        Socket socket = serverSocket.accept();
        // 3. 使用Socket对象种的方法getInputStream()获取网络字节输入流InputStream对象
        InputStream inputStream = socket.getInputStream();
        // 4. 使用网络字节输入流InputStream对象种的方法read，读取客户端器发送的数据
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));
        // 5. 使用Socket对象种的方法getOutputStream()获取网络字节输出流OutputStream对象
        OutputStream outputStream = socket.getOutputStream();
        // 6. 使用网络字节输出流OutputStream对象种的方法write，给客户端回写数据
        outputStream.write("收到，谢谢".getBytes());
        // 7. 释放资源(Socket， ServerSocket)
        socket.close();
        serverSocket.close();

    }
}
