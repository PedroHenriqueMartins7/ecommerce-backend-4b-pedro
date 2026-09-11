package br.edu.unifio.ecommerce.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import br.edu.unifio.ecommerce.entidades.Categoria;
import br.edu.unifio.ecommerce.entidades.Produto;

@DataJpaTest
class ProdutoRepositorioTest {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    void deveBuscarProdutoPorId() {
        Categoria categoria = new Categoria();
        categoria.setNome("Perifericos");
        categoria.setDescricao("Teclados, mouses e headsets");
        categoria = categoriaRepositorio.save(categoria);

        Produto produto = new Produto();
        produto.setNome("Teclado Mecanico");
        produto.setDescricao("Switch azul, ABNT2");
        produto.setPreco(new BigDecimal("289.90"));
        produto.setEstoque(15);
        produto.setCategoria(categoria);

        Long id = produtoRepositorio.save(produto).getId();

        Optional<Produto> encontrado = produtoRepositorio.findById(id);

        assertThat(encontrado).isPresent();
        assertThat(encontrado.get().getId()).isEqualTo(id);
        assertThat(encontrado.get().getNome()).isEqualTo("Teclado Mecanico");
        assertThat(encontrado.get().getPreco()).isEqualByComparingTo("289.90");
    }
}
