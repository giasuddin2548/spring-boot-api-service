package com.csinfotech.ewallet.repos.releations;
import com.csinfotech.ewallet.model.releations.StdPayments;
import com.csinfotech.ewallet.model.releations.StdResults;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<StdPayments, Long> {
}
