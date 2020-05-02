package com.cook.authentication.repository;

import com.cook.authentication.model.CookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookRepository extends JpaRepository<CookEntity, String> {

    CookEntity findByCookId(String cookId);
    CookEntity findByPhoneNumber(String phoneNumber);

}
