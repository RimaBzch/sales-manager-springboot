package com.esprims.mediatech.controllers;


import com.esprims.mediatech.dto.ClientRequestDto;
import com.esprims.mediatech.dto.ClientResponseDto;
import com.esprims.mediatech.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    @Qualifier("impl2")
    private ClientService clientService;

    public ClientController(@Qualifier("impl2") ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public List<ClientResponseDto> getClient(){
        return clientService.findAll();
    }




    @PostMapping("")
    public ClientResponseDto save(@RequestBody() ClientRequestDto clientRequestDto) {
        return clientService.save(clientRequestDto);
    }

    @GetMapping("/id/{id}")
    public ClientResponseDto findById(@PathVariable("id") Integer id) {
        return clientService.findById(id);
    }
    @GetMapping("/nom/{nom}")
    public ClientResponseDto findByNom(@PathVariable() String nom) {
        return clientService.findByNom(nom);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable() Integer id) {
        clientService.delete(id);
    }

    @PutMapping("/id/{id}")
    public ClientResponseDto update(@RequestBody() ClientRequestDto clientRequestDto,@PathVariable() Integer id) throws ChangeSetPersister.NotFoundException {
        return clientService.update(clientRequestDto, id);
    }


}
