package com.usermanagement.demo.service;

import com.usermanagement.demo.dto.UpdateUserRequest;
import com.usermanagement.demo.dto.UserRequest;
import com.usermanagement.demo.dto.UserResponse;
import com.usermanagement.demo.entity.User;
import com.usermanagement.demo.exceptions.BusinessException;
import com.usermanagement.demo.exceptions.NotFoundException;
import com.usermanagement.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserResponse create(UserRequest req) {
        if (repository.existsByEmail(req.email()))
            throw new BusinessException("Email já existe");

        User user = User.builder()
                .email(req.email())
                .password(encoder.encode(req.password()))
                .name(req.name())
                .build();

        repository.save(user);

        return new UserResponse(user.getId(), user.getEmail(), user.getName());
    }

    public UserResponse get(UUID id) {
        User u = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
        return new UserResponse(u.getId(), u.getEmail(), u.getName());
    }

    public void delete(UUID id) {
        if (!repository.existsById(id))
            throw new NotFoundException("Usuário não encontrado");
        repository.deleteById(id);
    }

    public UserResponse update(UUID id, UpdateUserRequest req) {
        User u = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        if (req.name() != null) u.setName(req.name());

        repository.save(u);
        return new UserResponse(u.getId(), u.getEmail(), u.getName());
    }

    public User getEntity(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }
}
