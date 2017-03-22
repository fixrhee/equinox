package org.equinox.api.data;

public class SessionResponse {

	private String token;
	private ResponseStatus status;

	public SessionResponse(String status) {
		this.status = StatusBuilder.getStatus(status);
	}

	public SessionResponse(String token, String status) {
		this.token = token;
		this.status = StatusBuilder.getStatus(status);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

}
