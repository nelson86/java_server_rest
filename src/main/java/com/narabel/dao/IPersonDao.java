package com.narabel.dao;

import java.util.List;

import com.narabel.entity.Person;

public interface IPersonDao {
	public List<Person> findAll();
	public Person findById(int id);
}
