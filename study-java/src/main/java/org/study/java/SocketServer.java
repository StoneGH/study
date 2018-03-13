package org.study.java;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by shitao on 2017/4/26.
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8800);
        Socket socket = null;
        while (true) {
            socket = serverSocket.accept();
            LoginThread loginThread = new LoginThread(socket);
            loginThread.start();

        }
    }
}

class LoginThread extends Thread {
    Socket socket = null;

    public LoginThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while (!((info = br.readLine()) == null)) {
                System.out.println("我是服务器，客户登录信息为：" + info);
            }
            String reply = "欢迎你，登录成功！";
            os.write(reply.getBytes());
            os.write(reply.getBytes());
            is.close();
            os.close();
            socket.close();
        } catch (Exception e) {

        }
    }
}
