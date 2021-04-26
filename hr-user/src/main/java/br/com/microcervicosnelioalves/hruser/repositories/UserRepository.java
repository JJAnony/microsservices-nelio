package br.com.microcervicosnelioalves.hruser.repositories;

import br.com.microcervicosnelioalves.hruser.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
