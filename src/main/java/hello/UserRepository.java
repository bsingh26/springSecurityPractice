package hello;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, Long>{  //create request update delete
	User findByEmailAddress(String emailAddress); //spring dynamically generates SQL, it automatically generates Select * from

}

