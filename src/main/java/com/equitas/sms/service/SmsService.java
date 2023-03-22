package com.equitas.sms.service;

import com.equitas.sms.integration.TipcoIntegration;
import com.equitas.sms.model.view.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SmsService {
    @Autowired
    private TipcoIntegration tipcoIntegration;

    public IntegrationRequest sendOtpRequest() {
        return IntegrationRequest.builder().msgHdr(MessageRequestHeader.builder().build())
                .msgBdy(SmsRequest.builder().build()).build();
    }
    public Mono<IntegrationResponse> sendOtp(SmsRequest sotp) {
        return Mono.from(tipcoIntegration.sendOtp(sendOtpRequest()));

    }
    public IntegrationRequestValidate validateOtpRequest() {
        return IntegrationRequestValidate.builder().msgHdr(MessageRequestHeaderValidate.builder().build())
                .msgBdy(SmsRequest.builder().build()).build();
    }
    public Mono<IntegrationResponseValidate> validateOtp(SmsValidateOtpRequest votp) {
        return Mono.from(tipcoIntegration.validateOtp(validateOtpRequest()));

    }

}




        /*public IntegrationRequestValidate validateOtpRequest() {
            return IntegrationRequestValidate.builder().msgHdr(MessageRequestHeaderValidate.builder().build())
                    .msgBdy(SmsValidateOtpRequest.builder().build()).build();
        }

        public Mono<IntegrationResponseValidate> validateOtp(SmsValidateOtpRequest votp) {
            return Mono.from(tipcoIntegration.validateOtp(validateOtpRequest()));
        }*/






    /*public IntegrationRequestValidate validateOtpRequest() {

        return IntegrationRequestValidate.builder().msgHdr(MessageRequestHeaderValidate.builder().build())
                .msgBdy(SmsRequest.builder().build()).build();
    }*/



 /* public IntegrationRequest  sendOtpRequest() {
         return IntegrationRequest.builder().msgHdr(MessageRequestHeader.builder().build())
                 .msgBdy(SmsRequest.builder().build()).build();
     }
 */
    /*public Mono<IntegrationResponse> sendOtp(SmsRequest sotp) {
        return Mono.from(IntegrationResponse.builder().msgHdr(MessageResponseHeader.builder().rslt("SUCCESS").build())
                .msgBdy(SmsResponse.builder().Msg("New code generated and code was sent the user"))
                .msgBdy(SmsResponse.builder().otp("123456")).build());
    }
*/
  /*  public Mono<SmsResponse> sendOtp(SmsRequest sotp){
        return "sotp.aaa";

    }*/



