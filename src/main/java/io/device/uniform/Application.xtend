package io.device.uniform

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class Application {
	
	def static void main(String[] args) {
		SpringApplication.run(Application, args)
	}
	
}
