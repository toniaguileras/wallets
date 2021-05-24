package es.project.tony.wallets.utils;

import es.project.tony.wallets.model.Wallet;
import es.project.tony.wallets.model.dto.WalletDTO;

import java.util.ArrayList;
import java.util.List;

public class WalletMapper {


    public static List<WalletDTO> mapToWalletDTOList(List<Wallet> walletList) {
        List<WalletDTO> resultList = new ArrayList<>();
        walletList.forEach(wallet -> resultList.add(mapToWalletDTO(wallet)));
        return resultList;
    }

    public static WalletDTO mapToWalletDTO(Wallet wallet) {
        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setId(wallet.getId());
        walletDTO.setName(wallet.getName());
        walletDTO.setAmount(wallet.getAmount());
        return walletDTO;
    }
}
