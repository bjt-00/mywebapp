package com.mywebapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mywebapp.dataaccess.orm.MyTableObject;
import com.mywebapp.service.MyService;

@RestController
@RequestMapping("/userRest")
public class MyRest {
	
	@Autowired
	MyService service;
	
	@RequestMapping(method=RequestMethod.GET )
	public List<MyTableObject> getList(){
		return service.getList();
	}

	//@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public MyTableObject getUserById(@PathVariable("id")Long userId){
		return service.getUserById(userId);
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public MyTableObject addUser(@RequestBody MyTableObject myTableObject){
		System.out.println("post called "+myTableObject.getUserName());
		return service.save(myTableObject);
	}

	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public MyTableObject updateUser(@RequestBody MyTableObject myTableObject){
		System.out.println("update called "+myTableObject.getUserName());
		service.update(myTableObject);
		return myTableObject;
	}
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public MyTableObject deleteUser(@RequestBody MyTableObject myTableObject){
		System.out.println("update called "+myTableObject.getUserName());
		service.delete(myTableObject);
		return myTableObject;
	}

}
