package tech.buildrun.savia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Positive
    @DecimalMin(value = "0.01", inclusive = true)
    @DecimalMax(value = "999999999.99", inclusive = true)
    @Column(name = "amount")
    private BigDecimal amount;

    @Size(max = 255, message = "A descrição deve ter no máximo 255 caracteres.")
    @Column(name = "description")
    private String description;

    @NotBlank
    @PastOrPresent(message = "A data de pagamento não pode ser futura.")
    @Column(name = "expense_date")
    private Date expenseDate;

    @ManyToOne
    @NotBlank
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @NotBlank
    @JoinColumn(name = "category_id")
    private Category category;

    public Expense() {
    }

    public Expense(BigDecimal amount, String description, Date expenseDate) {
        this.amount = amount;
        this.description = description;
        this.expenseDate = expenseDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
