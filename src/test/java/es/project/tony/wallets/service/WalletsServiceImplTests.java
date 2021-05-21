package es.project.tony.wallets.service;


import es.project.tony.wallets.model.User;
import es.project.tony.wallets.model.Wallet;
import es.project.tony.wallets.model.dto.WalletDTO;
import es.project.tony.wallets.repository.WalletDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
    @InjectMocks WalletServiceImpl walletService;

    @Mock
    WalletDao walletDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        walletService = new WalletServiceImpl();
    }

    @Test
    public void getWalletsByUserIdTestOk(){
        List<Wallet> walletList = getWallets();
        when(walletDao.getWalletsByUserId(any(Integer.class))).thenReturn(walletList);

        List<WalletDTO> walletDTOS = walletService.getWalletsByUserId(2);
        assertNotNull(walletList);
        assertEquals(walletDTOS.get(0).getAmount(), new BigDecimal(12999));

    }

    @Test
    public void transferMoneyTestOk(){

    }

    private List<Wallet> getWallets(){
        Wallet wallet = new Wallet();
        wallet.setAmount(new BigDecimal(12999));
        wallet.setId(1);
        wallet.setName("Cartera de Toni");
        wallet.setUser(new User());

        Wallet wallet2 = new Wallet();
        wallet2.setAmount(new BigDecimal(15000));
        wallet2.setId(1);
        wallet2.setName("Cartera de Paco");
        wallet2.setUser(new User());

        List<Wallet> wallets = new ArrayList<>();
        wallets.add(wallet);
        wallets.add(wallet2);
        return wallets;
    }
}
