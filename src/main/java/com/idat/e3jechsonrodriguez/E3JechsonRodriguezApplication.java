package com.idat.e3jechsonrodriguez;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Configurable
@EnableAutoConfiguration

public class E3JechsonRodriguezApplication {

	public static void main(String[] args) {
		SpringApplication.run(E3JechsonRodriguezApplication.class, args);
	}

}
