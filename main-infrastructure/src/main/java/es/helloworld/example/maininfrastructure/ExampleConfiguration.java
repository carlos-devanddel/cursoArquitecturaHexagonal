package es.helloworld.example.maininfrastructure;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan("com.helloworld.examples")
@EntityScan("com.helloworld.examples.persistence.h2.models")
public class ExampleConfiguration {

}
