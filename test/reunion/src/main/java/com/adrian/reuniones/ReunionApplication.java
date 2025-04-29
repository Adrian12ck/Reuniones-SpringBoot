package com.adrian.reuniones;  // Paquete base que incluye todos los subpaquetes

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@EnableRabbit
@SpringBootApplication
@ComponentScan(basePackages = {"com.adrian.reuniones"})
public class ReunionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReunionApplication.class, args);
	}

}
