package com.org.bssm.dao.test;

import com.org.bssm.base.page.Pagination;
import com.org.bssm.base.page.PagingResult;
import com.org.bssm.domain.test.Person;

public interface IPersonDao {
	
	void deleteByPrimaryKey(Person record);

	void insert(Person record);

	void insertSelective(Person record);

    Person selectByPrimaryKey(Integer id);

    void updateByPrimaryKeySelective(Person record);

    void updateByPrimaryKey(Person record);
    
    PagingResult<Person> queryByPage(Pagination page);
    
    
}