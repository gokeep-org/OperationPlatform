package com.op.oauth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.op.oauth.bean.entity.User;

@Mapper
public interface UserMapper {
    @Delete({
            "delete from user",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into user (id, user_id, ",
            "username, password, ",
            "status, create_date)",
            "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=VARCHAR}, ",
            "#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
            "#{status,jdbcType=BIT}, #{createDate,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    @Select({
            "select",
            "id, user_id, username, password, status, create_date",
            "from user",
            "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP)
    })
    User selectByUserId(String id);

    @Select({
            "select",
            "id, user_id, username, password, status, create_date",
            "from user",
            "where username = #{username,jdbcType=VARCHAR} and password = #{password,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP)
    })
    List<User> checkUserLogin(User user);

    @Select({
            "select",
            "id, user_id, username, password, status, create_date",
            "from user",
            "where username = #{username,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP)
    })
    List<User> checkoutUserNameIsExist(User user);

    @Select({
            "select",
            "id, user_id, username, password, status, create_date",
            "from user"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR),
            @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.BIT),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.TIMESTAMP)
    })
    List<User> selectAll();

    @Update({
            "update user",
            "set user_id = #{userId,jdbcType=VARCHAR},",
            "username = #{username,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=VARCHAR},",
            "status = #{status,jdbcType=BIT},",
            "create_date = #{createDate,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}