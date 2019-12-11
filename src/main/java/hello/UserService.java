package hello;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	 private static UserRepository userRepository;
	 
	 @Autowired   //lets spring give us JPA access and connects with h2 database
	 public UserService(UserRepository userRepository) {
		 this.userRepository = userRepository;
	 }

	public static Iterator<User> getAllUsers() {
		return userRepository.findAll().iterator();
	}
	   
}
