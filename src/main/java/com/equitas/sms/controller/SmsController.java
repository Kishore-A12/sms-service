package com.equitas.sms.controller;

import com.equitas.sms.model.view.*;

import com.equitas.sms.service.SmsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/sms")
public class SmsController {


    @Autowired
    private SmsService smsservice;

    @PostMapping(value = "/sendsmsotp")
    public Mono<IntegrationResponse> sendOtp(@RequestBody  SmsRequest sotp) {
        return Mono.defer(() -> smsservice.sendOtp(sotp));
    }

    @GetMapping("/signup")
    public String showSignUpForm() {
        return "adduser";
    }

    @PostMapping(value = "/validatesmsotp")
    public Mono<IntegrationResponseValidate> validateOtp(@RequestBody SmsValidateOtpRequest votp) {

        return Mono.defer(() -> smsservice.validateOtp(votp));
    }





   /* @PostMapping(value ="/validatesmsotp")
    public Mono<IntegrationResponseValidate> validateOtp(@RequestBody SmsValidateOtpRequest votp) {

    return Mono.defer(() -> smsservice.va

    }

*/

   /* @PostMapping(value ="/validatesmsotp")
    public Mono<IntegrationResponseValidate> validateOtp(@RequestBody SmsValidateOtpRequest votp) {

        return Mono.defer(() -> smsservice.validateOtp(votp));
    }
*/



}
