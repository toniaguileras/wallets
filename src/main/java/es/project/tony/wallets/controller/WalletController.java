package es.project.tony.wallets.controller;

import es.project.tony.wallets.model.dto.TransferDTO;
import es.project.tony.wallets.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/api/wallet")
@Controller
public class WalletController {

    @Autowired
    private WalletService walletService;


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<?> getWalletsByUserId(@RequestParam Integer userId) {
        return ResponseEntity.ok(walletService.getWalletsByUserId(userId));
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.PUT)
    public ResponseEntity<?> transferMoney(@RequestBody TransferDTO transferDTO) {
        return ResponseEntity.ok(walletService.transferMoney(transferDTO));
    }

}
