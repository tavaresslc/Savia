package tech.buildrun.savia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "incomes")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Positive
    @DecimalMin(value = "0.01", inclusive = true)
    @DecimalMax(value = "999999999.99", inclusive = true)
    @Column(name = "amount")
    private BigDecimal amount;

    @Size(max = 50, message = "A renda deve ter no máximo 50 caracteres.")
    @Column(name = "source")
    private String source;

    @NotBlank
    @PastOrPresent(message = "A data de recebimento não pode ser futura.")
    @Column(name = "received_date")
    private Date receivedDate;

    @ManyToOne
    @NotBlank
    @JoinColumn(name = "user_id")
    private User user;

    public Income() {
    }

    public Income(BigDecimal amount, String source, Date receivedDate) {
        this.amount = amount;
        this.source = source;
        this.receivedDate = receivedDate;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
