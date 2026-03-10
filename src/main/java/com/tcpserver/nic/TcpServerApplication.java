package com.tcpserver.nic;

import com.tcpserver.nic.server.TcpServer;
import com.tcpserver.nic.client.TcpClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class TcpServerApplication {

	private final TcpServer tcpServer;
	private final TcpClient tcpClient;

	public TcpServerApplication(TcpServer tcpServer, TcpClient tcpClient) {
		this.tcpServer = tcpServer;
		this.tcpClient = tcpClient;
	}

	public static void main(String[] args) {
		SpringApplication.run(TcpServerApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void startTcpServerAndClient() {

		// Start TCP SERVER
		//tcpServer.start();

		// Start TCP CLIENT
		tcpClient.startClient();

		System.out.println("TCP Server & Client started successfully.");
	}
}
