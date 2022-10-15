package cn.edu.examregister;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 24492
 */
@SpringBootApplication
@MapperScan("cn.edu.examregister.mapper")
public class ExamregisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamregisterApplication.class, args);
    }

}
