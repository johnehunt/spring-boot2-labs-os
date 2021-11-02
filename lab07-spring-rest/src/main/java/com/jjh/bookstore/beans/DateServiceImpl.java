package com.jjh.bookstore.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateServiceImpl implements DateService {
	
	private Date date;

	@Override
	public String getDate() {
		return date.toString();
	}

	@Value("#{new java.util.Date()}")
	public void setDate(Date date) {
		this.date = date;
	}

}
