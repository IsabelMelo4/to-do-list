package com.example.isabelmelo.todolist.Task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
/**
 * id
 * usuario
 * descricao
 * titulo
 * data de inicio
 * data de termino
 * prioridade
 */

@Entity(name = "tb_task") /**criação da tabela no banco de dados*/

public class TaskModel {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;
  @Column(length = 50) /**essa anotação define que o tamanho desse atributo
  pode ter no máximo 50 char**/
  private String titulo;


    private String Descricao;
    private LocalDateTime startAtv;
    private  LocalDateTime endAtv;
    private String priority;
    private UUID userId;

    @CreationTimestamp
    private LocalDateTime createdAtv;


    //getters e setters

    public UUID getId() {

        return id;
    }

    public String getDescrição() {
        return Descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getStartAtv() {
        return startAtv;
    }

    public LocalDateTime getEndAtv() {
        return endAtv;
    }

    public String getPriority() {
        return priority;
    }

    public LocalDateTime getCreatedAtv() {
        return createdAtv;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDescrição(String descrição) {
        Descricao = descrição;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setStartAtv(LocalDateTime startAtv) {
        this.startAtv = startAtv;
    }

    public void setEndAtv(LocalDateTime endAtv) {
        this.endAtv = endAtv;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setCreatedAtv(LocalDateTime createdAtv) {
        this.createdAtv = createdAtv;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
