package sprint.boot.hystrix.dashboard.cercuit.breaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
//@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SpringBootHystrixDashboardCercuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHystrixDashboardCercuitBreakerApplication.class, args);
	}

}

