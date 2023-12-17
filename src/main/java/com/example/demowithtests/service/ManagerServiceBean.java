package com.example.demowithtests.service;

import com.example.demowithtests.domain.Manager;
import com.example.demowithtests.repository.ManagerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@AllArgsConstructor
@Service
public class ManagerServiceBean implements ManagerService {

    private final ManagerRepository managerRepository;


    @Override
    public List<Manager> getAll() {
        return managerRepository.findAll();
    }
}
