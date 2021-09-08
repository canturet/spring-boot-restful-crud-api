package com.canturet.restful.crud.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canturet.restful.crud.api.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
