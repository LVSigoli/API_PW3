package br.edu.ifsp.prw3.api_2025_2.repository;

import br.edu.ifsp.prw3.api_2025_2.models.Conserto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
    Page<Conserto> findAllByAtivoTrue(Pageable pageable);
    List<Conserto> findAllByAtivoTrue();
}
