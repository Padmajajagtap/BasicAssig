package com.neosoft.repo;

import com.neosoft.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    //custom methods
    public User findByUserName();

    public User findByEmailId();

    public User findByCountry();

    public User findByContactnumber();
}
