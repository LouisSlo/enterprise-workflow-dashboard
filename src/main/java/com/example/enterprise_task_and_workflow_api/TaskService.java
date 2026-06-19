package com.example.enterprise_task_and_workflow_api;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTaskStatus(Long id, TaskStatus newStatus) {
        return taskRepository.findById(id).map(task -> {
            task.setStatus(newStatus);
            return taskRepository.save(task);
        }).orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found"));
    }
}