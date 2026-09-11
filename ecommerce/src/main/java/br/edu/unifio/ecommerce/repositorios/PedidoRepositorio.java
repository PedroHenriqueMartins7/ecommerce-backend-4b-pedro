package br.edu.unifio.ecommerce.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unifio.ecommerce.entidades.Pedido;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
}
