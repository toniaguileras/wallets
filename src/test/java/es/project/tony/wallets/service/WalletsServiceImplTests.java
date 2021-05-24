package es.project.tony.wallets.service;


import es.project.tony.wallets.model.User;
import es.project.tony.wallets.model.Wallet;
import es.project.tony.wallets.model.dto.TransferDTO;
import es.project.tony.wallets.model.dto.WalletDTO;
import es.project.tony.wallets.repository.WalletDao;
import es.project.tony.wallets.utils.UserRolesEnum;
import es.project.tony.wallets.utils.exception.WalletException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class WalletsServiceImplTests {
    private WalletService walletService;
    private WalletDao walletDao;



    @Test
    public void getWalletsOk() {
        walletDao = mock(WalletDao.class);
        walletService = new WalletServiceImpl(walletDao);
        when(walletDao.findAllAvailable(any(Integer.class))).thenReturn(getWallets());
        List<WalletDTO> resultList = walletService.getAllWalletsAvailable(1);
        assertNotNull(resultList);
        assertEquals("Cartera de Toni", resultList.get(0).getName());
    }

    @Test
    public void getWalletsByUserIdTestOk() {
        walletDao = mock(WalletDao.class);
        walletService = new WalletServiceImpl(walletDao);
        when(walletDao.getWalletsByUserId(any(Integer.class))).thenReturn(getWallets());

        List<WalletDTO> walletDTOS = walletService.getWalletsByUserId(2);
        assertNotNull(walletDTOS);
        assertEquals(walletDTOS.get(0).getAmount(), new BigDecimal(12999));

    }

    @Test
    public void getWalletsByUserIdTestUserHasNoWallets() {
        walletDao = mock(WalletDao.class);
        walletService = new WalletServiceImpl(walletDao);
        when(walletDao.getWalletsByUserId(any(Integer.class))).thenReturn(new ArrayList<>());

        List<WalletDTO> walletDTOS = walletService.getWalletsByUserId(2);
        assertEquals(walletDTOS.size(), 0);
    }

    @Test
    public void transferMoneyTestOk() throws Exception {
        walletDao = mock(WalletDao.class);
        walletService = new WalletServiceImpl(walletDao);
        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setAmount(new BigDecimal(100));
        transferDTO.setDestinationWallet(2);
        transferDTO.setOriginWallet(1);
        when(walletDao.getOne(1)).thenReturn(getWallets().get(0));
        when(walletDao.getOne(2)).thenReturn(getWallets().get(1));

        WalletDTO walletDTO = walletService.transferMoney(transferDTO);
        assertNotNull(walletDTO);
        assertEquals(new BigDecimal(12899),walletDTO.getAmount());
    }
    @Test(expected = WalletException.class)
    public void transferMoneyWithUserRole() throws Exception {
        walletDao = mock(WalletDao.class);
        walletService = new WalletServiceImpl(walletDao);
        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setAmount(new BigDecimal(100));
        transferDTO.setDestinationWallet(1);
        transferDTO.setOriginWallet(2);
        when(walletDao.getOne(1)).thenReturn(getWallets().get(0));
        when(walletDao.getOne(2)).thenReturn(getWallets().get(1));
        WalletDTO walletDTO = walletService.transferMoney(transferDTO);
        assertNotNull(walletDTO);
        assertEquals(new BigDecimal(12899),walletDTO.getAmount());
    }

    @Test(expected = WalletException.class)
    public void transferMoneyTestOneWalletDoesntExist() throws Exception {
        walletDao = mock(WalletDao.class);
        walletService = new WalletServiceImpl(walletDao);
        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setAmount(new BigDecimal(100));
        transferDTO.setDestinationWallet(2);
        transferDTO.setOriginWallet(1);
        when(walletDao.getOne(1)).thenReturn(null);
        when(walletDao.getOne(2)).thenReturn(getWallets().get(1));
        WalletDTO walletDTO = walletService.transferMoney(transferDTO);

    }

    private List<Wallet> getWallets() {
        Wallet wallet = new Wallet();
        wallet.setAmount(new BigDecimal(12999));
        wallet.setId(1);
        wallet.setName("Cartera de Toni");
        wallet.setUser(getAdminUser());

        Wallet wallet2 = new Wallet();
        wallet2.setAmount(new BigDecimal(15000));
        wallet2.setId(2);
        wallet2.setName("Cartera de Paco");
        wallet2.setUser(getNormalUser());

        List<Wallet> wallets = new ArrayList<>();
        wallets.add(wallet);
        wallets.add(wallet2);
        return wallets;
    }
    private User getAdminUser(){
        User user = new User();
        user.setRole(UserRolesEnum.ADMIN);
        user.setName("Toni");
        return user;
    }
    private User getNormalUser(){
        User user = new User();
        user.setRole(UserRolesEnum.USER);
        user.setName("David");
        return user;
    }
}
