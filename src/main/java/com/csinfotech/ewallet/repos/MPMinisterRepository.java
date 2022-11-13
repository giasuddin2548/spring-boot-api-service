package com.csinfotech.ewallet.repos;

import com.csinfotech.ewallet.model.MpCommentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MPMinisterRepository extends JpaRepository<MpCommentModel, Long> {

}
