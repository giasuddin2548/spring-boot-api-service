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
@AllArgsConstructor
@Entity
@Table(name = "tbl_subjects")
public class Table4 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tbl_subjects_id")
    private Long id;
    private String subName;
    private int subCode;
    @CreationTimestamp
    @Column(name = "createdAt", updatable = false, nullable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updatedAt")
    private Date updatedAt;
}
