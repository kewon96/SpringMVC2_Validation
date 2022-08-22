package hello.itemservice.config;

import hello.itemservice.web.validation.CommonValidator;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ItemWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public Validator getValidator() {
        return new CommonValidator();
    }
}
