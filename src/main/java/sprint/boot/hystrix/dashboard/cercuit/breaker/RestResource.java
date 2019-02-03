package sprint.boot.hystrix.dashboard.cercuit.breaker;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class RestResource {

	@RequestMapping("/hello")
	@HystrixCommand(fallbackMethod = "fallbackMethod", commandKey = "hello", groupKey = "hello")
	public String getMessage() {
		if (RandomUtils.nextBoolean()) {
			throw new RuntimeException();
		}
		return "Hello Hystrix!!!!!!!!!!!!";
	}

	public String fallbackMethod() {
		return "Fallback error!!!!!!!!!!!!!";
	}

	@RequestMapping("/timeout")
	@HystrixCommand(fallbackMethod = "fallbackMethod", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
	public String getTimeout() throws InterruptedException {
		Thread.sleep(3000);
		return "Hello timeout";
	}
}
