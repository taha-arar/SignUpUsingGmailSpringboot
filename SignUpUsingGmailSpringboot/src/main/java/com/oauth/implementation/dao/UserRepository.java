package com.oauth.implementation.dao;

import com.oauth.implementation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<Client, Integer>{

	Optional<Client> findByEmail(String emailId);
}
