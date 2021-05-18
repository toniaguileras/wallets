package es.project.tony.wallets.service;

import es.project.tony.wallets.model.dto.WalletDTO;

import java.util.List;

public interface WalletService {

    List<WalletDTO> getWalletsByUserId(Integer userId);
}
