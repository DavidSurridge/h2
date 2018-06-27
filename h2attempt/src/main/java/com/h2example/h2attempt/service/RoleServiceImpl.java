/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.h2example.h2attempt.service;

import com.h2example.h2attempt.dao.RoleRepository;
import com.h2example.h2attempt.dao.UserRepository;
import com.h2example.h2attempt.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public void save(Role role) {
        role.setName(role.getName());
        
        roleRepository.save(role);
    }

    }