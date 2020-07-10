/**
 * Contact :   dzm_1995@163.com
 * <p>
 * Modify Time       Author     Version    Desciption
 * ------------      -------    --------    -----------
 * 2020/7/10 10:34   戴宗明       1.0         None
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件上传案例的服务器端：读取客户端上传的文件，保存到服务器的硬盘，给客户端回写“上传成功”
 *
 * 明确：
 *      数据源：客户端上传的文件
 *      目的地：服务器的硬盘 E:\Java_untitled\\upload\tt.txt
 *
 * 实现步骤：
 *      1. 创建服务器ServerSocket对象和系统要指定的端口号
 *      2. 使用ServerSocket对象中的方法accept，获取到请求的客户端对象Socket
 *      3. 使用Socket对象种的方法getInputStream()获取网络字节输入流InputStream对象
 *      4. 判断E:\\Java_untitled\\upload文件夹是否存在，不存在则创建
 *      5. 创建一个本地字节输出流对象FileOutputStream对象，构造方法中绑定要输出的目的地
 *      6. 使用网络字节输入流InputStream对象种的方法read，读取客户端器发送的数据
 *      7. 使用本地字节输出流对象FileOutputStream对象这个的方法write，把读取到的文件保存到服务器的硬盘上
 *      8. 使用Socket对象种的方法getOutputStream()获取网络字节输出流OutputStream对象
 *      9. 使用网络字节输出流OutputStream对象种的方法write，给客户端回写数据“上传成功”
 *      10. 释放资源(FileOutputStream, Socket， ServerSocket)
 */
public class FileUploadTCPServer {
    public static void main(String[] args) throws IOException {
        // 1. 创建服务器ServerSocket对象和系统要指定的端口号
        ServerSocket serverSocket = new ServerSocket(8880);
        // 2. 使用ServerSocket对象中的方法accept，获取到请求的客户端对象Socket
        Socket socket = serverSocket.accept();
        // 3. 使用Socket对象种的方法getInputStream()获取网络字节输入流InputStream对象
        InputStream inputStream = socket.getInputStream();
        // 4. 判断E:\\Java_untitled\\upload文件夹是否存在，不存在则创建
        File file = new File("E:\\Java_untitled\\upload");
        if (!file.exists()) {
            file.mkdirs();
        }
        // 5. 创建一个本地字节输出流对象FileOutputStream对象，构造方法中绑定要输出的目的地
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\Java_untitled\\upload\\tt.txt");
        // 6. 使用网络字节输入流InputStream对象种的方法read，读取客户端器发送的数据
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            // 7. 使用本地字节输出流对象FileOutputStream对象这个的方法write，把读取到的文件保存到服务器的硬盘上
            fileOutputStream.write(bytes, 0, len);
        }
        // 8. 使用Socket对象种的方法getOutputStream()获取网络字节输出流OutputStream对象
        OutputStream outputStream = socket.getOutputStream();
        // 9. 使用网络字节输出流OutputStream对象种的方法write，给客户端回写数据“上传成功”
        outputStream.write("上传成功".getBytes());
//        System.out.println("上传成功");
        // 10. 释放资源(FileOutputStream, Socket， ServerSocket)
        fileOutputStream.close();
        socket.close();
        serverSocket.close();



    }
}
