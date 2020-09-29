package com.eval.coronakit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.CoronaKitRepository;
import com.eval.coronakit.entity.CoronaKit;

@Service
public class CoronaKitServiceImpl implements CoronaKitService {

	@Autowired
	CoronaKitRepository repository;
	
	@Override
	public CoronaKit saveKit(CoronaKit kit) {
		if (kit!=null)
		{
			repository.save(kit);
		}
		return kit;
	}

	@Override
	public CoronaKit getKitById(int kitId) {
		return repository.findById(kitId).orElse(null);
	}

}
