package com.example.demowithtests.domain;

import com.example.demowithtests.util.annotations.entity.Name;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "managers")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Name
    private String name;

    private String role;


}
