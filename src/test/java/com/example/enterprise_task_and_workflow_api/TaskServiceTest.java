package com.example.enterprise_task_and_workflow_api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task sampleTask;

    @BeforeEach
    void setUp() {
        sampleTask = new Task();
        sampleTask.setId(1L);
        sampleTask.setTitle("Test Task");
        sampleTask.setStatus(TaskStatus.OPEN);
    }

    @Test
    void shouldCreateNewTask() {
        when(taskRepository.save(any(Task.class))).thenReturn(sampleTask);

        Task createdTask = taskService.createTask(sampleTask);

        assertNotNull(createdTask);
        assertEquals("Test Task", createdTask.getTitle());
        assertEquals(TaskStatus.OPEN, createdTask.getStatus());
        verify(taskRepository, times(1)).save(sampleTask);
    }

    @Test
    void shouldUpdateTaskStatusSuccessfully() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(sampleTask));
        when(taskRepository.save(any(Task.class))).thenReturn(sampleTask);

        Task updatedTask = taskService.updateTaskStatus(1L, TaskStatus.IN_PROGRESS);

        assertEquals(TaskStatus.IN_PROGRESS, updatedTask.getStatus());
        verify(taskRepository, times(1)).save(sampleTask);
    }

    @Test
    void shouldThrowExceptionWhenUpdatingNonExistentTask() {
        when(taskRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class, () -> {
            taskService.updateTaskStatus(99L, TaskStatus.DONE);
        });
    }
}