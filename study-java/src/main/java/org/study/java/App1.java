package org.study.java;


import java.io.*;
import java.net.Socket;

/**
 * Hello world!
 */
public class App1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8800);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        String info = "用户名：Tom，用户密码：123456";
        os.write(info.getBytes());
        socket.shutdownOutput();
        String reply = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while (!((reply = br.readLine()) == null)) {
            System.out.println("我是客户端，服务端的响应为：" + reply);
        }
        os.close();
        is.close();
        socket.close();
    }
}
