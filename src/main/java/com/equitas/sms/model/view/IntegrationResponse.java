package com.equitas.sms.model.view;


import lombok.*;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;


@Data
@Builder
@Getter
@Setter
public class IntegrationResponse<T> {

    private MessageResponseHeader msgHdr;

    private T msgBdy;


}
