package openhouse.repositories;

import openhouse.dto.Users;
import org.apache.ibatis.annotations.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("SELECT * FROM USERS")
    List<Users> findAllUser();

    @Select("SELECT * FROM USERS WHERE ID = #{id}")
    Users findUserById(@Param("id") int id);

    @Delete("DELETE FROM USERS WHERE ID = #{id}")
    Mono<Void> deleteUserById(@Param("id") int id);

    @Insert("INSERT INTO USERS(name,email,sex,department) VALUES(#{name},#{email},#{sex},#{department})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    Mono<Users> insertUser(Users users);

    @Update("UPDATE USERS SET name=#{name}, email=#{email}, sex=#{sex}, department=#{department} WHERE id=#{id}")
    Mono<Users> updateUser(Users users);
}
