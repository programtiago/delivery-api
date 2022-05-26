package com.tiagodeveloper.domain.service;

import com.tiagodeveloper.domain.Client;
import com.tiagodeveloper.domain.exception.DomainException;
import com.tiagodeveloper.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatalogClientService {

    private ClientRepository clientRepository;

    public CatalogClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client get(Long clientId){
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new DomainException("Client not found"));
    }

    @Transactional
    public Client save(Client client){
        boolean emailExistent = clientRepository.findByEmail(client.getEmail())
                .stream()
                .anyMatch(clientExistent -> !clientExistent.equals(client));

        if (emailExistent){
            throw new DomainException("Já existe um cliente registado com este email.");
        }
        return clientRepository.save(client);
    }

    @Transactional
    public void delete(Long clientId){
        clientRepository.deleteById(clientId);
    }
}
