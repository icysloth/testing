import java.util.Date;

public class Task {
	private String description = null;
	private boolean isComplete = false;
	// 1 = most important 3 = least
	private int priority = 1; 
	private Date deadline = new Date();


	public Task(String description) {
		super();
		this.description = description;
	}

	public Task(String description, boolean isComplete) {
		super();
		this.description = description;
		this.isComplete = isComplete;
	}
	
	public Task(String description, Date deadline) {
		super();
		this.description = description;
		this.deadline = deadline;
	}


	public Task(String description, int priority) {
		super();
		this.description = description;
		if(priority >= 1 || priority <= 3) {
			this.priority = priority;
		}
	}

	public Task(String description, boolean isComplete, int priority) {
		super();
		this.description = description;
		this.isComplete = isComplete;
		if(priority >= 1 || priority <= 3) {
			this.priority = priority;
		}
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

	public Date getDateline() {
		return deadline;
	}

	public void setDateline(Date deadline) {
		this.deadline = deadline;
	}

}
