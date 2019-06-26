package com.proptiger.local.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proptiger.local.Display;
import com.proptiger.local.entity.Local;

@Repository
public interface LocalRepo extends JpaRepository<Local, Integer> {

	@Query("SELECT MAX(id) FROM Local l")
	public Integer getRecentId();
	
	@Query("SELECT new com.proptiger.local.Display(FLOOR(TIMESTAMPDIFF(SECOND,l.created_date,now())/(?1*60))*(?1),COUNT(*),l.city_name,l.lead_sale_type) FROM Local l WHERE l.city_name=?2 AND l.lead_sale_type=?3 GROUP BY FLOOR(TIMESTAMPDIFF(SECOND,l.created_date,now())/(?1*60))*?1")
	public List<Display> getData(Integer time,String city,String type);
}
