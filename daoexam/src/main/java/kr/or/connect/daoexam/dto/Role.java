package kr.or.connect.daoexam.dto;

public class Role {
	private int roldId;
	private String description;
	public int getRoldId() {
		return roldId;
	}
	public void setRoldId(int roldId) {
		this.roldId = roldId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Role [roldID=" + roldId + ", description=" + description + "]";
	}
	
}
