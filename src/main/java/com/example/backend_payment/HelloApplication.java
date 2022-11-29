package com.example.backend_payment;
import com.example.backend_payment.Util.CORSFilter;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;
@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {
    public HelloApplication(){
        // Registering the CORSFilter class with the Jersey ResourceConfig
        register(CORSFilter.class);

        // Telling Jersey the CLASSPATH where the specified classes (in our case, CORSFilter) can be found
        packages("com.example.backend_payment");
    }

}