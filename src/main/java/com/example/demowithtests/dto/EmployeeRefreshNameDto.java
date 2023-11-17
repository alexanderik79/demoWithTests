package com.example.demowithtests.dto;

import com.example.demowithtests.util.annotations.entity.Name;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.Date;

public record EmployeeRefreshNameDto(

    @Schema(description = "Id in DB")
    Integer id,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "Date response")
    Date updatedDate,

    @Name
    String name)

 {
    public EmployeeRefreshNameDto(Integer id, Date updatedDate, String name){
            this.id = id;
            this.updatedDate = updatedDate != null ? updatedDate : Date.from(Instant.now());
            this.name = name;
        }
 }
