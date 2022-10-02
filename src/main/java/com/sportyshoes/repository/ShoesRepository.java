package com.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entity.Shoes;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes, Integer>{

}
