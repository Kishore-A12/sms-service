package com.equitas.sms.model.view;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsValidateOtpRequest {

    private String mblNmb;
    private String otp;
}
