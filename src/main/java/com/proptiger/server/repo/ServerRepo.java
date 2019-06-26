package com.proptiger.server.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proptiger.server.entity.Server;

@Repository
public interface ServerRepo extends JpaRepository<Server, Integer>{

	@Query("SELECT s FROM Server s where s.id > ?1")
	public List<Server> getData(Integer id);

}
