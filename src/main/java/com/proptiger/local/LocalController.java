package com.proptiger.local;

import java.util.List;

import org.hibernate.hql.internal.ast.tree.DisplayableNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalController {
	
	@Autowired
	LocalService localService;
	@GetMapping("/enquiry/{time}/{city}/{type}")
	public List<Display> getData(@PathVariable Integer time,@PathVariable String city,@PathVariable String type)
	{
		return localService.getData(time,city,type);
	}

}
