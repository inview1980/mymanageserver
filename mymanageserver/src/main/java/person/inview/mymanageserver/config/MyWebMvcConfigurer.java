package person.inview.mymanageserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import person.inview.mymanageserver.interceptor.MyInterceptor;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir = registry.addInterceptor(new MyInterceptor());
        ir.addPathPatterns("/**").excludePathPatterns("/login", "/toLogin")
                .excludePathPatterns("/swagger-ui.html", "/swagger-resources/**",
                        "/v2/api-docs", "/webjars/springfox-swagger-ui/**");
    }
}
