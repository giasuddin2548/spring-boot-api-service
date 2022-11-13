package com.csinfotech.ewallet.repos;
import com.csinfotech.ewallet.model.RegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<RegistrationModel, Long> {

}
