package com.opm;

import com.opm.repository.AuditRepository;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:application.properties")
@SpringBootApplication
public class MarvelApiRestApplicationTests {

    @Bean
    public AuditRepository auditRepository(){
        return Mockito.mock(AuditRepository.class);
    }
}
