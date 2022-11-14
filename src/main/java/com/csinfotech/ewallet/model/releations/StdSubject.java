package com.csinfotech.ewallet.model.releations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_subjects")
public class StdSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sub_id")
    private Long id;
    private String subName;
    private int subCode;

//    @OneToOne(mappedBy = "subject")
//    private Students students;

    public StdSubject(String subName, int subCode) {
        this.subName = subName;
        this.subCode = subCode;
    }
}
