package com.org.bssm.dao.impl.test;

import org.springframework.stereotype.Repository;

import com.org.bssm.base.dao.BaseDao;
import com.org.bssm.base.page.Pagination;
import com.org.bssm.base.page.PagingResult;
import com.org.bssm.dao.test.IPersonDao;
import com.org.bssm.domain.test.Person;

@Repository
public class PersonDaoImpl extends BaseDao implements IPersonDao {

	public void deleteByPrimaryKey(Person record) {
		delete("personMapper.deleteByPrimaryKey", record);
	}

	public void insert(Person record) {
		
	}

	public void insertSelective(Person record) {
		super.insert("personMapper.insertSelective", record);
	}

	public Person selectByPrimaryKey(Integer id) {
		return selectOne("personMapper.selectByPrimaryKey", id);
	}

	public void updateByPrimaryKeySelective(Person record) {
		super.update("personMapper.updateByPrimaryKeySelective", record);
	}

	public void updateByPrimaryKey(Person record) {
		super.update("personMapper.updateByPrimaryKeySelective", record);
	}

	public PagingResult<Person> queryByPage(Pagination page) {
		return this.selectPagination("personMapper.selectAllByParam", "selectAllByParamCount", page);
	}

}
