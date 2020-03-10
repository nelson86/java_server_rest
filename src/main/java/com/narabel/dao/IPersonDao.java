package com.narabel.dao;

import java.util.List;

import org.jvnet.hk2.annotations.Contract;

import com.narabel.entity.Person;

public interface IPersonDao {
	public List<Person> findAll();
	public Person findById(int id);
}
