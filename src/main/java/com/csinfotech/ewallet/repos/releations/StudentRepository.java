package com.csinfotech.ewallet.repos.releations;

import com.csinfotech.ewallet.model.releations.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students, Long> {
}
