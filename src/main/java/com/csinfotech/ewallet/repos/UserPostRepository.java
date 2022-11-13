package com.csinfotech.ewallet.repos;
import com.csinfotech.ewallet.model.UserPostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostRepository extends JpaRepository<UserPostModel, Long> {
}
