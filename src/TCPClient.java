/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/9 15:26   戴宗明       1.0         None
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP通信的客户端：向服务器发送丽娜姐请求，给服务器发送数据，读取服务器会写的数据
 *
 * 表示客户端的类：
 * java.net.Socket:此类实现客户端套接字（也可以就叫“套接字”）。套接字是两台机器间通信的端点。
 *
 * 套接字：包含了IP地址和端口号的网络单位
 *
 * 构造方法：
 * Socket(String host, int port) 创建一个流套接字并将其连接到指定主机上的指定端口号
 *
 * 参数：
 * String host:服务器主机的名称/服务器的IP地址
 * int port: 服务器的端口号
 *
 * 成员方法：
 * OutputStream getOutputStream() 返回此套接字的输出流
 * InputStream getInputStream() 返回此套接字的输出流
 * void close();
 *
 * 实现步骤
 * 1. 创建一个客户端对象Socket,构造方法绑定服务器的IP地址和端口号
 * 2. 使用Socket对象种的方法getOutputStream()获取网络字节输出流OutputStream对象
 * 3. 使用网络字节输出流OutputStream对象种的方法write，给服务器发送数据
 * 4. 使用Socket对象种的方法getInputStream()获取网络字节输入流InputStream对象
 * 5. 使用网络字节输入流InputStream对象种的方法read，独去服务器诙谐的数据
 * 6.释放资源(Socket)
 *
 * 注意：
 * 1. 客户端和服务器端进行交互，必须使用Socket种提供给的网络流，不能使用自己创建的流对象
 * 2. 当我们创建客户端对象Socket的时候，就回去请求服务器和服务器经过3此握手建立链接通路
 *    这时，如果服务器没有启动，那么就会抛出异常。
 *    如果服务器已经启动，那么就可以交互.
 */

public class TCPClient {
    public static void main(String[] args) throws IOException {
        // 1. 创建一个客户端对象Socket,构造方法绑定服务器的IP地址和端口号
        Socket socket = new Socket("172.18.171.234", 8898);
        // 2. 使用Socket对象种的方法getOutputStream()获取网络字节输出流OutputStream对象
        OutputStream outputStream = socket.getOutputStream();
        // 3. 使用网络字节输出流OutputStream对象种的方法write，给服务器发送数据
        outputStream.write("你好，服务器".getBytes());

        // 4. 使用Socket对象种的方法getInputStream()获取网络字节输入流InputStream对象
        InputStream inputStream = socket.getInputStream();
        // 5. 使用网络字节输入流InputStream对象种的方法read，独去服务器诙谐的数据
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));

        // 6.释放资源(Socket)
        socket.close();

    }
}
