package com.xxx.mapper;

import com.xxx.pojo.brand;
import com.xxx.pojo.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface userMapper {

    @Select("select * from tb_brand")
    @ResultMap("brandMap")
    public List<brand> selectAll();

    @Select("select * from user where account = #{account} and password = #{password}")
    public user selectUser(@Param("account") String account, @Param("password") String password);


    @Insert("insert into user values (null,#{account},#{password1})")
    public void insertUser(@Param("account") String account,@Param("password1") String password1);


    @Select("select * from user where account = #{account}")
    public user selectByAccount(String account);
}
