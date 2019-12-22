/**
 * 
 */
package com.example.cipherchatzy.Repository;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype. Repository;

import com.example.cipherchatzy.Model.TimeLineModel;


@Repository
public interface TimelineRepository extends JpaRepository<TimeLineModel, Long> {
	List<TimeLineModel> findByEmail(String email);

}
