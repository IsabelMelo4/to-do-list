package com.example.isabelmelo.todolist.Task;

import com.example.isabelmelo.todolist.utils.utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;
    private HandlerMapping resourceHandlerMapping;

    @PostMapping()

    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");
        taskModel.setUserId((UUID) idUser);


        var currentDate = LocalDateTime.now();
        if (currentDate.isAfter(taskModel.getStartAtv()) || currentDate.isAfter(taskModel.getEndAtv())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de início deve ser maior que a atual");
        }
        if (taskModel.getStartAtv().isAfter(taskModel.getEndAtv())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de início deve ser maior que a data de termino");
        }

        var task = this.taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    public List<TaskModel> list(HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");
        var tasks = this.taskRepository.findByUserId((UUID) idUser);
        return tasks;
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskModel> update(
            @RequestBody TaskModel taskModel,
            HttpServletRequest request,
            @PathVariable UUID id
    ) {
        var idUser = request.getAttribute("idUser");

        var task = this.taskRepository.findById(id).orElse(null);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        if (!task.getUserId().equals(idUser))
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();

        utils.copyNonNullProperties(taskModel, task);

        var taskUpdated = this.taskRepository.save(task);
        return ResponseEntity.ok(taskUpdated);
    }
}