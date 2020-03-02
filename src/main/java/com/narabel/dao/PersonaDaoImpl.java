package com.narabel.dao;

import java.util.ArrayList;
import java.util.List;

import com.narabel.entity.Persona;


public class PersonaDaoImpl implements IPersonaDao {


	public List<Persona> findAll() {
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona(1, "nelson"));
		personas.add(new Persona(2, "daniel"));
		return personas;
	}

	@Override
	public Persona findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
