package com.dgchiri.blog_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dgchiri.blog_project.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
