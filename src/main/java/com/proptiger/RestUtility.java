package com.proptiger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.proptiger.local.LocalService;
import com.proptiger.local.entity.Local;
import com.proptiger.server.ServerService;
import com.proptiger.server.entity.Server;

@Component
public class RestUtility {

	@Autowired
	private ServerService serverService;

	@Autowired
	private LocalService localService;

	@Scheduled(cron="*/5 * * * * *")
	public void run() throws InterruptedException {
		Integer id = localService.getRecentId();
		System.out.println("Id : "+id);
		List<Server> list=serverService.getData(id);
		List<Local> resultList = new ArrayList<Local>();
		for(Server s:list)
		{
			Local local=new Local();
			local.setId(s.getId());
			local.setCity_id(s.getCity_id());
			local.setCity_name(s.getCity_name());
			//local.setEnquiry_type_id(s.getEnquiry_type_id());
			local.setLead_sale_type(s.getLead_sale_type());
			local.setCreated_date(s.getCreated_date());
			resultList.add(local);
		}

		localService.postData(resultList);

	}
}
