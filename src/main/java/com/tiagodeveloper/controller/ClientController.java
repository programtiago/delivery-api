package com.tiagodeveloper.controller;

import com.tiagodeveloper.domain.Client;
import com.tiagodeveloper.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

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
        return clientRepository.save(client);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> update(@PathVariable Long clientId, @Valid @RequestBody Client client){
        if (!clientRepository.existsById(clientId)){
            return ResponseEntity.notFound().build();
        }

        client.setId(clientId);
        client = clientRepository.save(client);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete(Long clientId){
        if (!clientRepository.existsById(clientId)){
            return ResponseEntity.notFound().build();
        }

        clientRepository.deleteById(clientId);

        return ResponseEntity.noContent().build();
    }


}


