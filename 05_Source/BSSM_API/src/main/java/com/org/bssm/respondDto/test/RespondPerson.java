package com.org.bssm.respondDto.test;

import java.util.List;

import com.org.bssm.base.respond.JsonResponds;
import com.org.bssm.domain.test.Person;

/**
 * 定义API返回类，需要继承JsonResponds统一以这样的一个父类返回
 * @author linliuan
 *
 */
public class RespondPerson extends JsonResponds{

	private Person resDto;
	
	private List<Person> resDtoList;

	public Person getResDto() {
		return resDto;
	}

	public void setResDto(Person resDto) {
		this.resDto = resDto;
	}

	public List<Person> getResDtoList() {
		return resDtoList;
	}

	public void setResDtoList(List<Person> resDtoList) {
		this.resDtoList = resDtoList;
	}

	
}
