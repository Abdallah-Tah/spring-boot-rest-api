package com.amohamed.restapi.todo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Todo {
    private long id;
    private String username;
    private String description;

    @JsonProperty("isDone")
    private boolean isDone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate targetDate;

    public Todo() {
    }

    public Todo(long id, String username, String description, boolean isDone, LocalDate targetDate) {
        this.id = id;
        this.isDone = isDone; 
        this.targetDate = targetDate;
    }

    public void setId(lon
         id) { thi
    .

    public String getUser

    ame() { re

    public void setUsername(Stri
        g username) {
    t

    public String getDescription(
         { return descri
    t

    public void setDescription(String descript
        on) { this.description = 
    e

    public boolean isDone() {
        return isDone;
    }

    ;

}

Date() { retur



    targetDate) { 
    h
