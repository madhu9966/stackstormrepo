package com.newt.mytraining.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUD_TAB")
public class Student implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@Column
private String name;
@Column
private int mark;
@Column
private String department;
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public int getMark() {
return mark;
}
public void setMark(int mark) {
this.mark = mark;
}
public String getDepartment() {
return department;
}
public void setDepartment(String department) {
this.department = department;
}
}