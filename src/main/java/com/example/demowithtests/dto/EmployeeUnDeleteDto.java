package com.example.demowithtests.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.Date;

public record EmployeeUnDeleteDto(

    @Schema(description = "Id in DB")
    Integer id,
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    @Schema(description = "Date response")
//    Date unDeleteDate,

    Boolean isDeleted)


 {
    public EmployeeUnDeleteDto(Integer id, Boolean isDeleted){
            this.id = id;
//            this.unDeleteDate = unDeleteDate != null ? unDeleteDate : Date.from(Instant.now());
            this.isDeleted = isDeleted;
        }
 }
