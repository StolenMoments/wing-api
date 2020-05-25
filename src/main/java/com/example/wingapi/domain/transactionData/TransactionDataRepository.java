package com.example.wingapi.domain.transactionData;

import com.example.wingapi.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TransactionDataRepository extends JpaRepository<TransactionData, Long> {
    Set<TransactionData> findByArtist_ArtistId(Long artistId);
    Set<TransactionData> findByUser(User user);
}
