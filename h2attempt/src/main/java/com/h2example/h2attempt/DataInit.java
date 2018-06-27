/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.h2example.h2attempt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.h2example.h2attempt.dao.PersonDAO;
import com.h2example.h2attempt.dao.RoleRepository;
import com.h2example.h2attempt.dao.UserRepository;
import com.h2example.h2attempt.entity.Person;
import com.h2example.h2attempt.entity.Role;
import com.h2example.h2attempt.entity.User;
import com.h2example.h2attempt.service.RoleService;
import com.h2example.h2attempt.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {
     @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    private PersonDAO personDAO;

    @Autowired
    private UserService userService;
    
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public DataInit(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = personDAO.count();

        if (count == 0) {
            Person p1 = new Person();
            User u1 = new User();
            Role r1 = new Role();
            Role r2 = new Role();

            r1.setName("Admin");
            r2.setName("User");
            
            roleRepository.save(r1);
            roleRepository.save(r2);
            Set<Role> roles = new HashSet();
            roles.add(r1);
            roles.add(r2);
            u1.setRoles(roles);
           u1.setUsername("David");
           u1.setPassword("abc");
           userService.save(u1);

            p1.setFullName("John");

            Date d1 = df.parse("1980-12-20");
            p1.setDateOfBirth(d1);
            //

            Person p2 = new Person();

            p2.setFullName("Smith");
            Date d2 = df.parse("1985-11-11");
            p2.setDateOfBirth(d2);

            personDAO.save(p1);
            personDAO.save(p2);
        }

    }

}
