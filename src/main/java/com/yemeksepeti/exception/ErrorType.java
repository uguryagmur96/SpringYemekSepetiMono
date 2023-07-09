/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.yemeksepeti.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Ugur
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_SERVER_ERROR(1000,"Sunucuda Bilinmeyen bir hata oluştu", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(1001,"İstek formatı hatalı",HttpStatus.BAD_REQUEST),
    REGISTER_KULLANICIADI_KAYITLI(1002,"Kullanıcı adı kayıtlı",HttpStatus.BAD_REQUEST),
    REGISTER_MAIL_ADRESI_KAYITLI(1003,"Bu mail adresi zaten kayıtlı",HttpStatus.BAD_REQUEST),
    INVALID_ACTIVATION_CODE(1004,"Aktivasyon kodu geçersiz",HttpStatus.BAD_REQUEST),
    NAME_IS_NULL(1005,"Name alanı boş geçilemez",HttpStatus.BAD_REQUEST),
    ID_NOT_FOUND(1006,"Aradığınız id ye ait kayıt bulunamadı",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(1007,"Geçersiz token",HttpStatus.BAD_REQUEST),
    ALREADY_ACTIVE_USER(1008,"Hesabınız zaten aktif hale getirilmiş",HttpStatus.BAD_REQUEST),
    NOT_ACTIVATED(1009,"Geçersiz token",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1010,"Aradığınız mail adresine kayıtlı kullanıcı bulunamadı",HttpStatus.BAD_REQUEST),
    RESTAURANT_NOT_FOUND(1011,"Restaurant bulunamadı",HttpStatus.BAD_REQUEST);

    
    
    
    
    int code;
    String message;
    HttpStatus httpStatus;
}
