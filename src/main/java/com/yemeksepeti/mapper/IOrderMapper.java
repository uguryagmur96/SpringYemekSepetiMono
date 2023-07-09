package com.yemeksepeti.mapper;

import com.yemeksepeti.dto.request.OrderGetOrderRequestDto;
import com.yemeksepeti.dto.response.OrderGetOrderResponseDto;
import com.yemeksepeti.repository.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOrderMapper {
    IOrderMapper INSTANCE= Mappers.getMapper(IOrderMapper.class);

    Order orderFromDto(final OrderGetOrderRequestDto dto);
    OrderGetOrderResponseDto dtoFromOrder(final Order oder);
}
