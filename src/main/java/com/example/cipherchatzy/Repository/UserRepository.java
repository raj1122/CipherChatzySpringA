/**
 * 
 */
package com.example.cipherchatzy.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cipherchatzy.Model.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
	UserModel findByEmailAndPass (String email, String pass);
	UserModel findByEmail(String email);
	Optional<List<UserModel>> findByEmailNot (String email);


}
