/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.h2example.h2attempt.dao;
import java.util.Date;
import java.util.List;
 
import com.h2example.h2attempt.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface PersonDAO extends CrudRepository<Person, Long> {
 
    public List<Person> findByFullNameLike(String name);
 
    public List<Person> findByDateOfBirthGreaterThan(Date date);
 
}