package com.csinfotech.ewallet.repos.releations;
import com.csinfotech.ewallet.model.releations.StdPayments;
import com.csinfotech.ewallet.model.releations.StdSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<StdSubject, Long> {
}
