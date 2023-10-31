package com.project.services;

import com.project.beans.Imovel;
import com.project.repository.ImobiliariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImobiliariaServiceImp implements ImobiliariaService{

    @Autowired
    public ImobiliariaRepository imobiliariaRepository;

    public List<Imovel> getImoveis(){
        try {
            return imobiliariaRepository.getImoveis();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
