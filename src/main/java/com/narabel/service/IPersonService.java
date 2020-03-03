package com.narabel.service;

import javax.ws.rs.core.Response;

public interface IPersonService {
	public Response findAll();
	public Response findById(int id);
}
