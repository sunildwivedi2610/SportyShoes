package com.sportyshoes.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.entity.PurchaseReport;
import com.sportyshoes.entity.Shoes;
import com.sportyshoes.service.SportyShoeService;

@RestController
public class Search {
	
	@Autowired
	private SportyShoeService service;
	@InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
	}
	@GetMapping("/admin/shoes/all")
	public ResponseEntity<List<Shoes>> getAllShoes(){
		return new ResponseEntity<List<Shoes>>(service.getAllShoes(), HttpStatus.OK);
	}
	@GetMapping("/admin/purchaseReport/category/{category}")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReportByCategory(@PathVariable String category){
		return new ResponseEntity<List<PurchaseReport>>(service.getAllPurchaseReportsByCategory(category),HttpStatus.OK);
	}
	@GetMapping("/admin/purchaseReport/date/{dateInMs}")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReportByDateOfPurchase(@PathVariable Long dateInMs){
		Date dateOfPurchase = new Date(dateInMs);
		return new ResponseEntity<List<PurchaseReport>>(service.getAllPurchaseReportsBydateOfPurchase(dateOfPurchase), HttpStatus.OK);
	}
	@GetMapping("/admin/purchasereport/all")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReport(){
		return new ResponseEntity<List<PurchaseReport>>(service.getAllPurchaseReports(),HttpStatus.OK);
	}
}
