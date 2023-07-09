package com.yemeksepeti.services;

import com.yemeksepeti.dto.request.ActivateRequestDto;
import com.yemeksepeti.dto.request.CustomerLoginRequestDto;
import com.yemeksepeti.dto.request.CustomerRegisterRequestDto;
import com.yemeksepeti.dto.response.CustomerRegisterResponseDto;
import com.yemeksepeti.exception.ErrorType;
import com.yemeksepeti.exception.YemekSepetiException;
import com.yemeksepeti.mapper.ICustomerMapper;
import com.yemeksepeti.repository.ICustomerRepository;
import com.yemeksepeti.repository.entity.Customer;
import com.yemeksepeti.repository.enums.EStatus;
import com.yemeksepeti.util.ServiceManager;
import com.yemeksepeti.util.codeGenerator;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer,Long> {
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository){
        super(customerRepository);
        this.customerRepository=customerRepository;
    }

    public CustomerRegisterResponseDto register(CustomerRegisterRequestDto dto) {
        customerRepository.findOptionalByEmail(dto.getEmail()).ifPresent(cus->{
            throw new YemekSepetiException(ErrorType.REGISTER_MAIL_ADRESI_KAYITLI);
        });
        Customer customer= ICustomerMapper.INSTANCE.customerFromDto(dto);
        customer.setActivationCode(codeGenerator.genCode());
        customerRepository.save(customer);
  CustomerRegisterResponseDto responseDto=ICustomerMapper.INSTANCE.dtoFromCustomer(customer);
  return responseDto;
    }

    public Boolean getActivate(ActivateRequestDto dto) {
        Optional<Customer> optCus=customerRepository.findOptionalByEmail(dto.getEmail());
        if(optCus.isEmpty()){
            throw new YemekSepetiException(ErrorType.USER_NOT_FOUND);
        }
        if(optCus.get().getStatus().equals(EStatus.ACTIVE)){
            throw new YemekSepetiException(ErrorType.ALREADY_ACTIVE_USER);
        }
        if (dto.getActivateCode().equals(optCus.get().getActivationCode())){
            optCus.get().setStatus(EStatus.ACTIVE);
            update(optCus.get());
            return true;
        }
        else{
            throw new YemekSepetiException(ErrorType.INTERNAL_SERVER_ERROR);
        }
    }
    public Boolean login(CustomerLoginRequestDto dto) {
        Optional<Customer> optCus=customerRepository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if(optCus.isEmpty()){
            throw new YemekSepetiException(ErrorType.USER_NOT_FOUND);
        }
        if(!optCus.get().getStatus().equals(EStatus.ACTIVE)){
            throw new YemekSepetiException(ErrorType.NOT_ACTIVATED);
        }
        return true;
    }
}
