package br.com.rr.mastertech.empresa.validacapital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmpresaValidaCapitalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaValidaCapitalServiceApplication.class, args);
	}

}
