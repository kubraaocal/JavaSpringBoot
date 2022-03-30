package com.example.backend.workerService;

import com.example.backend.dto.WorkerCreateDTO;
import com.example.backend.dto.WorkerUpdateDTO;
import com.example.backend.dto.WorkerViewDTO;

import java.util.List;

public interface WorkerService {
    WorkerViewDTO getUserById(Long id);

    List<WorkerViewDTO> getWorkers();

    WorkerViewDTO createWorker(WorkerCreateDTO workerCreateDTO);


    WorkerViewDTO updateWorker(Long id, WorkerUpdateDTO workerUpdateDto);

    WorkerViewDTO deleteWorker(Long id);
}
