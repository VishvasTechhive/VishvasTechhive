package com.techhive.jpa.utils;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JPAUtils {
	
	public static final String TABLE_NAME_FOR_STUDENT = "student";
	public static final String TABLE_NAME_FOR_ADDRESS = "address";
	
	public static final String FAIL_RESULT = "fail";
	public static final String SUCCESS_RESULT = "success";
	
	public static ObjectMapper MAPPER = new ObjectMapper();

	/***
	 * This generic method is used to check whether object is null or empty. if
	 * object t is null or empty then it throws NullPointerException
	 * 
	 * @param t indicates any zero or more objects like String,List,Set etc.
	 */
	public static <T> boolean isObjectisNullOrEmpty(T... t) {
		for (T ob : t) {

			if (ob == null || ob == "") {
				return true;
			}
		}
		return false;
	}

	/***
	 * This method is used to check whether id is null or not. if id is null
	 * then it throws IllegalArgumentException.
	 * 
	 * @param methodName indicates method name containing error.
	 * @param id indicates any zero or more objects like String,List,Set etc.
	 */
	public static void checkIdIsZeroOrNot(String methodName, int id) {
		if (id == 0) {
			throw new IllegalArgumentException("errorMessage");
		}
	}

	/***
	 * This Generic method is used to check whether passed object is null or
	 * not.
	 * 
	 * @param t indicates any passed object.
	 * @return true if object is null otherwise false.
	 */
	public static <T> boolean isObjectIsNull(T t) {
		if (t == null) {
			return true;
		}
		return false;
	}

	/***
	 * This Generic method is used to check if list is empty of null.
	 * 
	 * @param listT indicates list.
	 * @return return true if list is null or empty, otherwise return false.
	 */
	public static <T> boolean isListIsNullOrEmpty(List<T> listT) {

		if (listT == null || listT.isEmpty()) {
			return true;
		}
		return false;
	}

	/***
	 * This Generic method is used to check if set is empty of null.
	 * 
	 * @param listT indicates set.
	 * @return return true if set is null or empty, otherwise return false.
	 */
	public static <T> boolean isSetIsNullOrEmpty(Set<T> setT) {

		if (setT == null || setT.isEmpty()) {
			return true;
		}
		return false;
	}
}
