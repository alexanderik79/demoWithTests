package com.example.demowithtests.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class DocumentDto {

    private Integer id;
    private String number;
    private String uuid = UUID.randomUUID().toString();
    private LocalDateTime expireDate = LocalDateTime.now().plusYears(2);
    private LocalDateTime dateOfIssue = LocalDateTime.now();
    private Boolean isActive = true;
    private Boolean isHandled = false;

}

