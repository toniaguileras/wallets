package es.project.tony.wallets.controller;

import es.project.tony.wallets.model.dto.TransferDTO;
import es.project.tony.wallets.service.WalletService;
import es.project.tony.wallets.utils.exception.WalletException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class WalletControllerTest {

    @Mock private WalletService walletService;


    @Before
    public void initMocks() throws Exception{
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAvailableUsersWalletsPerUserOk() {
        WalletController walletController = new WalletController(walletService);
        ResponseEntity responseEntity = walletController.getWallets(1);
        assertEquals("200 OK", responseEntity.getStatusCode().toString());
    }@Test
    public void getAvailableWalletsPerUsersNull() {
        WalletController walletController = new WalletController(walletService);
        ResponseEntity responseEntity = walletController.getWallets(null);
        assertEquals("200 OK", responseEntity.getStatusCode().toString());
    }
    @Test
    public void getWalletsByUserIdOk() {
        WalletController walletController = new WalletController(walletService);
        ResponseEntity responseEntity = walletController.getWalletsByUserId(1);
        assertEquals("200 OK", responseEntity.getStatusCode().toString());
    }

    @Test
    public void transferMoneyOk() throws Exception {
        WalletController walletController = new WalletController(walletService);
        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setAmount(new BigDecimal(1234));
        transferDTO.setOriginWallet(1);
        transferDTO.setDestinationWallet(2);
        ResponseEntity responseEntity = walletController.transferMoney(transferDTO);
        assertEquals("200 OK", responseEntity.getStatusCode().toString());
    }

    @Test
    public void transferMoneyWithNullWallet() throws Exception {
        WalletController walletController = new WalletController(walletService);
        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setAmount(new BigDecimal(1234));
        transferDTO.setOriginWallet(null);
        transferDTO.setDestinationWallet(2);
        ResponseEntity responseEntity = walletController.transferMoney(transferDTO);
        assertEquals("200 OK", responseEntity.getStatusCode().toString());
    }
}
