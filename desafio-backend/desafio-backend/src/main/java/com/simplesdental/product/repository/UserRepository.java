package com.simplesdental.product.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplesdental.product.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
