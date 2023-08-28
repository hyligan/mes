package com.goit.mes.repo;

import com.goit.mes.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepo extends JpaRepository<Worker,Long> {
}
