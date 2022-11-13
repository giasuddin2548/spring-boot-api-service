package com.csinfotech.ewallet.repos.releations;
import com.csinfotech.ewallet.model.releations.StdResults;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultsRepository extends JpaRepository<StdResults, Long> {
}
