package es.project.tony.wallets.utils.exception;

import es.project.tony.wallets.utils.WalletExceptionEnum;

public class WalletException extends RuntimeException {

    public WalletException(String message) {
        super(message);
    }
}
