package com.magalu.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;

import com.magalu.entity.Channel;
import com.magalu.entity.Status;
import com.magalu.repository.ChannelRepository;
import com.magalu.repository.StatusRepository;

//@Configuration
public class DataLoader implements CommandLineRunner {

	private final ChannelRepository channelRepository;
	private final StatusRepository statusRepository;
	
	DataLoader(ChannelRepository channelRepository, StatusRepository statusRepository) {
		this.channelRepository = channelRepository;
		this.statusRepository = statusRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		Arrays.stream(Status.Values.values())
		.map(Status.Values::toStatus)
		.forEach(statusRepository::save);

		Arrays.stream(Channel.Values.values())
		.map(Channel.Values::toChannel)
		.forEach(channelRepository::save);
		
	}

}
