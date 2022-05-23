package com.tiagodeveloper.controller;

import com.tiagodeveloper.domain.Client;
import com.tiagodeveloper.domain.service.CatalogClientService;
import com.tiagodeveloper.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientRepository clientRepository;

    private CatalogClientService clientService;

    public ClientController(ClientRepository clientRepository, CatalogClientService clientService) {
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients(){
     return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> find(@PathVariable Long id){
            return clientRepository.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client add(@Valid @RequestBody Client client){
        return clientService.save(client);

    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> update(@PathVariable Long clientId, @Valid @RequestBody Client client){
        if (!clientRepository.existsById(clientId)){
            return ResponseEntity.notFound().build();
        }

        client.setId(clientId);
        client = clientService.save(client);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete(@PathVariable Long clientId){
        if (!clientRepository.existsById(clientId)){
            return ResponseEntity.notFound().build();
        }

        clientService.delete(clientId);

        return ResponseEntity.noContent().build();
    }


}


