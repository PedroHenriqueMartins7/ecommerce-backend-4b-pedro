# ecommerce-backend-4b

Repositório referente ao backend do Projeto Integrador.

Spring Boot 4.1.0 · Java 21 · Spring Data JPA · MySQL (H2 nos testes)

## Entidades

`br.edu.unifio.ecommerce.entidades`

| Entidade | Chave | Relacionamentos |
|---|---|---|
| `Categoria` | `Short` | — |
| `Cliente` | `Long` | — |
| `Produto` | `Long` | `@ManyToOne` → `Categoria` |
| `Pedido` | `Long` | `@ManyToOne` → `Cliente` · `@OneToMany` → `ItemPedido` |
| `ItemPedido` | `Long` | `@ManyToOne` → `Pedido` e `Produto` |
| `Pagamento` | `Long` | `@OneToOne` → `Pedido` |

Enums de apoio: `StatusPedido` e `FormaPagamento`.

## Repositórios

`br.edu.unifio.ecommerce.repositorios` — todos estendem `JpaRepository`:

`CategoriaRepositorio` · `ClienteRepositorio` · `ProdutoRepositorio` ·
`PedidoRepositorio` · `ItemPedidoRepositorio` · `PagamentoRepositorio`

## Testes

Uma classe de teste por repositório, cada uma com o método de busca por ID
(`findById`), anotadas com `@DataJpaTest`:

`CategoriaRepositorioTest` · `ClienteRepositorioTest` · `ProdutoRepositorioTest` ·
`PedidoRepositorioTest` · `ItemPedidoRepositorioTest` · `PagamentoRepositorioTest`

Os testes rodam contra um banco H2 em memória (`src/test/resources/application.properties`),
então não é preciso ter o MySQL no ar para executá-los.

```bash
cd ecommerce
./mvnw test
```

## Executando a aplicação

Requer MySQL rodando com as credenciais de `src/main/resources/application.properties`.
O `.devcontainer/` sobe um MySQL pronto para uso.

```bash
cd ecommerce
./mvnw spring-boot:run
```
