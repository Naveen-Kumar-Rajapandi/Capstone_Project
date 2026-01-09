package com.example.capstone_project.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Roles
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer role_id;
    @Column(nullable = false,unique = true)
    private String name;
    private String actions;
    @OneToMany (mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> user;
}
