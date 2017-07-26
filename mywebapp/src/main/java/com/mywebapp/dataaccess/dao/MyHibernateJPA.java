package com.mywebapp.dataaccess.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mywebapp.dataaccess.orm.MyTableObject;


public interface MyHibernateJPA extends JpaRepository<MyTableObject,Long> {
	
	@Query("select distinct u from MyTableObject u")
	List<MyTableObject> getList();

	@Query("select distinct u from MyTableObject u where u.userId= :userId")
	MyTableObject getUserById(@Param("userId") Long userId);

	@Modifying
	@Query("update MyTableObject u set u.userName = ?1, u.phone = ?2 where u.userId = ?3")
	void updateUser(String userName, String phone, Long userId);
	
}
