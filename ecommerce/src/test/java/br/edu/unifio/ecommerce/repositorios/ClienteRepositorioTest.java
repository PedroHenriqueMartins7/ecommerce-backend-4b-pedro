package br.edu.unifio.ecommerce.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import br.edu.unifio.ecommerce.entidades.Cliente;

@DataJpaTest
class ClienteRepositorioTest {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    void deveBuscarClientePorId() {
        Cliente cliente = new Cliente();
        cliente.setNome("Maria Souza");
        cliente.setEmail("maria.souza@exemplo.com");
        cliente.setCpf("12345678901");
        cliente.setTelefone("14999990000");

        Long id = clienteRepositorio.save(cliente).getId();

        Optional<Cliente> encontrado = clienteRepositorio.findById(id);

        assertThat(encontrado).isPresent();
        assertThat(encontrado.get().getId()).isEqualTo(id);
        assertThat(encontrado.get().getEmail()).isEqualTo("maria.souza@exemplo.com");
    }
}
