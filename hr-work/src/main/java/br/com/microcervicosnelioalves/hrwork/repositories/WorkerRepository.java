package br.com.microcervicosnelioalves.hrwork.repositories;

import br.com.microcervicosnelioalves.hrwork.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
