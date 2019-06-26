package com.proptiger.local;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proptiger.local.entity.Local;
import com.proptiger.local.repo.LocalRepo;

@Service
public class LocalService {

	@Autowired 
	LocalRepo localRepo;
	
	public void postData(List<Local> list)
	{
		localRepo.save(list);
	}
	public Integer getRecentId()
	{
		return localRepo.getRecentId();
	}
	
	public List<Display> getData(Integer t,String city,String type) {
		return localRepo.getData(t,city,type);
		
	}
}
