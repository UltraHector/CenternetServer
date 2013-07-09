package com.TroyEmpire.CenternetServer.Main;


public class Main {

	public static void main(String args[]) throws Exception {
		new Main().start();
	}

	public static void stop() {
	}

	private WebServer server;

	public Main() {
		server = new WebServer(8000);
	}

	public void start() throws Exception {
		// start the jetty server
		server.start();
		server.join();
	}
}
