package in.ecom.ekart.clc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ecom.ekart.clc.app.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findUserByUsernameAndPassword(String username, String password);

}
