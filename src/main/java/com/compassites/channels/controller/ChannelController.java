package com.compassites.channels.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/channel")
public class ChannelController {
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createChannel(){
		return null;
	}
	
}
