package com.esprims.mediatech.service;

import com.esprims.mediatech.dao.ClientDao;
import com.esprims.mediatech.dto.ClientRequestDto;
import com.esprims.mediatech.dto.ClientResponseDto;
import com.esprims.mediatech.models.ClientEntity;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("impl2")
public class ClientServiceImpl2 implements ClientService{
    private ClientDao clientDao;
    private ModelMapper modelMapper;


    public ClientServiceImpl2(ClientDao clientDao, ModelMapper modelMapper) {
        this.clientDao = clientDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {
        ClientEntity clientEntity=modelMapper.map(clientRequestDto,ClientEntity.class);
        ClientEntity saved=clientDao.save(clientEntity);
        return modelMapper.map(saved,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(Integer id) {
        ClientEntity clientEntity=clientDao.findById(id).orElseThrow(()->new RuntimeException("Client not Found"));

        return modelMapper.map(clientEntity,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findByNom(String nom) {
        ClientEntity clientEntity=clientDao.findByNom(nom);
        return modelMapper.map(clientEntity,ClientResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        clientDao.deleteById(id);
    }

    @Override
    public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) {
        ClientEntity clientEntity=clientDao.findById(id).orElseThrow(()->new RuntimeException("Client not Found"));;

            ClientEntity clientEntity1=modelMapper.map(clientRequestDto,ClientEntity.class);
            clientEntity1.setId(id);
            ClientEntity updated= clientDao.save(clientEntity1);
            return modelMapper.map(updated,ClientResponseDto.class);

    }

    @Override
    public List<ClientResponseDto> findAll() {
        return clientDao.findAll()
                .stream().map(el->modelMapper.map(el,ClientResponseDto.class)).collect(Collectors.toList());
    }
}
