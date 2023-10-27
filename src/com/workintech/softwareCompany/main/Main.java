package com.workintech.softwareCompany.main;

import com.workintech.softwareCompany.entity.Priority;
import com.workintech.softwareCompany.entity.Status;
import com.workintech.softwareCompany.entity.Task;
import com.workintech.softwareCompany.entity.TaskData;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Task task1 = new Task("Java Collections", "Write List Interface", "Ann",
                 Priority.LOW,Status.IN_PROGRESS);
        Task task2 = new Task("Java Collections", "Write Set Interface", "Ann",
                 Priority.MED,Status.ASSIGNED);
        Task task3 = new Task("Java Collections", "Write Map Interface", "Bob",
                 Priority.HIGH,Status.IN_QUEUE);
        Task task4 = new Task("Java Collections", "Write Queue Interface", "Carol",
                 Priority.LOW, Status.ASSIGNED);
        Task task5 = new Task("Java Collections", "Write Stack Interface", "Carol",
                 Priority.LOW,Status.IN_PROGRESS);
        Task task6 = new Task("Java Collections", "What is Abstract Class", "Dogancan",
                 Priority.HIGH,Status.IN_PROGRESS);
        Task task7 = new Task("Java Collections", "Write Set Interface", "Carol",
                Priority.MED,Status.ASSIGNED);

        Set<Task> totalTasks = new HashSet<>();
        totalTasks.add(task1);
        totalTasks.add(task2);
        totalTasks.add(task3);
        totalTasks.add(task4);
        totalTasks.add(task5);
        totalTasks.add(task6);

        Set<Task> annsTask = new LinkedHashSet<>();
        annsTask.add(task1);
        annsTask.add(task2);

        Set<Task> bobsTask = new LinkedHashSet<>();
        bobsTask.add(task3);

        Set<Task> carolsTask = new LinkedHashSet<>();
        carolsTask.add(task4);
        carolsTask.add(task5);
        carolsTask.add(task7);

        Set<Task> unassignedTask = new LinkedHashSet<>();
        unassignedTask.add(task6);

        TaskData taskData = new TaskData(annsTask,bobsTask,carolsTask,unassignedTask);

        System.out.println("**********************************");
        System.out.println("All Tasks");
       // System.out.println(taskData.getUnion());

        System.out.println(taskData.getTasks("all").size());

        System.out.println("**********************************");
        System.out.println("Anns Tasks");
        System.out.println(taskData.getAnnsTasks());

        System.out.println("**********************************");
        System.out.println("Bobs Tasks");
        System.out.println(taskData.getBobsTasks());

        System.out.println("**********************************");
        System.out.println("Carols Tasks");
        System.out.println(taskData.getCarolsTasks());

        System.out.println("**********************************");
        System.out.println(taskData.getDifferences(totalTasks, taskData.getTasks("All")));

        System.out.println("**********************************");
        System.out.println("Ann + Carol: " + taskData.getIntersection(annsTask,carolsTask));
        System.out.println("Bob + Carol: " + taskData.getIntersection(bobsTask,carolsTask));
        System.out.println("Ann + Bob: " + taskData.getIntersection(annsTask,bobsTask));
    }
}