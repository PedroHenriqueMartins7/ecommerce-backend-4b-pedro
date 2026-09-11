package br.edu.unifio.ecommerce.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import br.edu.unifio.ecommerce.entidades.Categoria;

@DataJpaTest
class CategoriaRepositorioTest {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    void deveBuscarCategoriaPorId() {
        Categoria categoria = new Categoria();
        categoria.setNome("Informatica");
        categoria.setDescricao("Computadores e perifericos");

        Short id = categoriaRepositorio.save(categoria).getId();

        Optional<Categoria> encontrada = categoriaRepositorio.findById(id);

        assertThat(encontrada).isPresent();
        assertThat(encontrada.get().getId()).isEqualTo(id);
        assertThat(encontrada.get().getNome()).isEqualTo("Informatica");
    }
}
