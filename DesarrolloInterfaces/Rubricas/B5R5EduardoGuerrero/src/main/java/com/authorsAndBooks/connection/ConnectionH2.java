package com.authorsAndBooks.connection;

public class ConnectionH2  extends AbstractConnection {

	@Override
	public String getDriver() {
		return "org.h2.Driver";
	}

	@Override
	public String getDatabaseUser() {
		return "sa";
	}

	@Override
	public String getDatabasePassword() {
		return "";
	}
}
