package com.equitas.sms.model.view;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class IntegrationResponseValidate<T> {

    private MessageResponseHeaderValidate msgHdr;

    private T msgBdy;

}
