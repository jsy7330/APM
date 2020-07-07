package com.keepgoing.apm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keepgoing.apm.mapper.MainMapper;

@Service
public class MainService {

	
	@Autowired MainMapper mainMapper;
	
	public String getUserInfo() throws Exception{
		return mainMapper.getUserInfo();
	}
}
