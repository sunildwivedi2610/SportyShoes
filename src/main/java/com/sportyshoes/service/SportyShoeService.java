package com.sportyshoes.service;

import java.util.Date;
import java.util.List;

import com.sportyshoes.entity.PurchaseReport;
import com.sportyshoes.entity.Shoes;
import com.sportyshoes.exception.GlobalException;

public interface SportyShoeService {
	public Shoes createShoe(Shoes shoe) throws GlobalException;
	public Shoes getShoesById(int id) throws GlobalException;
	public Shoes updateShoes(Shoes shoe);
	public void deleteShoeById(int id) throws GlobalException;
	public List<Shoes> getAllShoes();
	
	public PurchaseReport createPurchaseReport(PurchaseReport pr) throws GlobalException;
	public PurchaseReport getPurchaseReportById(int id) throws GlobalException;
	public PurchaseReport updatePurchaseReport(PurchaseReport pr);
	public void deletePurchaseReportById(int id) throws GlobalException;
	public List<PurchaseReport> getAllPurchaseReports();
	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category);
	public List<PurchaseReport> getAllPurchaseReportsBydateOfPurchase(Date dateOfPurchase);
}
