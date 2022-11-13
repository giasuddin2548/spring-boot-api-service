package com.csinfotech.ewallet.model.releations;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_student")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "std_id")
    private Long id;
    private String username;
    private String userEmail;
    private String userPhone;
    private String userPassword;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id")
    private StdResults results;



    @CreationTimestamp
    @Column(name = "createdAt", updatable = false, nullable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updatedAt")
    private Date updatedAt;

    public Students(String username, String userEmail, String userPhone, String userPassword, StdResults results) {
        this.username = username;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.results = results;
    }
}
