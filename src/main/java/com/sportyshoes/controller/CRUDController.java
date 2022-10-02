package com.sportyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.entity.PurchaseReport;
import com.sportyshoes.entity.Shoes;
import com.sportyshoes.exception.GlobalException;
import com.sportyshoes.service.SportyShoeService;

@RestController
public class CRUDController {

	@Autowired
	private SportyShoeService service;

	private MultiValueMap<String, String> errorMap;

	@PostMapping("/admin/shoes")
	public ResponseEntity<Shoes> createShoes(@RequestBody Shoes shoe) {
		try {
			return new ResponseEntity<>(service.createShoe(shoe), HttpStatus.OK);
		} catch (GlobalException e) {
			errorMap = new LinkedMultiValueMap<>();
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/admin/shoes/{id}")
	public ResponseEntity<Shoes> getShoeById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(service.getShoesById(id), HttpStatus.OK);
		} catch (GlobalException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage : ", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/admin/shoes")
	public ResponseEntity<Shoes> updateShoe(@RequestBody Shoes shoe){
		return new ResponseEntity<>(service.updateShoes(shoe),HttpStatus.OK);
	}
	@DeleteMapping("/admin/shoes/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
		try {
			service.deleteShoeById(id);
			return new ResponseEntity<>("Succesfully deleted shoe with id- "+id,HttpStatus.OK);
		}
		catch(GlobalException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage: ", e.getMessage());
			return new ResponseEntity<>(e.getMessage(),errorMap, HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/admin/purchasereport")
	public ResponseEntity<PurchaseReport> createPurchaseReport(@RequestBody PurchaseReport pr){
		try {
			return new ResponseEntity<>(service.createPurchaseReport(pr),HttpStatus.OK);
		}
		catch(GlobalException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/admin/purchaseReport/id{id}")
	public ResponseEntity<PurchaseReport> getPurchaseReportById(@PathVariable int id){
		try {
			return new ResponseEntity<>(service.getPurchaseReportById(id), HttpStatus.OK);
		}
		catch(GlobalException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage", e.getMessage());
			return new ResponseEntity<>(null, errorMap, HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/admin/purchaseReport")
	public ResponseEntity<PurchaseReport> updatePurchaseReport(@RequestBody PurchaseReport pr){
		return new ResponseEntity<>(service.updatePurchaseReport(pr),HttpStatus.OK);
	}
	@DeleteMapping("/admin/purchaseReport/{id}")
	public ResponseEntity<String> deletePurchaseReportById(@PathVariable int id){
		try {
			service.deletePurchaseReportById(id);
			return new ResponseEntity<>("Succesfully deleted Purchase Report with id- "+id, HttpStatus.OK);
		}
		catch (GlobalException e) {
			errorMap = new LinkedMultiValueMap<>();
			errorMap.add("errorMessage: ", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), errorMap, HttpStatus.BAD_REQUEST);
			// TODO: handle exception
		}
	}
}
