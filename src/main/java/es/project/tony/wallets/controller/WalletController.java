package es.project.tony.wallets.controller;

import es.project.tony.wallets.model.dto.TransferDTO;
import es.project.tony.wallets.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/api/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @RequestMapping(value = "/available/user", method = RequestMethod.GET)
    public ResponseEntity<?> getWallets(@RequestParam Integer userId) {
        return ResponseEntity.ok(walletService.getAllWalletsAvailable(userId));
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> getWalletsByUserId(@RequestParam Integer userId) {
        return ResponseEntity.ok(walletService.getWalletsByUserId(userId));
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public ResponseEntity<?> transferMoney(@RequestBody TransferDTO transferDTO) throws Exception {
        return ResponseEntity.ok(walletService.transferMoney(transferDTO));
    }

}
