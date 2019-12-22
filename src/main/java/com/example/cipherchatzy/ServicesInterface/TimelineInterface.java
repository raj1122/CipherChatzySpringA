/**
 * 
 */
package com.example.cipherchatzy.ServicesInterface;


import java.util.Collection;
import javax.validation.Valid;

import com.example.cipherchatzy.Model.TimeLineModel;

/**
 * @author Raj Kumar
 *
 */
public interface TimelineInterface {

	Collection<TimeLineModel> getAllTimelineByEmail(String email);
	
	TimeLineModel createTimeLine(String email, TimeLineModel timeline);
}
