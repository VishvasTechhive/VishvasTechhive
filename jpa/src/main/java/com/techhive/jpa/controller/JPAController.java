package com.techhive.jpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techhive.jpa.model.Address;
import com.techhive.jpa.model.Student;
import com.techhive.jpa.service.JPAService;
import com.techhive.jpa.utils.JPAUtils;

@Controller
public class JPAController {

	@Inject
	private JPAService jpaService;

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	@ResponseBody
	public String printHelloWorld() {
		return "Hello world";
	}

	@RequestMapping(value = "saveStudentAddress", method = RequestMethod.GET)
	@ResponseBody
	public String saveStudentAddress() {
		try {

			Student student = new Student();
			student.setFirstName("Vishvas");
			student.setLastName("Patel");
			student.setDegree("M.C.A");

			jpaService.save(student);

			Address address1 = new Address();
			address1.setStreet("Piplod");
			address1.setCity("Surat");
			address1.setCountry("India");
			address1.setStudent(student);

			Address address2 = new Address();
			address2.setStreet("Dumas");
			address2.setCity("Surat");
			address2.setCountry("India");
			address2.setStudent(student);

			List<Address> listOfAddresses = new ArrayList<Address>();
			listOfAddresses.add(address1);
			listOfAddresses.add(address2);

			jpaService.save(address1);
			jpaService.save(address2);

		} catch (Exception e) {
			e.printStackTrace();
			return JPAUtils.FAIL_RESULT;
		}

		return JPAUtils.SUCCESS_RESULT;
	}

	@RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String saveOrUpdate(@RequestParam(value = "jsonObject") String jsonObject,
			@RequestParam(value = "tableName") String tableName) {

		try {

			if (tableName.equalsIgnoreCase(JPAUtils.TABLE_NAME_FOR_STUDENT)) {
				Student student = JPAUtils.MAPPER.readValue(jsonObject, Student.class);
				
				if (JPAUtils.isObjectisNullOrEmpty(student.getId())){
					jpaService.save(student);
				}
			}

			if (tableName.equalsIgnoreCase(JPAUtils.TABLE_NAME_FOR_ADDRESS)) {
				Address address = JPAUtils.MAPPER.readValue(jsonObject, Address.class);
				
				if (JPAUtils.isObjectisNullOrEmpty(address.getId())){
					jpaService.save(address);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JPAUtils.FAIL_RESULT;
		}

		return JPAUtils.SUCCESS_RESULT;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "getById", method = RequestMethod.POST)
	@ResponseBody
	public <T> T getById(@RequestParam(value = "id") Long id, @RequestParam(value = "tableName") String tableName) {

		T t = null;

		try {

			if (tableName.equalsIgnoreCase(JPAUtils.TABLE_NAME_FOR_STUDENT)) {
				t = (T) jpaService.getById(id, new Student());
			}
			if (tableName.equalsIgnoreCase(JPAUtils.TABLE_NAME_FOR_ADDRESS)) {
				t = (T) jpaService.getById(id, new Address());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return t;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "getAllRecords", method = RequestMethod.POST)
	@ResponseBody
	public <T> List<T> getAllRecords( @RequestParam(value = "tableName") String tableName) {
		
		List<T> listOfT = new ArrayList<T>();
		try {
			if (tableName.equalsIgnoreCase(JPAUtils.TABLE_NAME_FOR_STUDENT)){
				listOfT = (List<T>) jpaService.getAllRecords(new Student());
			}
			if (tableName.equalsIgnoreCase(JPAUtils.TABLE_NAME_FOR_ADDRESS)){
				listOfT = (List<T>) jpaService.getAllRecords(new Address());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return JPAUtils.isListIsNullOrEmpty(listOfT) ? new ArrayList<T>() : listOfT;
	}

}
