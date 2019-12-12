package openhouse;

import openhouse.dto.Users;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@MappedTypes(Users.class)
@MapperScan("openhouse.mapper")
public class SFA {

	public static void main(String[] args) {
		SpringApplication.run(SFA.class, args);
	}
}
