package org.equinox.api.data;

public class ExternalMembers {

	private String parentID;
	private String externalID;
	private String description;

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String getExternalID() {
		return externalID;
	}

	public void setExternalID(String externalID) {
		this.externalID = externalID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "[parentID : " + parentID + ", externalID : " + externalID + ", description : " + description + "]";
	}

}
