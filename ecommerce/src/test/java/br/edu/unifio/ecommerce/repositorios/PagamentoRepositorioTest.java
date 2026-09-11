package br.edu.unifio.ecommerce.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import br.edu.unifio.ecommerce.entidades.Cliente;
import br.edu.unifio.ecommerce.entidades.FormaPagamento;
import br.edu.unifio.ecommerce.entidades.Pagamento;
import br.edu.unifio.ecommerce.entidades.Pedido;
import br.edu.unifio.ecommerce.entidades.StatusPedido;

@DataJpaTest
class PagamentoRepositorioTest {

    @Autowired
    private PagamentoRepositorio pagamentoRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    void deveBuscarPagamentoPorId() {
        Cliente cliente = new Cliente();
        cliente.setNome("Carlos Dias");
        cliente.setEmail("carlos.dias@exemplo.com");
        cliente.setCpf("55566677788");
        cliente = clienteRepositorio.save(cliente);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDateTime.of(2026, 9, 10, 16, 45));
        pedido.setStatus(StatusPedido.PAGO);
        pedido.setValorTotal(new BigDecimal("450.00"));
        pedido = pedidoRepositorio.save(pedido);

        Pagamento pagamento = new Pagamento();
        pagamento.setPedido(pedido);
        pagamento.setForma(FormaPagamento.PIX);
        pagamento.setValor(new BigDecimal("450.00"));
        pagamento.setDataPagamento(LocalDateTime.of(2026, 9, 10, 16, 47));

        Long id = pagamentoRepositorio.save(pagamento).getId();

        Optional<Pagamento> encontrado = pagamentoRepositorio.findById(id);

        assertThat(encontrado).isPresent();
        assertThat(encontrado.get().getId()).isEqualTo(id);
        assertThat(encontrado.get().getForma()).isEqualTo(FormaPagamento.PIX);
        assertThat(encontrado.get().getValor()).isEqualByComparingTo("450.00");
    }
}
