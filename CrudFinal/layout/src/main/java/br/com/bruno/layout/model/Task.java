package br.com.bruno.layout.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Task {

  public Task(Long id, String name, String cargo, Date date) {
    this.id = id;
    this.name = name;
    this.cargo = cargo;
    this.date = date;
  }

  public Task() {
  }

  private Long id;
  private String name;
  private String cargo;

 

  @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private Date date;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

   public void setCargo(String cargo) {
    this.cargo = cargo;
  }

   public String getCargo() {
    return cargo;
  }


  public void setDate(Date date) {
    this.date = date;
  }

  public Date getDate() {
    return date;
  }

}