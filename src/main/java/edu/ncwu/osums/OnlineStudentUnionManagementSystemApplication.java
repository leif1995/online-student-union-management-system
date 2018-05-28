package edu.ncwu.osums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class OnlineStudentUnionManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineStudentUnionManagementSystemApplication.class, args);
    }
}
