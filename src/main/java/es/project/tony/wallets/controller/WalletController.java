package es.project.tony.wallets.controller;

import es.project.tony.wallets.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/wallet")
public class WalletController {

    @Autowired private WalletService walletService;
    @GetMapping
    public ResponseEntity<?> getWalletsByUserId(@RequestParam Integer userId){
        return ResponseEntity.ok(walletService.getWalletsByUserId(userId));
    }


}
