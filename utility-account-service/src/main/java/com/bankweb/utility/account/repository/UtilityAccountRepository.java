package com.bankweb.utility.account.repository;

import com.bankweb.utility.account.entity.UtilityAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilityAccountRepository extends JpaRepository<UtilityAccount, Long> {
}
