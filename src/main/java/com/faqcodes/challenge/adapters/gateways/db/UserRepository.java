package com.faqcodes.challenge.adapters.gateways.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, String> {

  @Query(value="SELECT CASE WHEN COUNT(u.ID) > 0 THEN true ELSE false END FROM USERS u WHERE email = :email", nativeQuery = true)
  boolean existsByEmail(@Param("email") String email);

}