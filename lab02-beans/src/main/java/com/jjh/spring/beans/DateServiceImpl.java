package com.jjh.spring.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
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
