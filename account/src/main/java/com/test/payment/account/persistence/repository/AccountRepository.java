package com.test.payment.account.persistence.repository;

import com.test.payment.account.enums.AccountStatus;
import com.test.payment.account.persistence.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    @Modifying
    @Query("update AccountEntity set status = :status, errorId = :errorId where id = :id")
    void updateStatus(
            @Param("id") String id,
            @Param("status") AccountStatus status,
            @Param("errorId") String errorId
    );

}
