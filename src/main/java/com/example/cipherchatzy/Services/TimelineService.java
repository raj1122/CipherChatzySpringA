/**
 * 
 */
package com.example.cipherchatzy.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cipherchatzy.Exception.ResourceNotFoundException;
import com.example.cipherchatzy.Model.TimeLineModel;
import com.example.cipherchatzy.Model.UserModel;
import com.example.cipherchatzy.Repository.TimelineRepository;
import com.example.cipherchatzy.Repository.UserRepository;
import com.example.cipherchatzy.ServicesInterface.TimelineInterface;


/**
 * @author Raj Kumar
 *
 */

@Service
public class TimelineService implements TimelineInterface {

	@Autowired
	private TimelineRepository timelineRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<TimeLineModel> getAllTimelineByEmail(String email) {
		return timelineRepository.findByEmail(email);
	}

	@Override
	public TimeLineModel createTimeLine(String email, TimeLineModel timeline) {
		UserModel usr = userRepository.findByEmail(email);
		return userRepository.findById(usr.getId()).map(user -> {
			timeline.setUserModel(user);
			return timelineRepository.save(timeline);
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + email + " not found"));
	}

}
