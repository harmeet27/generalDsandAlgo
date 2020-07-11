package lld.bms.model;

public class TicketDetails {

    private PaymentMode mode;
    private int ticketId;
    private int amount;

    public TicketDetails(PaymentMode mode, int ticketId, int amount) {
        this.mode = mode;
        this.ticketId = ticketId;
        this.amount = amount;
    }

    public PaymentMode getMode() {
        return mode;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getAmount() {
        return amount;
    }

}
