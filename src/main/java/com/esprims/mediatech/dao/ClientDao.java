package com.esprims.mediatech.dao;

import com.esprims.mediatech.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<ClientEntity,Integer> {
    ClientEntity findByNom(String nom);
}
