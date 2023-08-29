package br.jus.trf1.trf1sisprecapi.system.service;

import br.jus.trf1.trf1sisprecapi.system.model.Authorities;
import br.jus.trf1.trf1sisprecapi.system.repository.AuthoritiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthoritiesService {

    private final AuthoritiesRepository authoritiesRepository;

    public AuthoritiesService(AuthoritiesRepository authoritiesRepository) {
        this.authoritiesRepository = authoritiesRepository;
    }

    public Authorities save(Authorities authorities) {
        return this.authoritiesRepository.save(authorities);
    }

    public Authorities findById(Long id) {
        return this.authoritiesRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Authorities> findAll() {
        return this.authoritiesRepository.findAll();
    }
}