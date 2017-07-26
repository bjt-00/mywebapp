package com.mywebapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mywebapp.dataaccess.orm.MyTableObject;

@Service
@Transactional
public interface MyService {
		public List<MyTableObject> getList();
		public MyTableObject getUserById(Long userId);
		public MyTableObject save(MyTableObject userOrm);
		public void update(MyTableObject userOrm);
		public void delete(MyTableObject userOrm);
}
