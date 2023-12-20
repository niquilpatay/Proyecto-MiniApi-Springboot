package edu.utn.frc.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		run(DemoApplication.class, args);
	}
}

