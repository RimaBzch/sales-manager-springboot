package com.esprims.mediatech.service;

import com.esprims.mediatech.dto.ClientRequestDto;
import com.esprims.mediatech.dto.ClientResponseDto;
//import javassist.NotFoundException;
//import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import java.util.List;

public interface ClientService {

   ClientResponseDto save(ClientRequestDto clientRequestDto);

    ClientResponseDto findById(Integer id);

    ClientResponseDto findByNom(String nom);

    void delete(Integer id);

    ClientResponseDto update(ClientRequestDto clientRequestDto,Integer id) throws NotFoundException;

    List<ClientResponseDto> findAll();



}
