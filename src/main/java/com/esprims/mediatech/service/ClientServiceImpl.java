package com.esprims.mediatech.service;

import com.esprims.mediatech.dto.ClientRequestDto;
import com.esprims.mediatech.dto.ClientResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("imlp1")
public class ClientServiceImpl implements ClientService {

    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {
        return null;
    }

    @Override
    public ClientResponseDto findById(Integer id) {
        return null;
    }

    @Override
    public ClientResponseDto findByNom(String nom) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) {
        return null;
    }

    @Override
    public List<ClientResponseDto> findAll() {
        return null;
    }
}
