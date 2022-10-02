package com.sportyshoes.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sportyshoes.entity.PurchaseReport;
import com.sportyshoes.entity.Shoes;
import com.sportyshoes.exception.GlobalException;
import com.sportyshoes.repository.PurchaseReportRepository;
import com.sportyshoes.repository.ShoesRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class SportyShoeServiceImpl implements SportyShoeService{
		
		@Autowired
		private ShoesRepository shoesRepository;
		
		@Autowired
		private PurchaseReportRepository purchaseReportRepository;
		
		@Bean
		@PostConstruct
		public void init() {
			Shoes s1 = new Shoes("Shoe Name 1","Basketball",1000.24);
			Shoes s2 = new Shoes("Shoe Name 2","Cricket",1100.24);
			Shoes s3 = new Shoes("Shoe Name 3","Running",900.24);
			
			shoesRepository.save(s1);
			shoesRepository.save(s2);
			shoesRepository.save(s3);
			
			Date d = new Date(0);
			PurchaseReport pr1 = new PurchaseReport("user_1","Running",d,"adidas_runner:5,nike_airmax:10");
			PurchaseReport pr2 = new PurchaseReport("user_2","Cricket",d,"adidas_cricket:5,nike_cricket:10");
			PurchaseReport pr3 = new PurchaseReport("user_3","Basketball",d,"adidas_basketball:5,nike_basketball:10");
			
			purchaseReportRepository.save(pr1);
			purchaseReportRepository.save(pr2);
			purchaseReportRepository.save(pr3);
		}
		
	public Shoes createShoe(Shoes shoe) throws GlobalException {
		int id =shoe.getId();
		Shoes oldShoe = null;
		try {
			oldShoe = shoesRepository.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(oldShoe != null) throw new GlobalException("Shoe already exists with id- "+id);
		return shoesRepository.save(shoe);
	}

	
	public Shoes getShoesById(int id) throws GlobalException {
		Shoes shoe = null;
		try {
			if(id<=0) throw new GlobalException("Shoe id can not be zero");
			shoe = shoesRepository.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new GlobalException("Shoe not found with id- "+id);
		}
		return shoe;
	}

	
	public Shoes updateShoes(Shoes shoe) {
		return shoesRepository.save(shoe);
	}

	
	public void deleteShoeById(int id) throws GlobalException {
		try {
			shoesRepository.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new GlobalException("Please enter valid id-"+id);
		}catch(EmptyResultDataAccessException e) {
			throw new GlobalException("Shoe does not exist with id- "+id);
		}
		
	}
	
	
	public List<Shoes> getAllShoes() {
		return shoesRepository.findAll();
	}

	
	public PurchaseReport createPurchaseReport(PurchaseReport pr) throws GlobalException {
		int id = pr.getId();
		PurchaseReport oldPr = null;
		try {
			oldPr = purchaseReportRepository.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(oldPr != null) throw new GlobalException("Purchase Report already generated with id: "+id);
		return purchaseReportRepository.save(pr);
	}

	
	public PurchaseReport getPurchaseReportById(int id) throws GlobalException {
		PurchaseReport pr = null;
		try {
			if(id<=0)throw new GlobalException("Purchase Report id can not be zero");
			pr = purchaseReportRepository.findById(id).get();
		}
		catch(NoSuchElementException e) {
			throw new GlobalException("Purchase report not found with id- "+id);
		}
		return pr;
	}

	
	public PurchaseReport updatePurchaseReport(PurchaseReport pr) {
		return purchaseReportRepository.save(pr);
	}

	
	public void deletePurchaseReportById(int id) throws GlobalException {
		try {
			purchaseReportRepository.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new GlobalException("Please enter valid id");
		}
		catch(EmptyResultDataAccessException e) {
			throw new GlobalException("Purchase report does not exist with id- "+id);
		}
	}

	
	public List<PurchaseReport> getAllPurchaseReports() {
		return purchaseReportRepository.findAll();
	}

	
	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category) {	
		return purchaseReportRepository.findByCategory(category);
	}

	
	public List<PurchaseReport> getAllPurchaseReportsBydateOfPurchase(Date dateOfPurchase) {
		return purchaseReportRepository.findBydateOfPurchase(dateOfPurchase);
	}

}
