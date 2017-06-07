package org.equinox.api.data;

import java.io.Serializable;
import java.util.HashMap;

public class RequestPayload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8882329035639193163L;
	private HashMap<String, String> requestContent;
	private HashMap<String, String> profileContent;

	public HashMap<String, String> getRequestContent() {
		return requestContent;
	}

	public void setRequestContent(HashMap<String, String> requestContent) {
		this.requestContent = requestContent;
	}

	public HashMap<String, String> getProfileContent() {
		return profileContent;
	}

	public void setProfileContent(HashMap<String, String> profileContent) {
		this.profileContent = profileContent;
	}

}
