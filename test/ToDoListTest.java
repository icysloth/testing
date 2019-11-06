import org.junit.*;
import static org.junit.Assert.*;


import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class ToDoListTest {
	private Task task1;
	private Task task2;
	private Task task3;
	private ToDoList todoList;

	public ToDoListTest() {
		super();
	}
	@Before
	public void setUp() throws Exception{
		task1 = new Task ("desc 1",1);
		task2 = new Task ("desc 2",2);
		task3 = new Task ("desc 3",3);

		todoList = new ToDoList();
	}
	@After
	public void tearDown() throws Exception{
		task1 = null;
		task2 = null;
		task3 = null;

		todoList = null;
	}

	@Test
	public void testAddTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(1, todoList.getAllTasks().size());
		assertEquals(task1, todoList.getTask(task1.getDescription()));
	}
	@Test
	public void testgetStatus() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(false, todoList.getStatus(task1.getDescription()));
		todoList.completeTask(task1.getDescription());
		assertEquals(true, todoList.getStatus(task1.getDescription()));
	}
	@Test
	public void testRemoveTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		todoList.addTask(task2);;

		todoList.removeTask(task1.getDescription());
		assertNull(todoList.getTask(task1.getDescription()));	
	}
	@Test
	public void testGetCompletedTasks() {
		task1.setComplete(true);
		task3.setComplete(true);
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);

		Collection<Task> tasks = todoList.getCompletedTasks();
		assertEquals(2, tasks.size());
	}
	
	@Test
	public void testSetPriority() {
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);

		Collection<Task> tasks = todoList.getPriorityTasks(); 
		int temp = 0;
		for(Task task:tasks) {
			//			if(temp <= task.getPriority()) {
			//				temp = task.getPriority();
			//			}else {
			//				assertFalse(false);
			//			}
			assertTrue(temp<=task.getPriority());
			temp = task.getPriority();
		}

		// compare result -> false
	}
	@Test
	public void testGetIncompletedTasks() {
		task1.setComplete(false);
		task3.setComplete(false);
		todoList.addTask(task1);
		todoList.addTask(task3);

		Collection<Task> tasks = todoList.getIncompletedTasks();
		assertEquals(2, tasks.size());
	}
	
	@Test 
	public void testDateSet() {
		Date deadline = new Date();
		Task task4 = new Task("testing task", deadline);
		
		assertEquals(task4.getDateline(),deadline);
	}
}
