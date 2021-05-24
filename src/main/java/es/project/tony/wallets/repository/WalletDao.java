package es.project.tony.wallets.repository;

import es.project.tony.wallets.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Component
public class WalletDao {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    public WalletDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Wallet> getWalletsByUserId(Integer userId) {
        String sql = "SELECT * FROM wallet WHERE user_id = :userId";
        Query q = entityManager.createNativeQuery(sql, Wallet.class);
        q.setParameter("userId", userId);
        List<Wallet> resultList = q.getResultList();
        if (resultList != null && !resultList.isEmpty()) {
            return resultList;
        }
        return new ArrayList<>();
    }

    public Wallet getOne(Integer id) {
        return walletRepository.getOne(id);
    }

    public void saveAndFlush(Wallet wallet) {
        walletRepository.saveAndFlush(wallet);
    }

    public List<Wallet> findAllAvailable(Integer userId) {
        String sql = "SELECT * FROM wallet WHERE user_id != :userId";
        Query q = entityManager.createNativeQuery(sql,Wallet.class);
        q.setParameter("userId", userId);
        List<Wallet> resultList = q.getResultList();
        if(resultList!=null && !resultList.isEmpty()){
            return resultList;
        }
        return new ArrayList<>();
    }
}
