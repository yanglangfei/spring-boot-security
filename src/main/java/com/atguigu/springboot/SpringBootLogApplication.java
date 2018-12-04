package com.atguigu.springboot;

import com.atguigu.springboot.boot.HelloServlet2;
import com.atguigu.springboot.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.atguigu.springboot.servlet"})
public class SpringBootLogApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootLogApplication.class, args);
        context.getBean("person", Person.class).show();
    }





    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
         builder.sources(SpringBootLogApplication.class);
        return builder;
    }


    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new HelloServlet2());
        servletRegistrationBean.addUrlMappings("/hello2");
        servletRegistrationBean.addInitParameter("name","yanglf");
        return servletRegistrationBean;
    }


    @Bean
    public  static WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return factory -> {
            if(factory instanceof TomcatServletWebServerFactory){
                TomcatServletWebServerFactory serverFactory = TomcatServletWebServerFactory.class.cast(factory);
                serverFactory.setPort(8888);
                serverFactory.setProtocol("org.apache.coyote.http11.Http11NioProtocol");
            }
        };
    }



}
