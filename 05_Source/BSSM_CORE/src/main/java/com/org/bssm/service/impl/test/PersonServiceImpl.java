package com.org.bssm.service.impl.test;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.org.bssm.base.page.Pagination;
import com.org.bssm.base.page.PagingResult;
import com.org.bssm.dao.test.IPersonDao;
import com.org.bssm.domain.test.Person;
import com.org.bssm.service.test.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Resource
	private IPersonDao iPersonDao;
	
	public Person getPersonById(int personId) {
		return iPersonDao.selectByPrimaryKey(personId);
	}

	public PagingResult<Person> getPersons(Map<Object, Object> param, Integer page) {
		if (page == null || page < 1) {
            page = 1;
        }
        Pagination p = new Pagination(page);
        p.setParams(param);
        
        return iPersonDao.queryByPage(p);
        
	}

	public void deleltePerson(Person person) {
		iPersonDao.deleteByPrimaryKey(person);
	}

	public void updatePerson(Person person) {
		iPersonDao.updateByPrimaryKeySelective(person);
	}

	public void savePerson(Person person) {
		iPersonDao.insertSelective(person);
	}

}
