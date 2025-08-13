package com.example.todo2.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo2.entity.ToDo;
import com.example.todo2.repository.ToDoRepository;
import com.example.todo2.service.ToDoService;

@Service
@Transactional
public class ToDoServiceImpl implements ToDoService {
  
  private final ToDoRepository repository;
  
  public ToDoServiceImpl( ToDoRepository repository ) {
    this.repository = repository;
  }
  
  @Override
  @Transactional( readOnly = true )
  public List<ToDo> findAllToDo() {
    return repository.findAllOrderById();
  }
  
  @Override
  @Transactional(readOnly = true)
  public ToDo findByIdToDo( Integer id ) {
    return repository.findById( id ).orElse( null );
  }
  
  @Override
  public boolean insertToDo( ToDo toDo ) {
    ToDo saved = repository.save( toDo );  // 戻りはinsertされたToDo
    return saved.getId() != null;
  }
  
  @Override
  public boolean updateToDo( ToDo toDo ) {
    if ( toDo.getId() == null || !repository.existsById( toDo.getId() ) ) {
      return false; // 対象なし
    }
    repository.save(toDo); // @PreUpdateでupdatedAtが更新される
    return true;
  }
  
  @Override
  public boolean deleteToDo( Integer id ) {
    if ( !repository.existsById( id ) ) {
      return false; // 対象なし
    }
    repository.deleteById(id);
    return true;
  }

}
