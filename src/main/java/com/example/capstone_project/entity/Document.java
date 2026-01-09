package com.example.capstone_project.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private String path;
    @NotNull
    private Timestamp timestamp;
    private Status status;
    @NotBlank
    private String reason;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @OneToOne(mappedBy = "document", cascade = CascadeType.ALL)
    private ReviewComment reviewComment;

    private enum Status
    {
        DRAFT,
        IN_REVIEW,
        APPROVE,
        REJECT
    }
}
