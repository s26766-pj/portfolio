package pl.pjatk.kamkon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SideClass {

    @Bean
    public String welcomeMessage() {
        return "W e l c o m e    t o    S t a g i n g    P r o f i l e";
    }
}
