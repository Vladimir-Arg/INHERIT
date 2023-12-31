import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.tasks.services.*;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTask() {
        Todos todos = new Todos();
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Приложение"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {epic};
        Task[] actual = todos.search("Яйца");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNoTasks() {
        Todos todos = new Todos();
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Приложение"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {};
        Task[] actual = todos.search("Просохнуть");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTwoTasks() {
        Todos todos = new Todos();
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Приложение"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchManyTasks() {
        Todos todos = new Todos();
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям, спросить о Приложение");
        String[] subtasks = {"Молоко", "Приложение", "Яйца", "Хлеб", "Приложение"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Приложение",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);
    }
}
