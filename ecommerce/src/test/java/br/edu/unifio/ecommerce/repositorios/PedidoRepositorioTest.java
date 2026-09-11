package br.edu.unifio.ecommerce.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import br.edu.unifio.ecommerce.entidades.Cliente;
import br.edu.unifio.ecommerce.entidades.Pedido;
import br.edu.unifio.ecommerce.entidades.StatusPedido;

@DataJpaTest
class PedidoRepositorioTest {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    void deveBuscarPedidoPorId() {
        Cliente cliente = new Cliente();
        cliente.setNome("Joao Pereira");
        cliente.setEmail("joao.pereira@exemplo.com");
        cliente.setCpf("98765432100");
        cliente.setTelefone("14988887777");
        cliente = clienteRepositorio.save(cliente);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDateTime.of(2026, 9, 10, 14, 30));
        pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
        pedido.setValorTotal(new BigDecimal("579.80"));

        Long id = pedidoRepositorio.save(pedido).getId();

        Optional<Pedido> encontrado = pedidoRepositorio.findById(id);

        assertThat(encontrado).isPresent();
        assertThat(encontrado.get().getId()).isEqualTo(id);
        assertThat(encontrado.get().getStatus()).isEqualTo(StatusPedido.AGUARDANDO_PAGAMENTO);
        assertThat(encontrado.get().getCliente().getNome()).isEqualTo("Joao Pereira");
    }
}
