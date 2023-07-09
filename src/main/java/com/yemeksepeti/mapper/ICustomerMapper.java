package com.yemeksepeti.mapper;

import com.yemeksepeti.dto.request.CustomerRegisterRequestDto;
import com.yemeksepeti.dto.response.CustomerRegisterResponseDto;
import com.yemeksepeti.repository.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ICustomerMapper {
    ICustomerMapper INSTANCE= Mappers.getMapper(ICustomerMapper.class);
    Customer customerFromDto(final CustomerRegisterRequestDto dto);
    CustomerRegisterResponseDto dtoFromCustomer(final Customer customer);
}
