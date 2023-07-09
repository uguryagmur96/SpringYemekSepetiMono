package com.yemeksepeti.controller;

import com.yemeksepeti.dto.request.ActivateRequestDto;
import com.yemeksepeti.dto.request.CustomerLoginRequestDto;
import com.yemeksepeti.dto.request.CustomerRegisterRequestDto;
import com.yemeksepeti.dto.response.CustomerRegisterResponseDto;
import com.yemeksepeti.repository.entity.Customer;
import com.yemeksepeti.services.CustomerService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.yemeksepeti.constants.RestApiList.*;

@RestController
@RequestMapping(CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping(REGISTER)
    public ResponseEntity<CustomerRegisterResponseDto> register(@RequestBody CustomerRegisterRequestDto dto){
        return ResponseEntity.ok(customerService.register(dto));
    }
    public ResponseEntity<Boolean> getActivate(@RequestBody ActivateRequestDto dto){
        return ResponseEntity.ok(customerService.getActivate(dto));
    }
    public ResponseEntity<Boolean> login(@RequestBody CustomerLoginRequestDto dto){
        return ResponseEntity.ok(customerService.login(dto));
    }
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

}
