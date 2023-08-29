package br.jus.trf1.trf1sisprecapi.system.repository;

import br.jus.trf1.trf1sisprecapi.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
