package com.workintech.softwareCompany.entity;

import java.util.*;

public class TaskData {

   // annsTasks => Set<Task> bobsTasks => Set<Task> carolsTasks => Set<Task>

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getTasks(String taskOwner){
        if(taskOwner.toLowerCase().equals("ann")){
            return annsTasks;
        }
        if(taskOwner.toLowerCase().equals("bob")){
            return bobsTasks;
        }
        if(taskOwner.toLowerCase().equals("carol")){
            return carolsTasks;
        }
        if(taskOwner.toLowerCase().equals("all")){
            return getUnion(annsTasks,bobsTasks,carolsTasks);
        }
        return new HashSet<>();
    }

    public Set<Task> getUnion(Set<Task>... tasks){
        Set<Task> totals = new LinkedHashSet<>();
        for(Set<Task> taskSet: tasks){
            totals.addAll(taskSet);
        }
        return totals;
    }

    public Set<Task> getIntersection(Set<Task> first,Set<Task> second ){
        Set<Task> intersections = new HashSet<>(first);
        intersections.retainAll(second);
        return intersections;
    }

    public Set<Task> getDifferences(Set<Task> first,Set<Task> second ){
        Set<Task> differences = new HashSet<>(first);
        differences.removeAll(second);
        return differences;
    }
}
