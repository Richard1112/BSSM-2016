package com.org.bssm.service.test;

import java.util.Map;

import com.org.bssm.base.page.PagingResult;
import com.org.bssm.domain.test.Person;

public interface PersonService {
	
	/**
	 * 检索单个实体对象
	 * @param personId
	 * @return
	 */
	public Person getPersonById(int personId);
	
	/**
	 * 分页检索所有的人物
	 * @param param
	 * @param page
	 * @return
	 */
	public PagingResult<Person> getPersons(Map<Object, Object> param, Integer page);
	
	/**
	 * 删除人物数据
	 * @param person
	 * @return
	 */
	public void deleltePerson(Person person);
	
	/**
	 * 更新人物数据
	 * @param person
	 * @return
	 */
	public void updatePerson(Person person);
	
	/**
	 * 保存人物数据
	 * @param person
	 * @return
	 */
	public void savePerson(Person person);
}
