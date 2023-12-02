package com.example.taskToDo.service;
import com.example.taskToDo.models.Task;
import com.example.taskToDo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Task findById(Integer id) {
        return taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Undefined!"));
    }

    public void deleteTask(Integer id){
        taskRepository.deleteById(id);
    }

    public List<Task> findAll(Task task) {
        return taskRepository.findAll();
    }
}
