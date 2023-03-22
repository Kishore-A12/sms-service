package com.equitas.sms.integration;


import com.equitas.sms.model.view.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class TipcoIntegration {

    @Autowired
    private WebClient tipcoWebClient;

    @Value("${tipco-api.sendOtp}")
    private String sendOtpUrl;

    @Value("${tipco-api.validateOtp}")
    private String validateOtpUrl;

    public Mono<IntegrationResponse> sendOtp(IntegrationRequest sendOtpRep) {
        log.debug("request=" + sendOtpRep);
        return Mono.just(sendOtpRep)
                .map(tokenData -> {
                    return IntegrationResponse.builder().msgHdr(MessageResponseHeader.builder().rslt("SUCCESS").build())
                            .msgBdy(SmsResponse.builder().Msg("New code generated and code was sent to the user").otp("12345").build()).build();

                });
    }
    public Mono<IntegrationResponseValidate> validateOtp(IntegrationRequestValidate validateOtpRep) {
        log.debug("request=" + validateOtpRep);
        return Mono.just(validateOtpRep)
                .map(tokenDataa -> {
                    return IntegrationResponseValidate.builder().msgHdr(MessageResponseHeaderValidate.builder().rslt("SUCCESS").build())
                            .msgBdy(SmsValidateOtpResponse.builder().Msg("Code matched successfully and user has been verified").build()).build();

                });
    }


    /*public Mono<IntegrationResponse> sendOtp(IntegrationRequest sendOtpRep) {
        log.debug("request=" + sendOtpRep);
        return tipcoWebClient.post()
                .uri(sendOtpUrl)
                .body(BodyInserters.fromValue(sendOtpRep))
                .retrieve()
                .bodyToMono(IntegrationResponse.class);
    }*/



        /*return tipcoWebClient.post()
                .uri(validateOtpUrl)
                .body(BodyInserters.fromValue(validateOtpRep))
                .retrieve()
                .bodyToMono(IntegrationResponseValidate.class);
    }*/

   /* public Mono<IntegrationResponse> monitoringFRM(IntegrationRequest monitoringFRMRep) {
        log.debug("request=" + monitoringFRMRep);
        return tipcoWebClient.post()
                .uri(monitoringFRMUrl)
                .body(BodyInserters.fromValue(monitoringFRMRep))
                .retrieve()
                .bodyToMono(IntegrationResponse.class);
    }*/

}