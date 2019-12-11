package hello;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
//    public WebSecurityConfig(UserRepository userRepository) {
//        this.userRepository = userRepository;       
//    }
//        
//    
	
	@Override   
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home","/register").permitAll() //does not require these pages to authenticated
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")               
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

	//copy 44 - 68// to get username password
    @SuppressWarnings("deprecation")
	@Bean
    @Override
    public UserDetailsService userDetailsService() {
//        UserDetails user =
//             User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                
//                .build();

        List<UserDetails> users = new ArrayList<UserDetails>();
        Iterator<User> userIt = UserService.getAllUsers();//.findAll().iterator();
        while(userIt.hasNext()) {
        	User currentUser = userIt.next();
        	users.add(org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
        			.username(currentUser.getEmailAddress())
        			.password(currentUser.getPassword())
        			.roles(currentUser.getRole())
        			.build());
        }
        
        return new InMemoryUserDetailsManager(users);
    }
        

    //add cookie to response

    
}