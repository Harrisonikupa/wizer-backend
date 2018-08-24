package com.easynotes.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easynotes.easynotes.model.Book;
import com.easynotes.easynotes.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
