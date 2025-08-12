package com.example.todo2.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table( name = "todos" )
public class ToDo {
  
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY )
  @Column( name = "id" )
  private Integer id;
  
  @Column( name = "todo", nullable = false )
  private String todo;
  
  @Column( name = "detail" )
  private String detail;
  
  @Column( name = "created_at", nullable = false, updatable = false )
  private LocalDateTime createdAt;
  
  @Column( name = "updated_at", nullable = false )
  private LocalDateTime updatedAt;
  
  @PrePersist
  void onCreate() {
    LocalDateTime now = LocalDateTime.now();
    this.createdAt = now;
    this.updatedAt = now;
  }
  
  @PreUpdate
  void onUpdate() {
    this.updatedAt = LocalDateTime.now();
  }

}
