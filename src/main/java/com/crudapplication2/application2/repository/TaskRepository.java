package com.crudapplication2.application2.repository;

import com.crudapplication2.application2.model.request.TaskRequestdto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskRequestdto, Integer> {
}
