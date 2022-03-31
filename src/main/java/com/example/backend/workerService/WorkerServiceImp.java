package com.example.backend.workerService;

import com.example.backend.dto.WorkerCreateDTO;
import com.example.backend.dto.WorkerUpdateDTO;
import com.example.backend.dto.WorkerViewDTO;
import com.example.backend.exception.NotFoundException;
import com.example.backend.model.Worker;
import com.example.backend.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class WorkerServiceImp implements WorkerService{
    private final WorkerRepository workerRepository;
    @Override
    public WorkerViewDTO getUserById(Long id) {
        final Worker worker= workerRepository.findById(id).orElseThrow(()-> new NotFoundException("Not found exception"));
        return WorkerViewDTO.of(worker);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<WorkerViewDTO> getWorkers() {
        return workerRepository.findAll().stream().map(WorkerViewDTO::of).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public WorkerViewDTO createWorker(WorkerCreateDTO workerCreateDTO) {
        final Worker worker=workerRepository.save(new Worker(workerCreateDTO.getFirstName(),
                workerCreateDTO.getLastName(), workerCreateDTO.getCompany()));
        return WorkerViewDTO.of(worker);
    }

    @Override
    @Transactional
    public WorkerViewDTO updateWorker(Long id, WorkerUpdateDTO workerUpdateDto) {
        final Worker worker = workerRepository.findById(id).orElseThrow(()->new NotFoundException("Not found exception"));
        worker.setFirstName(workerUpdateDto.getFirstName());
        worker.setLastName(workerUpdateDto.getLastName());

        final Worker updateWorker = workerRepository.save(worker);
        return WorkerViewDTO.of(updateWorker);
    }

    @Override
    @Transactional
    public WorkerViewDTO deleteWorker(Long id) {
        final Worker worker = workerRepository.findById(id).orElseThrow(()->new NotFoundException("Not found exception"));
        workerRepository.deleteById(worker.getId());
        return WorkerViewDTO.of(worker);
    }
}
