package cl.duoc.tutorias_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TutoriasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutoriasServiceApplication.class, args);
	}

}
