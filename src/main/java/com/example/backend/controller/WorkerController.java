package com.example.backend.controller;

import com.example.backend.dto.WorkerCreateDTO;
import com.example.backend.dto.WorkerUpdateDTO;
import com.example.backend.dto.WorkerViewDTO;
import com.example.backend.util.GenericResponse;
import com.example.backend.workerService.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WorkerController {

    private  final WorkerService workerService;

    @GetMapping("worker/{id}")
    public ResponseEntity<WorkerViewDTO> getUserById(@PathVariable("id") Long id){
        final WorkerViewDTO worker= workerService.getUserById(id);
        return ResponseEntity.ok(worker);
    }

    @GetMapping("worker/getworkers")
    public ResponseEntity<List<WorkerViewDTO>> getWorkers(){
        final List<WorkerViewDTO> workers =  workerService.getWorkers();
        return ResponseEntity.ok(workers);
    }

    @PostMapping("worker")
    public ResponseEntity<?> createWorker(@RequestBody WorkerCreateDTO workerCreateDto){
        workerService.createWorker(workerCreateDto);
        return ResponseEntity.ok(new GenericResponse("Worker Created."));
    }

    @PutMapping("worker/{id}")
    public ResponseEntity<WorkerViewDTO> updateWorker(@PathVariable("id") Long id,@RequestBody WorkerUpdateDTO workerUpdateDto){
        final WorkerViewDTO worker = workerService.updateWorker(id,workerUpdateDto);
        return ResponseEntity.ok(worker);
    }

    @DeleteMapping("worker/{id}")
    public ResponseEntity<?> deleteWorker(@PathVariable("id") Long id){
        workerService.deleteWorker(id);
        return ResponseEntity.ok(new GenericResponse("Deleted."));
    }

}
