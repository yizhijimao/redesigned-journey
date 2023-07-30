package com.qf;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.qf.dao")
public class FmmalTaogeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmmalTaogeApplication.class, args);
    }

}
