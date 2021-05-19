package indi.axikuazei.pigletter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){


            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/index").setViewName("index.html");
                registry.addViewController("/home").setViewName("index.html");
            }

            // @Override
            // public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //     registry.addResourceHandler("/**").addResourceLocations("static/");
            // }
        };
    }

}