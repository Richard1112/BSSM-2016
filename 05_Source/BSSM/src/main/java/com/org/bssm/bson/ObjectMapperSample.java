package com.org.bssm.bson;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.bssm.domain.test.Person;

public class ObjectMapperSample {
	public static void main(String[] s) throws JsonGenerationException, JsonMappingException, IOException {
		 //create dummy POJO
	    Person bob = new Person();
	    bob.setName("Bob");
	    bob.setAge(1);
	 
	    //serialize data
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ObjectMapper mapper = new ObjectMapper(new BsonFactory());
	    mapper.writeValue(baos, bob);
//	    String ss = mapper.writeValueAsString(bob);
//	    System.out.println(ss);
	 
	    //deserialize data
	    ByteArrayInputStream bais = new ByteArrayInputStream(
	      baos.toByteArray());
	    Person clone_of_bob = mapper.readValue(bais, Person.class);
	 
	    assert bob.getName().equals(clone_of_bob.getName());
	}
}
