package es.project.tony.wallets.service;

import es.project.tony.wallets.model.Wallet;
import es.project.tony.wallets.model.dto.TransferDTO;
import es.project.tony.wallets.model.dto.WalletDTO;
import es.project.tony.wallets.repository.WalletDao;
import es.project.tony.wallets.utils.WalletExceptionEnum;
import es.project.tony.wallets.utils.WalletMapper;
import es.project.tony.wallets.utils.exception.WalletException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletDao walletDao;

    public WalletServiceImpl(WalletDao walletDao) {
        this.walletDao = walletDao;
    }


    @Override
    public List<WalletDTO> getWalletsByUserId(Integer userId) {
        return WalletMapper.mapToWalletDTOList(walletDao.getWalletsByUserId(userId));
    }

    @Override
    public List<WalletDTO> transferMoney(TransferDTO transferDTO) throws Exception {
        Wallet originWallet = walletDao.getOne(transferDTO.getOriginWallet());
        Wallet destinationWallet = walletDao.getOne(transferDTO.getDestinationWallet());
        if (originWallet == null || destinationWallet == null) {
            throw new WalletException(WalletExceptionEnum.WALLETS_NOT_FOUND.getMessage());
        }
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
