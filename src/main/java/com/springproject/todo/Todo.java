package com.springproject.todo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Todo")
public class Todo {
    
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name="title", nullable=false)
private String title;

@Column(name="description" )
 private String description;

@Column(name="due_date")
@Temporal(TemporalType.DATE)
private Date duedate;

@Column(name="priority")
private String priority;

@Column(name="status")
private boolean status;

public Todo(){

 }
 public Todo(String title, String description, Date duedate, boolean status){
    this.title=title;
    this.description=description;
    this.duedate=duedate;
    this.status=status;
 }
 

 public Long getId(){
    return this.id;
 }
 public void setId(Long id){
    this.id=id;
 }
 public String getTitle(){
    return this.title;
 }
 public void setTitle(String title){
    this.title=title;
 }
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDuedate() {
        return this.duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public boolean isDone() {
        return this.status;
    }

    public boolean getstatus() {
        return this.status;
    }

    public void setstatus(boolean status) {
        this.status = status;
    }
 @Override
 public boolean equals(Object o) {
    if (this == o) {
        return true;
    }
    if (!(o instanceof Todo)) {
        return false;
    }
    return id != null && id.equals(((Todo) o).id);
}

@Override
public int hashCode() {
    return 31;
}
    
} 