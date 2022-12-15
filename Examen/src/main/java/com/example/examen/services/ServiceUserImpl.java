package com.example.examen.services;

import com.example.examen.entities.Project;
import com.example.examen.entities.User;
import com.example.examen.repository.ProjectRepository;
import com.example.examen.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceUserImpl implements IServiceUser{
UserRepository userRepository;
    @Override
    public User addUser(User e) {
            return userRepository.save(e);
    }
}
