package com.jjh.bookstore.beans;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateServiceImpl implements DateService {
	
	private Date date;
	
	public DateServiceImpl() {
		date = new Date();
	}

	@Override
	public String getDate() {
		return date.toString();
	}

}
