/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/10 10:04   戴宗明       1.0         None
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 文件上传案例的客户端：独去本地文件，上传到服务器，读取服务器回写的数据
 *
 * 明确：
 *      数据源：E:\Java_untitled\tt.txt
 *      目的地：服务器
 *
 * 实现步骤：
 *      1. 创建本地字节输入流FIleInputStream对象，构造方法中绑定要读取的数据源
 *      2. 创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号
 *      3. 使用Socket种的方法getOutputStream，获取网络字节输出流OutputStream对象
 *      4. 使用本地字节输入流FIleInputStream对象种的方法read，读取本地文件
 *      5. 使用网络字节输出流OutputStream对象种的方法write，把读取到的文件上传到服务器
 *      6. 使用Socket种的方法getInputStream，获取网络字节输出流InputStream对象
 *      7. 使用网络字节输入流InputStream对象肿得方法read读取服务器回写的数据
 *      8. 释放资源（FileInputStream， Socket）
 */
public class FileUploadTCPClient {
    public static void main(String[] args) throws IOException {
        //1. 创建本地字节输入流FIleInputStream对象，构造方法中绑定要读取的数据源
        FileInputStream fileInputStream = new FileInputStream("E:\\Java_untitled\\tt.txt");

        //2. 创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号
        Socket socket = new Socket("172.18.171.234", 8880);

        //3. 使用Socket种的方法getOutputStream，获取网络字节输出流OutputStream对象
        OutputStream outputStream = socket.getOutputStream();

        //4. 使用本地字节输入流FIleInputStream对象种的方法read，读取本地文件
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fileInputStream.read(bytes)) != -1) {
            //5. 使用网络字节输出流OutputStream对象种的方法write，把读取到的文件上传到服务器
            outputStream.write(bytes, 0, len);
        }
        socket.shutdownOutput();
        //6. 使用Socket种的方法getInputStream，获取网络字节输出流InputStream对象
        InputStream inputStream = socket.getInputStream();

        //7. 使用网络字节输入流InputStream对象肿得方法read读取服务器回写的数据
        int len1 = 0;
        byte[] bytes1 = new byte[1024];
        while ((len1 = inputStream.read(bytes1)) != -1) {
            //5. 使用网络字节输出流OutputStream对象种的方法write，把读取到的文件上传到服务器
            System.out.println(new String(bytes1, 0, len1));
        }

        //8. 释放资源（FileInputStream， Socket）
        fileInputStream.close();
        socket.close();
    }

}
