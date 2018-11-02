package com.rjh.repository;

import com.rjh.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author RJH
 * <br/>Created in 2018-11-02
 */
public interface UserRepository extends CrudRepository<User,String> {

    //TODO 无法按照账户和密码查询
    List<User> findByUserNameAndPassword(String userName, String password);
}
