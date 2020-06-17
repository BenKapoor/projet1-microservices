package eu.ensup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableHystrix
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	Première méthode static sans load balancing
//	@Bean
//	RouteLocator staticRoutes(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route(r -> r.path("/customers/**").uri("http://localhost:8081/").id("r1"))
//				.route(r -> r.path("/products/**").uri("http://localhost:8084/").id("r2"))
//				.route(r -> r.path("/bills/**").uri("http://localhost:8088/").id("r3"))
//				.build();
//	}
	
	// Deuxième méthode static
//	@Bean
//	RouteLocator staticRoutes(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route(r -> r.path("/customers/**").uri("lb://CUSTOMER-SERVICE").id("r1"))
//				.route(r -> r.path("/products/**").uri("lb://INVENTORY-SERVICE").id("r2"))
//				.route(r -> r.path("/bills/**").uri("lb://BILLING-SERVICE").id("r3"))
//				.route(r -> r.path("/productItems/**").uri("lb://BILLING-SERVICE").id("r4"))
//				.build();
//	}
	// version dynamique
		@Bean
		DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc,
				DiscoveryLocatorProperties ldp) {
			return new DiscoveryClientRouteDefinitionLocator(rdc,ldp);
		}


}
