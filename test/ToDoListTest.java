import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class ToDoListTest extends TestCase {
    // Define Test Fixtures

    public ToDoListTest() {
        super();
    }

    @Override
    @Before
    public void setUp() throws Exception {
        // Initialise Test Fixtures
    }

    @Override
    @After
    public void tearDown() throws Exception {
        // Uninitialise test Fixtures
    }

    @Test
    public void testCreateAddTask() {
        // Given
        final ToDoList toDoList = new ToDoList();
        final Task task = new Task("Task 1", "First Task", false);

        // When
        toDoList.addTask(task);

        // Then
        assertEquals(toDoList.getAllTasks().size(), 1);
        assertTrue(toDoList.getAllTasks().contains(task));
    }

    @Test
    public void testRemoveTask() {
        // Given
        final ToDoList toDoList = new ToDoList();
        final Task task = new Task("Task 3", "Third Task", false);
        toDoList.addTask(task);
        assertEquals(toDoList.getAllTasks().size(), 1);
        assertTrue(toDoList.getAllTasks().contains(task));

        // When
        assertEquals(task, toDoList.removeTask("Task 3"));

        // Then
        assertEquals(toDoList.getAllTasks().size(), 0);
    }

    @Test
    public void testSetTaskComplete() {
        // Given
        final ToDoList toDoList = new ToDoList();
        final Task task = new Task("Task 4", "Fourth Task", false);
        toDoList.addTask(task);
        assertEquals(toDoList.getAllTasks().size(), 1);
        assertFalse(toDoList.getTask("Task 4").isComplete());

        // When
        toDoList.completeTask("Task 4");

        // Then
        assertEquals(toDoList.getCompletedTasks().size(), 1);
        assertTrue(toDoList.getTask("Task 4").isComplete());
    }

    @Test
    public void testgetStatus() {

        // Given
        final ToDoList toDoList = new ToDoList();
        final Task task = new Task("Task 2", "Second Task", false);
        toDoList.addTask(task);

        // Then
        assertFalse(toDoList.getStatus("Task 2"));
    }

    @Test
    public void testGetCompletedTasks() {
        // Given
        final ToDoList toDoList = new ToDoList();
        final Task task = new Task("Task 4", "Fourth Task", false);
        toDoList.addTask(task);
        assertEquals(toDoList.getAllTasks().size(), 1);
        toDoList.completeTask("Task 4");

        // Then
        assertEquals(toDoList.getCompletedTasks().size(), 1);
    }
    @Test
    public void testViewTasks() {
        // Given
        final ToDoList toDoList = new ToDoList();
        final Task task = new Task("Task 4", "Fourth Task", false);
        toDoList.addTask(task);
        	Task task1= toDoList.getTask("Task 4");
        	Task task2= toDoList.getTask("Task 5");
        	assertEquals(task1.getTaskName(),"Task 4");
        	assertEquals(task2,null);
    
    }
}
