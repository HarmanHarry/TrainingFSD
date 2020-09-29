package com.eval.coronakit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.KitDetailRepository;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.exception.ProductException;

@Service
public class KitDetailServiceImpl implements KitDetailService {

	@Autowired
	KitDetailRepository repository;
	
	@Override
	public KitDetail addKitItem(KitDetail kitItem) throws ProductException {
		if (kitItem!=null)			
		{
			repository.save(kitItem);
		}
		return kitItem;
	}

	@Override
	public KitDetail getKitItemById(int itemId) {
		return repository.findById(itemId).orElse(null);
	}

	@Override
	public List<KitDetail> getAllKitItemsOfAKit(int kitId) {
		return repository.findAllCoronaKitId(kitId);		
	}

}
