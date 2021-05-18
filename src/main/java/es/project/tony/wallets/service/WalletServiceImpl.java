package es.project.tony.wallets.service;

import es.project.tony.wallets.model.Wallet;
import es.project.tony.wallets.model.dto.TransferDTO;
import es.project.tony.wallets.model.dto.WalletDTO;
import es.project.tony.wallets.repository.WalletDao;
import es.project.tony.wallets.repository.WalletRepository;
import es.project.tony.wallets.utils.WalletMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletDao walletDao;
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public List<WalletDTO> getWalletsByUserId(Integer userId) {
        return WalletMapper.mapToWalletDTOList(walletDao.getWalletsByUserId(userId));
    }

    @Override
    public List<WalletDTO> transferMoney(TransferDTO transferDTO){
        Wallet originWallet = walletRepository.getOne(transferDTO.getOriginWallet());
        Wallet destinationWallet = walletRepository.getOne(transferDTO.getDestinationWallet());
        originWallet.setAmount(destinationWallet.getAmount().subtract(transferDTO.getAmount()));
        destinationWallet.setAmount(destinationWallet.getAmount().add(transferDTO.getAmount()));

        walletRepository.saveAndFlush(destinationWallet);
        walletRepository.saveAndFlush(originWallet);
        List<Wallet> walletList = new ArrayList<>();
        walletList.add(originWallet);
        walletList.add(destinationWallet);
        return WalletMapper.mapToWalletDTOList(walletList);
    }
}
