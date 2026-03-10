package com.tcpserver.nic.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

//    @Override
//    public void run() {
//        try (BufferedReader in =
//                     new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
//
//            String raw;
//            while ((raw = in.readLine()) != null) {
//                System.out.println("Received: " + raw);
//                DataPipeline.process(raw);
//            }
//
//        } catch (IOException e) {
//            System.out.println("Client disconnected: " + socket.getInetAddress());
//        }
//    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            byte[] buffer = new byte[2048];

            long lastSend = System.currentTimeMillis();

            while (true) {
                int len = in.read(buffer);

                if (len == -1) {
                    System.out.println("Device disconnected: " + socket.getInetAddress());
                    break;
                }

                if (len > 0) {
                    String received = new String(buffer, 0, len);
                    System.out.println("Received: " + received);


                    // 🔥 Send keep-alive every 20 seconds
                    if (System.currentTimeMillis() - lastSend > 20000) {
//                        String alive = "PING";
//                        out.write(alive.getBytes());
//                        out.flush();
                        // Send reply
                        String reply = "ACK:" + received;
                        out.write(reply.getBytes());
                        out.flush();
                        lastSend = System.currentTimeMillis();
                        System.out.println("Sent KeepAlive");


                    }

                }
            }

//            while (true) {
//                int len = in.read(buffer);
//
//                if (len == -1) {
//                    // Device actually disconnected
//                    System.out.println("Device disconnected: " + socket.getInetAddress());
//                    break;
//                }
//
//                if (len > 0) {
//                    String received = new String(buffer, 0, len);
//                    System.out.println("Received: " + received);
//
////                    // Process your incoming data
////                    DataPipeline.process(received);
////
////                    // Send reply
////                    String reply = "ACK:" + received;
////                    out.write(reply.getBytes());
////                    out.flush();
//                }
//            }

        } catch (IOException e) {
            System.out.println("Connection lost: " + socket.getInetAddress());
        }

//    @Override
//    public void run() {
//        try (
//                BufferedReader in = new BufferedReader(
//                        new InputStreamReader(socket.getInputStream()));
//                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
//        ) {
//
//            String raw;
//            while ((raw = in.readLine()) != null) {
//
//                // Print incoming raw data
//                System.out.println("Received: " + raw);
//
//                // Process the data
//                DataPipeline.process(raw);
//
//                // Create reply message
//                String reply = "ACK_" + System.currentTimeMillis();
//
//                // Send reply back to device
//                out.println(reply);
//
//                System.out.println("Sent Reply: " + reply);
//            }
//
//        } catch (IOException e) {
//            System.out.println("Client disconnected: " + socket.getInetAddress());
//        }
    }
}

