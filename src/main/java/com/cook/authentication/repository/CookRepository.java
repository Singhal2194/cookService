package com.cook.authentication.repository;

import com.cook.authentication.model.CookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookRepository extends JpaRepository<CookEntity, String> {

    CookEntity findByCookId(String cookId);

}
