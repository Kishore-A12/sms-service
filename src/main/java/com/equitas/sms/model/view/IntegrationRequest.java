package com.equitas.sms.model.view;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;


@Data
@Builder
@Getter
@Setter
public class IntegrationRequest<T> {

    private MessageRequestHeader msgHdr;
    private T msgBdy;


}
