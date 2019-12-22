/**
 * 
 */
package com.example.cipherchatzy.Repository;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cipherchatzy.Model.PhotosModel;
import com.example.cipherchatzy.Model.UserModel;


@Repository
public interface PhotosRepository extends JpaRepository<PhotosModel, Long> {
	Optional<List<PhotosModel>> findByUserModel(UserModel userFromRepo);

}
