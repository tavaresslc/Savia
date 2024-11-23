package tech.buildrun.savia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Size(min = 3, max = 50, message = "O título da categoria deve ter entre 3 e 50 caracteres.")
    @Column(name = "title")
    private String title;

    @NotBlank
    @Positive
    @Max(value = 100, message = "O percentual deve ser no máximo 100.")
    @Min(value = 0, message = "O percentual deve ser no mínimo 0.")
    @Column(name = "percent")
    private Integer percent;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotBlank
    private List<Expense> expenses;
    
    // Getters and Setters
}
