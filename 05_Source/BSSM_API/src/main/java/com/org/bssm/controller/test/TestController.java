package com.org.bssm.controller.test;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.bssm.base.constants.Constants;
import com.org.bssm.base.page.PagingResult;
import com.org.bssm.base.respond.JsonResponds;
import com.org.bssm.base.util.MessageUtils;
import com.org.bssm.domain.test.Person;
import com.org.bssm.respondDto.test.RespondPerson;
import com.org.bssm.service.test.PersonService;

/**
 * 演示以restful为规则的API结构
 * GET /persons：列出所有人
   POST /persons：新建一个人
   GET /persons/ID：获取某个指定人的信息
   PUT /persons/ID：更新某个指定人的信息
   DELETE /person/ID：删除某个人
 * @author linliuan
 *
 */
@Controller
@RequestMapping("/persons")
public class TestController extends BaseController{

	@Resource
	private PersonService personService;
    
	/**
     * 列出所有人
     * 
     * @param jsonReq
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponds getAllPersons() {
        try {
            //这里需要验证数据的完整性和token,API的接口check需要严密
        	//TODO
        	RespondPerson rp = new RespondPerson();
        	PagingResult<Person> pageResult = personService.getPersons(new HashMap<Object, Object>(), null);
        	// 这里需要对返回值做处理，
        	rp.setResDtoList(pageResult.getResultList());
            return rp;
        }
        catch (Exception ex) {
            log.error("meesage", ex);
            return new JsonResponds(Constants.RESULT_ERROR, MessageUtils.getText("err.com.sys.err"));
        }
    }
    
    /**
     * 新建一个人
     * 
     * @param jsonReq
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponds savePerson(@RequestBody Person person) {
        try {
            //这里需要验证数据的完整性和token,API的接口check需要严密
        	//TODO
        	personService.savePerson(person);
        	return new JsonResponds(Constants.RESULT_SUCCESS);
        }
        catch (Exception ex) {
            log.error("meesage", ex);
            return new JsonResponds(Constants.RESULT_ERROR, MessageUtils.getText("err.com.sys.err"));
        }
    }
    
    /**
     * 获取某个指定人的信息
     * 
     * @param jsonReq
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponds savePerson(@PathVariable String id) {
        try {
            //这里需要验证数据的完整性和token,API的接口check需要严密
        	//TODO
        	Person person = personService.getPersonById(Integer.valueOf(id));
        	RespondPerson rp = new RespondPerson();
        	rp.setResDto(person);
        	rp.setResult(Constants.RESULT_SUCCESS);
            return rp;
        }
        catch (Exception ex) {
            log.error("meesage", ex);
            return new JsonResponds(Constants.RESULT_ERROR, MessageUtils.getText("err.com.sys.err"));
        }
    }
    
    /**
     * 更新某个指定人的信息
     * 
     * @param jsonReq
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponds updatePerson(@PathVariable Integer id, @RequestBody Person person) {
        try {
            //这里需要验证数据的完整性和token,API的接口check需要严密
        	//TODO
        	person.setId(id);
        	personService.updatePerson(person);
        	return new JsonResponds(Constants.RESULT_SUCCESS);
        }
        catch (Exception ex) {
            log.error("meesage", ex);
            return new JsonResponds(Constants.RESULT_ERROR, MessageUtils.getText("err.com.sys.err"));
        }
    }
    
    /**
     * 更新某个指定人的信息
     * 
     * @param jsonReq
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponds deletePerson(@PathVariable Integer id) {
        try {
            //这里需要验证数据的完整性和token,API的接口check需要严密
        	//TODO
        	Person person = new Person();
        	person.setId(id);
        	personService.deleltePerson(person);
        	return new JsonResponds(Constants.RESULT_SUCCESS);
        }
        catch (Exception ex) {
            log.error("meesage", ex);
            return new JsonResponds(Constants.RESULT_ERROR, MessageUtils.getText("err.com.sys.err"));
        }
    }
}
