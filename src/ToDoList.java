import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class ToDoList {

	private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public void addTask (Task task) {
		tasks.put(task.getDescription(), task);
	}
	public void completeTask(String description) {
		Task task = null;
		if ((task = tasks.get(description)) != null){
			task.setComplete(true);
		};
	}
	public boolean getStatus(String description) {
		Task task = null;
		if ((task = tasks.get(description)) != null){
			return task.isComplete();
		};
		return false;
	}
	public Task getTask(String description) {
		return tasks.get(description);
	}
	public Task removeTask(String description) {
		return tasks.remove(description);
	}
	public Collection<Task> getAllTasks() {
		return tasks.values();
	}
	public Collection<Task> getCompletedTasks() {
		Collection<Task> completedTasks = new ArrayList<Task> ();
		Collection<Task> allTasks = new ArrayList<Task> ();
		allTasks = getAllTasks();
		for (Task task: allTasks) 
			if (task.isComplete() == true) completedTasks.add(task);
		return completedTasks;
	}
	
	public Collection<Task> getIncompletedTasks() {
		Collection<Task> incompletedTasks = new ArrayList<Task> ();
		Collection<Task> allTasks = new ArrayList<Task> ();
		allTasks = getAllTasks();
		for (Task task: allTasks) 
			if (task.isComplete() != true) incompletedTasks.add(task);
		return incompletedTasks;
	}
	
	public Collection<Task> getPriorityTasks(){
		ArrayList<Task> priority = new ArrayList<Task>(getIncompletedTasks());

		Collection<Task> combined = new ArrayList<Task>();
		Collection<Task> important = new ArrayList<Task>();
		Collection<Task> medium = new ArrayList<Task>();
		Collection<Task> least = new ArrayList<Task>();

		for (Task priorityItem : priority) {
			switch(priorityItem.getPriority()) {
			case 1: 
				important.add(priorityItem);
				break;
			case 2: 
				medium.add(priorityItem);
				break;
			case 3: 
				least.add(priorityItem);
				break;
			default:
				break;

			}
		}

		combined.addAll(important);
		combined.addAll(medium);
		combined.addAll(least);
		return combined;
	}

	public Collection<Task> getTodayList(){
		Collection<Task> todayList = new ArrayList<Task>();
		ArrayList<Task> incomplete = new ArrayList<Task>(getIncompletedTasks());
		
		Date currentDate = new Date();
		
		for (Task incompleteItem : incomplete) {
			if(currentDate.compareTo(incompleteItem.getDateline())==1) {
				todayList.add(incompleteItem);
			}
		}		
		return todayList;
	}
}
