package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
//声明一些增删改查的方法，配置一些sql

    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    //插入数据

    int insertUser(User user);

    int updateStatus(int id,int status);

    int updateHeader(int id,String headerUrl);

    int updatePassword(int id ,String password);


}
