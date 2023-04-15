package com.api.insurance_management_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.insurance_management_platform.dto.Client;
/*
 * JpaRepository< [class_name] , [wrapperClass_of_primary_key_datatype] >
 * here, class_name is that class where repository will be used 
 */
public interface ClientRepository extends JpaRepository<Client, Integer> {

    
}
