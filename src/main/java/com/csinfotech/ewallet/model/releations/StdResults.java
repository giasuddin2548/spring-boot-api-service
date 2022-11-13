package com.csinfotech.ewallet.model.releations;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_results")
public class StdResults {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "result_id")
    private Long id;
    private String subName;
    private int subCode;
    private int marks;
    private String semesterName;

    @OneToOne(mappedBy = "results")
    private Students students;


    public StdResults(String subName, int subCode, int marks, String semesterName) {
        this.subName = subName;
        this.subCode = subCode;
        this.marks = marks;
        this.semesterName = semesterName;
    }
}
