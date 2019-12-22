/**
 * 
 */
package com.example.cipherchatzy.Repository;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository. JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction. annotation.Transactional;

import com.example.cipherchatzy.Model.FRequestModel;


@Transactional
@Repository
public interface FRequestReposiotry extends JpaRepository<FRequestModel, Long> {
	List<FRequestModel> findBySemail(String email);
	
	Optional<FRequestModel> findBySemailAndRemail(String semail, String remail);
	
	List<FRequestModel> findBySemailOrRemail( String semail, String remail);
	
	Optional<FRequestModel> deleteBySemailAndRemail(String semail, String remail);
	
	Optional<List<FRequestModel>> findByStatusUserAndSemailOrStatusUserAndRemail(String semail, String
	remail, String statusUser, String semail2);

}
