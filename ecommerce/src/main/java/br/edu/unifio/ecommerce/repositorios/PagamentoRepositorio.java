package br.edu.unifio.ecommerce.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unifio.ecommerce.entidades.Pagamento;

@Repository
public interface PagamentoRepositorio extends JpaRepository<Pagamento, Long> {
}
