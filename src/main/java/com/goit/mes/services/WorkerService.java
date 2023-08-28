package com.goit.mes.services;

import com.goit.mes.entities.Worker;

import java.util.List;

public interface WorkerService {
  List<Worker> getAll();

  Worker findById(Long id);

  void createWorker(Worker newWorker);

  void update(Worker newWorker, Long id);

  void delete(Long id);
  
}
