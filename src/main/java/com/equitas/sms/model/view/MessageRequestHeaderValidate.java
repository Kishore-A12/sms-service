package com.equitas.sms.model.view;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class MessageRequestHeaderValidate {

    private String msgId;
    private String cnvId;
    private String timestamp;
}
