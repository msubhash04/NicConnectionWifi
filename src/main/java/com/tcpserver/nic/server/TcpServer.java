package com.tcpserver.nic.server;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class TcpServer {

    private final int port = 5000;
    private final ExecutorService pool = Executors.newFixedThreadPool(10);

//    public void start() {
//        new Thread(() -> {
//            try (ServerSocket serverSocket = new ServerSocket(port)) {
//                System.out.println("TCP Server started on port: " + port);
//
//                while (true) {
//
//                    Socket clientSocket = serverSocket.accept();  // <-- Client connected
//
//                    // 🔥 Add these here (immediately after accept)
//                    clientSocket.setKeepAlive(true);
//                    clientSocket.setSoTimeout(0); // Never auto-timeout
//
//                    System.out.println("Client connected: " + clientSocket.getInetAddress());
//
//                    // Pass the socket to worker thread
//                    pool.execute(new ClientHandler(clientSocket));
//                }
//
//            } catch (IOException e) {
//                System.err.println("TCP Server error: " + e.getMessage());
//            }
//        }).start();
//    }

//    public void start() {
//        new Thread(() -> {
//            try (ServerSocket serverSocket = new ServerSocket(
//                    port,
//                    50,
//                    InetAddress.getByName("::")   // Bind to IPv6 ANY address
//            )) {
//                System.out.println("TCP Server started on IPv6 port: " + port);
//
//                while (true) {
//                    Socket clientSocket = serverSocket.accept();
//
//                    clientSocket.setKeepAlive(true);
//                    clientSocket.setSoTimeout(0);
//
////                    System.out.println("Client connected: " + clientSocket.getInetAddress());
//
//                    InetAddress clientAddr = clientSocket.getInetAddress();
//
//                    System.out.println("Client connected:");
//                    System.out.println("  Host Address : " + clientAddr.getHostAddress());   // IPv4/IPv6
//                    System.out.println("  Full Address : " + clientAddr);
//
//                    pool.execute(new ClientHandler(clientSocket));
//                }
//
//            } catch (IOException e) {
//                System.err.println("TCP Server error: " + e.getMessage());
//            }
//        }).start();
//    }

    public void start() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(
                    port,
                    50,
                    InetAddress.getByName("::")   // Bind to IPv6 ANY address
            )) {

                // 👉 PRINT SERVER'S IPv4 + IPv6 BEFORE starting the server
                InetAddress[] serverAddrs = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());
                System.out.println("Server is listening on:");
                for (InetAddress addr : serverAddrs) {
                    System.out.println("  " + addr.getHostAddress());
                }

                // Existing message
                System.out.println("TCP Server started on IPv6 port: " + port);

                while (true) {
                    Socket clientSocket = serverSocket.accept();

                    clientSocket.setKeepAlive(true);
                    clientSocket.setSoTimeout(0);

                    InetAddress clientAddr = clientSocket.getInetAddress();

                    System.out.println("Client connected:");
                    System.out.println("  Host Address : " + clientAddr.getHostAddress());
                    System.out.println("  Full Address : " + clientAddr);

                    pool.execute(new ClientHandler(clientSocket));
                }

            } catch (IOException e) {
                System.err.println("TCP Server error: " + e.getMessage());
            }
        }).start();
    }


}

