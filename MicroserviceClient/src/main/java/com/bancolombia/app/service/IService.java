package com.bancolombia.app.service;

import java.util.List;

import com.bancolombia.app.entities.Client;

public interface IService {
	
	boolean insert (Client cl);
	List<Client> selectAll();

}
