package br.com.microcervicosnelioalves.hreurecaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HrEurecaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrEurecaserverApplication.class, args);
	}

}
