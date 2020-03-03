package com.narabel.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Data
public class Person {
	private int id;
	private String firstname;
	private String lastname;
	private String email;

	public Person(int idperson, String firstname, String lastname, String email) {
		super();
		this.id = idperson;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

}
