package es.project.tony.wallets.utils;

public enum WalletExceptionEnum {
    WALLETS_NOT_FOUND("Hay alguna cartera no informada"),
    WALLET_USER_NOT_ADMIN("El usuario no es administrador");
    private String message;

    WalletExceptionEnum(String message) {
        this.message = message;
    }

    WalletExceptionEnum() {
    }

    public String getMessage() {
        return message;
    }
}
