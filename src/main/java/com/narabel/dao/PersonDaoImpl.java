package com.narabel.dao;

import java.util.ArrayList;
import java.util.List;

import com.narabel.entity.Person;


public class PersonDaoImpl implements IPersonDao {


	public List<Person> findAll() {
		List<Person> personas = new ArrayList<Person>();
		personas.add(new Person(1, "nelson", "arabel", "n@gmail.com"));
		personas.add(new Person(2, "daniel", "vera", "v@gmail.com"));
		return personas;
	}

	@Override
	public Person findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
