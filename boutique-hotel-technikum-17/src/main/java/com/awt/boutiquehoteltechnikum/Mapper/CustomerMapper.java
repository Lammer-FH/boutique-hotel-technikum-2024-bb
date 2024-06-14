package com.awt.boutiquehoteltechnikum.Mapper;

import com.awt.boutiquehoteltechnikum.DTO.CustomerDTO;
import com.awt.boutiquehoteltechnikum.DTO.Request.CustomerRequestDTO;
import com.awt.boutiquehoteltechnikum.Entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerEntity customerDTOtoCustomer(CustomerDTO customerDTO);
    CustomerEntity customerRequestDTOtoCustomer(CustomerRequestDTO customerDTO);
    CustomerDTO customerToCustomerDTO(CustomerEntity customerEntity);

}
