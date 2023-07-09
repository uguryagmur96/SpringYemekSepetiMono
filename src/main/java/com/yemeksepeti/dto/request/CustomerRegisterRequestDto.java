package com.yemeksepeti.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerRegisterRequestDto {
    @NotEmpty(message = "Kullanıcı adı boş geçilemez")
    @Size(min = 3,max = 64,message = "Kullanıcı adınız 3 ila 64 karakter içerisinde olmalıdır")
    String username;
    @Size(min = 8,max = 64,message = "Şifreniz 3 ila 64 karakter içerisinde olmalıdır")
    @Pattern(
            message = "Şifre en az 8 karakter olmalı, içinde en az bir büyük bir küçük harf sayı ve rakam olmalıdır.",
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$")
    String password;
    @Email(message = "Lütfen geçerli bir mail adresi giriniz")
    @Pattern(regexp = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/.")
    String email;
    @NotEmpty(message = "Adres boş geçilemez")
    @Size(min = 15,max = 200)
    String address;
    @NotEmpty(message = "Telefon numarası boş geçilemez")
    String phoneNumber;
    @NotEmpty(message = "Kart bilgileri boş geçilemez")
    String cardDetails;
}
