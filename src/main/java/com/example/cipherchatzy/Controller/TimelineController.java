package com.example.cipherchatzy.Controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cipherchatzy.Mapper.TimelineMapper;
import com.example.cipherchatzy.Model.TimeLineModel;
import com.example.cipherchatzy.Services.TimelineService;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("timelineApi/allTimeline")
public class TimelineController {

	@Autowired
	private TimelineService timelineService;

	@Autowired
	private TimelineMapper timelineMapper;

	@GetMapping("/{email}")
	public List<TimeLineModel> getTimlinesByEmail(@PathVariable("email") String email) {
		List<TimeLineModel> timelinelist = timelineService.getAllTimelineByEmail(email);
		return timelinelist;
	}
	
	@PostMapping("/{email}")
	public TimeLineModel createComment(@PathVariable("email") String email , 
						@Valid @RequestBody TimeLineModel timeline) {
		return timelineService.createTimeLine(email, timeline);
	}

}
