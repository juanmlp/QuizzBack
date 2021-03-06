package com.nex.springboot.backend.quizz.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nex.springboot.backend.quizz.models.dao.ICardDao;
import com.nex.springboot.backend.quizz.models.entity.Card;

@Service
public class CardServiceImpl implements ICardService{
	
	@Autowired
	private ICardDao cardDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Card> findAll() {
		return (List<Card>) cardDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Card findById(Long id) {
		return cardDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Card save(Card card) {
		return cardDao.save(card);
	}

	@Override
	public void delete(Long id) {
		cardDao.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Card> findAllByCategoryId(Long id) {
		return cardDao.findAllByCategoryId(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Page<Card> findAll(Pageable pageable) {
		return cardDao.findAll(pageable);
	}

}
