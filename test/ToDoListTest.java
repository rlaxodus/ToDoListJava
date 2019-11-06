import java.util.List;

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

    public void testSearchByDescriptionContaining() {
        // Given
        final ToDoList toDoList = new ToDoList();
        final Task task1 = new Task("Task 1", "First Task", false);
        final Task task2 = new Task("Task 2", "Second Task", false);
        final Task task3 = new Task("Task 3", "Third Task", false);
        final Task task4 = new Task("Task 4", "Fourth Task", false);
        final Task task5 = new Task("Task 5", "Fifth", false);
        toDoList.addTask(task1);
        toDoList.addTask(task2);
        toDoList.addTask(task3);
        toDoList.addTask(task4);
        toDoList.addTask(task5);

        // When
        final List<Task> results = toDoList.searchTaskByDescription("Task");

        // Then
        assertEquals(results.size(), 4);
        results.forEach(task -> assertTrue(task.getDescription().contains("Task")));
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
}
