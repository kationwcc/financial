package com.wccwin.financial.dao;

import com.wccwin.financial.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findByUsername(String username);

    public int countByUsername(String username);

    public User findByUsernameAndPassword(String username, String password);


    @Modifying
    @Query("update User u set u.token = ?1 where u.id = ?2")
    public int updateTokenById(String token, int id);

}
