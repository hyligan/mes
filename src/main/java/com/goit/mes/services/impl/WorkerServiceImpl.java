package com.goit.mes.services.impl;

import com.goit.mes.entities.Worker;
import com.goit.mes.repo.WorkerRepo;
import com.goit.mes.services.WorkerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
  private final WorkerRepo repo;

  public WorkerServiceImpl(WorkerRepo repo) {
    this.repo = repo;
  }

  @Override
  public List<Worker> getAll() {
    return repo.findAll();
  }

  @Override
  public Worker findById(Long id) {
    return repo.findById(id).get();
  }

  @Override
  public void createWorker(Worker newWorker) {
    repo.save(newWorker);
  }

  @Override
  public void update(Worker newWorker, Long id) {
    newWorker.setId(id);
    repo.save(newWorker);
  }

  @Override
  public void delete(Long id) {
    repo.deleteById(id);
  }
}
