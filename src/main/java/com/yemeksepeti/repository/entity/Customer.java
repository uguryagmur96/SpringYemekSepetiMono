package com.yemeksepeti.repository.entity;

import com.yemeksepeti.repository.enums.ERole;
import com.yemeksepeti.repository.enums.EStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tblcustomer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String email;
    String address;
    String phoneNumber;
    String password;
    String cardDetails;
    Long balance;
    String activationCode;
    @Builder.Default
    EStatus status=EStatus.PENDING;
    @Builder.Default
    ERole role=ERole.USER;

}
