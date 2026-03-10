package com.tcpserver.nic.client;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

@Component
public class TcpClient {

    // Example IPv6: replace with your real IPv6 address
    private final String serverIpv6 = "2401:4900:33bf:cd6f:2:1:6947:2417";
    private final int serverPort = 5601;

    public void startClient() {
        new Thread(() -> {
            int i=1;
            while (true) {
                try {
                    InetAddress inet6 = InetAddress.getByName(serverIpv6);
                    Socket socket = new Socket(inet6, serverPort);

                    System.out.println("TCP IPv6 Client Connected to server [" + serverIpv6 + "]:" + serverPort);

                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    // ========== THREAD 1: RECEIVE MESSAGES ==========
                    new Thread(() -> {
                        try {
                            String line;
                            while ((line = in.readLine()) != null) {
                                System.out.println("Received from Server: " + line);
                            }
                        } catch (Exception ex) {
                            System.out.println("Error reading from server: " + ex.getMessage());
                        }
                    }).start();

                    // ========== THREAD 2: SEND MESSAGES ==========
                    while (true) {
                        String msg = "Hello - " + (i++) ;
                        out.println(msg);
                        System.out.println("Sent: " + msg);

                        Thread.sleep(5000);
                    }

                } catch (Exception e) {
                    System.out.println("IPv6 Client cannot connect… retrying in 3 seconds: " + e);
                    try { Thread.sleep(3000); } catch (InterruptedException ignored) {}
                }
            }
        }).start();
    }

}




//@Component
//public class TcpClient {
//
//    private final String serverIp = "10.197.228.230";  // or remote server IP
//    private final int serverPort = 5000;          // or any port
//
//    public void startClient() {
//        new Thread(() -> {
//            while (true) {
//                try (Socket socket = new Socket(serverIp, serverPort)) {
//                    System.out.println("TCP Client Connected to server " + serverIp + ":" + serverPort);
//
//                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//
//                    // Send data every 5 seconds
//                    while (true) {
//                        String msg = "HelloFromClient_" + System.currentTimeMillis();
//                        out.println(msg);
//                        System.out.println("Sent: " + msg);
//
//                        Thread.sleep(5000);
//                    }
//
//                } catch (Exception e) {
//                    System.out.println("Client cannot connect… retrying in 3 seconds");
//                    try { Thread.sleep(3000); } catch (InterruptedException ignored) {}
//                }
//            }
//        }).start();
//    }
//}

