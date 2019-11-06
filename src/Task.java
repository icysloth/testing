
public class Task {
	private String description = null;
	private boolean isComplete = false;
	// 1 = most important 3 = least
	private int priority = 1; 
	
	
	public Task(String description) {
		super();
		this.description = description;
	}
	
	public Task(String description, boolean isComplete) {
		super();
		this.description = description;
		this.isComplete = isComplete;
	}
	
	public Task(String description, int priority) {
		super();
		this.description = description;
		this.priority = priority;
	}
	public Task(String description, boolean isComplete, int priority) {
		super();
		this.description = description;
		this.isComplete = isComplete;
		this.priority = priority;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		if(priority >= 1 || priority <= 3) {
			this.priority = priority;
		}
	}

}
