package com.narabel.dao;

import java.util.List;

import com.narabel.entity.Persona;

public interface IPersonaDao {
	public List<Persona> findAll();
	public Persona findById(int id);
}
