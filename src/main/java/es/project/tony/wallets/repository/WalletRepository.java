package es.project.tony.wallets.repository;

import es.project.tony.wallets.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
}
