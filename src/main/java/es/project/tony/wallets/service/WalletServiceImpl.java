package es.project.tony.wallets.service;

import es.project.tony.wallets.model.dto.WalletDTO;
import es.project.tony.wallets.repository.WalletDao;
import es.project.tony.wallets.utils.WalletMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService
{
    @Autowired private WalletDao walletDao;
    @Override
    public List<WalletDTO> getWalletsByUserId(Integer userId) {
        return WalletMapper.mapToWalletDTOList(walletDao.getWalletsByUserId(userId));
    }
}
