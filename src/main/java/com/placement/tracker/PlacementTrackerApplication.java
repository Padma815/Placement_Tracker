package com.placement.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point of the Placement Tracker Spring Boot Application.
 * 
 * @SpringBootApplication tells Spring Boot:
 * 1. @Configuration: Tags the class as a source of bean definitions.
 * 2. @EnableAutoConfiguration: Tells Spring Boot to configure beans based on classpath settings.
 * 3. @ComponentScan: Scans for Spring components, services, and controllers in this package and sub-packages.
 */
@SpringBootApplication
public class PlacementTrackerApplication {

    public static void main(String[] args) {
        // Launches the Spring Boot application and starts the embedded web server (Tomcat on port 8080)
        SpringApplication.run(PlacementTrackerApplication.class, args);
        System.out.println("==================================================");
        System.out.println("🚀 Placement Tracker Application started successfully!");
        System.out.println("👉 Access UI at: http://localhost:8080");
        System.out.println("==================================================");
    }

}
