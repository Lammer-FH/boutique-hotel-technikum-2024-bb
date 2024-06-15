package com.awt.boutiquehoteltechnikum.Mapper;

import com.awt.boutiquehoteltechnikum.DTO.CustomerDTO;
import com.awt.boutiquehoteltechnikum.DTO.Request.CustomerRequestDTO;
import com.awt.boutiquehoteltechnikum.DomainModels.CreateBookingCommand;
import com.awt.boutiquehoteltechnikum.DomainModels.CreateCustomerCommand;
import com.awt.boutiquehoteltechnikum.Entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerEntity customerDTOtoCustomer(CustomerDTO customerDTO);
    CustomerEntity customerRequestDTOtoCustomer(CustomerRequestDTO customerDTO);
    CustomerDTO customerToCustomerDTO(CustomerEntity customerEntity);

    CreateCustomerCommand customerRequestDTOtoCreateCustomerCommand(CustomerRequestDTO customerRequestDTO);
    CustomerEntity customerRequestDTOtoCustomerEntity(CreateCustomerCommand createCustomerCommand);
    CustomerEntity createBookingCommandtoCustomerEntity(CreateBookingCommand createBookingCommand);

}
