package entities.enums;

public enum WorkerLevel {
	JUNIOR("J","JUNIOR"),
	MID_LEVEL("M","MID LEVEL"),
	SENIOR("S", "SENIOR");
	
	private String code;
	private String description;
	
	private WorkerLevel(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static WorkerLevel workerLevelType(String code) {
		if(code.equals("J")) {
			return JUNIOR;
		}else if(code.equals("M")) {
			return MID_LEVEL;
		}else if(code.equals("S")) {
			return SENIOR;
		}else {
			return null;
		}
	}
}