package com.example.todo2.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo2.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
  
  default List<ToDo> findAllOrderById() {
    return findAll( Sort.by( "id" ) );
  }

}
