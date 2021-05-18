package es.project.tony.wallets.model.dto;

import java.math.BigDecimal;

public class TransferDTO {

    private Integer originWallet;
    private Integer destinationWallet;
    private BigDecimal amount;

    public Integer getOriginWallet() {
        return originWallet;
    }

    public void setOriginWallet(Integer originWallet) {
        this.originWallet = originWallet;
    }

    public Integer getDestinationWallet() {
        return destinationWallet;
    }

    public void setDestinationWallet(Integer destinationWallet) {
        this.destinationWallet = destinationWallet;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
