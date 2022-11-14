package com.csinfotech.ewallet.model.releations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_payments")
public class StdPayments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private Long id;
    private String month;
    private double fees;

    public StdPayments(String month, double fees) {
        this.month = month;
        this.fees = fees;
    }

    @OneToOne(mappedBy = "payments")
    private Students students;

}
