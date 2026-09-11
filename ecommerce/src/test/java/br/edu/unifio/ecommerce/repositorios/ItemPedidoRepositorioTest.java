package br.edu.unifio.ecommerce.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import br.edu.unifio.ecommerce.entidades.Categoria;
import br.edu.unifio.ecommerce.entidades.Cliente;
import br.edu.unifio.ecommerce.entidades.ItemPedido;
import br.edu.unifio.ecommerce.entidades.Pedido;
import br.edu.unifio.ecommerce.entidades.Produto;
import br.edu.unifio.ecommerce.entidades.StatusPedido;

@DataJpaTest
class ItemPedidoRepositorioTest {

    @Autowired
    private ItemPedidoRepositorio itemPedidoRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    void deveBuscarItemPedidoPorId() {
        Cliente cliente = new Cliente();
        cliente.setNome("Ana Lima");
        cliente.setEmail("ana.lima@exemplo.com");
        cliente.setCpf("11122233344");
        cliente = clienteRepositorio.save(cliente);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDateTime.of(2026, 9, 10, 15, 0));
        pedido.setStatus(StatusPedido.PAGO);
        pedido.setValorTotal(new BigDecimal("199.90"));
        pedido = pedidoRepositorio.save(pedido);

        Categoria categoria = new Categoria();
        categoria.setNome("Livros");
        categoria = categoriaRepositorio.save(categoria);

        Produto produto = new Produto();
        produto.setNome("Clean Code");
        produto.setPreco(new BigDecimal("99.95"));
        produto.setEstoque(8);
        produto.setCategoria(categoria);
        produto = produtoRepositorio.save(produto);

        ItemPedido item = new ItemPedido();
        item.setPedido(pedido);
        item.setProduto(produto);
        item.setQuantidade(2);
        item.setPrecoUnitario(new BigDecimal("99.95"));

        Long id = itemPedidoRepositorio.save(item).getId();

        Optional<ItemPedido> encontrado = itemPedidoRepositorio.findById(id);

        assertThat(encontrado).isPresent();
        assertThat(encontrado.get().getId()).isEqualTo(id);
        assertThat(encontrado.get().getQuantidade()).isEqualTo(2);
        assertThat(encontrado.get().getProduto().getNome()).isEqualTo("Clean Code");
    }
}
