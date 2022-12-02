package dto;

import domain.PayType;

public class PayTypeDTO {

    private final PayType payType;

    public PayTypeDTO(PayType payType) {
        this.payType = payType;
    }

    public PayType getPayType() {
        return payType;
    }
}
