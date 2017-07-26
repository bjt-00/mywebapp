package com.mywebapp.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mywebapp.dataaccess.dao.MyHibernateJPA;
import com.mywebapp.dataaccess.orm.MyTableObject;

@Service
@Transactional
public class MyServiceImpl implements MyService {
		
	@Resource
	MyHibernateJPA dao;
	
		public List<MyTableObject> getList(){
			return dao.findAll();
		}
		public MyTableObject getUserById(Long userId){
			return dao.findOne(userId);
		}
		
		public MyTableObject save(MyTableObject userOrm){
			return dao.save(userOrm);
		}
		public void update(MyTableObject userOrm){
			dao.updateUser(userOrm.getUserName(),userOrm.getPhone(),userOrm.getUserId());
		}
		public void delete(MyTableObject userOrm){
			dao.delete(userOrm);
		}
}
