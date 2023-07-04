package ru.netology.tasks.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.tasks.services.*;
public class TaskTest {
    @Test
    public void getIdTasks() {
        Task task = new Task(6);
        int expected = 6;
        int actual = task.getId();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void getTitleSimpleTask(){
        SimpleTask simple = new SimpleTask(6, "ghfv-gfv-gfv");
        String expected = "ghfv-gfv-gfv";
        String actual = simple.getTitle();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void matchesTaskFalse() {
        Task task = new Task(6);
        Boolean expected = false;
        Boolean actual = task.matches("sfds");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void matchesEpicFalse() {
        Epic epic = new Epic(7, new String[]{"фыр-фыр"});
        Boolean expected = false;
        Boolean actual = epic.matches("sfds");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void matchesSimpleTAskFalse() {
        SimpleTask simple = new SimpleTask(6, "ghfv-gfv-gfv");
        Boolean expected = false;
        Boolean actual = simple.matches("sfds");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void matchesSimpleTAskTrue() {
        SimpleTask simple = new SimpleTask(6, "sfds");
        Boolean expected = true;
        Boolean actual = simple.matches("sfds");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void matchesMeetingFalse() {
        Meeting meeting = new Meeting(6,"Топик","Проект","Старт");
        Boolean expected = false;
        Boolean actual = meeting.matches("sfds");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void matchesMeetingTopicTrue() {
        Meeting meeting = new Meeting(6,"Топик","Проект","Старт");
        Boolean expected = true;
        Boolean actual = meeting.matches("Топик");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void matchesMeetingProjectTrue() {
        Meeting meeting = new Meeting(6,"Топик","Проект","Старт");
        Boolean expected = true;
        Boolean actual = meeting.matches("Проект");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void booleanEqualsTaskNull() {
        Task task = new Task(0);
        Boolean expected = false;
        Boolean actual = task.equals(null);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void booleanEqualsTaskO() {
        Task task = new Task(0);
        Boolean expected = false;
        Boolean actual = task.equals("o");
        Assertions.assertEquals(expected, actual);
    }
/*
    @Test
    public void booleanEqualsTaskO() {
        Task task = new Task(0);
        Boolean expected = true;
        Boolean actual = tas;
        Assertions.assertEquals(expected, actual);
    }
*/
}