package lld.model;

public enum PaymentMode {

    GPAY("gpay"), PHONE_PE("phonepe"), AMAZON_PAY("amazonpay"), PAYTM("paytm"), ONLINE("online");

    private String mode;

    PaymentMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}
