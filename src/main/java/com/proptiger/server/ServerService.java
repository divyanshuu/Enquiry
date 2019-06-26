package com.proptiger.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proptiger.server.entity.Server;
import com.proptiger.server.repo.ServerRepo;

@Service
public class ServerService {
	
	@Autowired
	private ServerRepo serverRepo;
	
	public List<Server> getData(Integer id)
	{
		return serverRepo.getData(id);
	}

}
