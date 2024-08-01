package org.transferservice.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.transferservice.model.FavoriteRecipient;
import org.transferservice.repository.FavoriteRecipientRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FavoriteRecipientService {

    private FavoriteRecipientRepository favoriteRecipientRepository;


    @Transactional
    public FavoriteRecipient addFavoriteRecipient(FavoriteRecipient favoriteRecipient) {
        return favoriteRecipientRepository.save(favoriteRecipient);
    }

    public List<FavoriteRecipient> getFavoriteRecipientsByCustomerId(Long customerId) {
        return favoriteRecipientRepository.findByCustomerId(customerId);
    }

    public Optional<FavoriteRecipient> getFavoriteRecipientByCustomerIdAndAccountNumber(Long customerId, String accountNumber) {
        return favoriteRecipientRepository.findByCustomerIdAndRecipientAccountNumber(customerId, accountNumber);
    }

    @Transactional
    public void removeFavoriteRecipient(Long id) {
        favoriteRecipientRepository.deleteById(id);
    }



}
