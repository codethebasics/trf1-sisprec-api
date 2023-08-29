package br.jus.trf1.trf1sisprecapi.system.service;

import br.jus.trf1.trf1sisprecapi.system.model.User;
import br.jus.trf1.trf1sisprecapi.system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(Long id) {
        return this.userRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
