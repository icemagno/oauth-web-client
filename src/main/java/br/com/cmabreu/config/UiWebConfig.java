package br.com.cmabreu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
//@ComponentScan( basePackages="br.com.cmabreu.*")
public class UiWebConfig implements WebMvcConfigurer {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
	  @Override
	  public void configureViewResolvers(ViewResolverRegistry registry) {
		  registry.jsp("/WEB-INF/", ".jsp");
	  }    

    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

	  @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	      //registry.addResourceHandler("/resources/**").addResourceLocations("resources/");
	      //registry.addResourceHandler("/fotos/**").addResourceLocations("fotos/");
	  }	  
	  
	  @Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	      registry.addViewController("/").setViewName("index");
	      //registry.addViewController("/securedPage").setViewName("securedPage");
	  }	

}