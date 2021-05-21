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


    @Override
    public List<WalletDTO> getWalletsByUserId(Integer userId) {
        return WalletMapper.mapToWalletDTOList(walletDao.getWalletsByUserId(userId));
    }

    @Override
    public List<WalletDTO> transferMoney(TransferDTO transferDTO){
        Wallet originWallet = walletDao.getOne(transferDTO.getOriginWallet());
        Wallet destinationWallet = walletDao.getOne(transferDTO.getDestinationWallet());
        originWallet.setAmount(originWallet.getAmount().subtract(transferDTO.getAmount()));
        destinationWallet.setAmount(destinationWallet.getAmount().add(transferDTO.getAmount()));

        walletDao.saveAndFlush(destinationWallet);
        walletDao.saveAndFlush(originWallet);
        List<Wallet> walletList = new ArrayList<>();
        walletList.add(originWallet);
        walletList.add(destinationWallet);
        return WalletMapper.mapToWalletDTOList(walletList);
    }
}
