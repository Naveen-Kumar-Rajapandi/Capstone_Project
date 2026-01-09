package com.example.capstone_project.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @ManyToOne
    @JoinColumn(
            name = "role_id",
            referencedColumnName = "role_id"
    )
    private Roles role;
}
