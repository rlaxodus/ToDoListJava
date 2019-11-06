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
        final Task task = new Task("Task 1", false);

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
        final Task task = new Task("Task 3", false);
        toDoList.addTask(task);
        assertEquals(toDoList.getAllTasks().size(), 1);
        assertTrue(toDoList.getAllTasks().contains(task));

        // When
        assertEquals(task, toDoList.removeTask("Task 3"));

        // Then
        assertEquals(toDoList.getAllTasks().size(), 0);
    }

    @Test
    public void testgetStatus() {

        // Given
        final ToDoList toDoList = new ToDoList();
        final Task task = new Task("Task 2", false);
        toDoList.addTask(task);

        // Then
        assertFalse(toDoList.getStatus("Task 2"));
    }

    @Test
    public void testGetCompletedTasks() {
        // Given
        final ToDoList toDoList = new ToDoList();
        final Task task = new Task("Task 4", false);
        toDoList.addTask(task);
        assertEquals(toDoList.getAllTasks().size(), 1);
        toDoList.completeTask("Task 4");

        // Then
        assertEquals(toDoList.getCompletedTasks().size(), 1);
    }
}
