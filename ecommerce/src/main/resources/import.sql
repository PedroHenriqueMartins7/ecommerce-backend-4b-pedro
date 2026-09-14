INSERT INTO categoria (nome, descricao) VALUES ('Computadores', 'Computadores, notebooks e equipamentos para informática');

INSERT INTO categoria (nome, descricao) VALUES ('Tecnologia', 'Livros e materiais sobre tecnologia e desenvolvimento');

INSERT INTO categoria (nome, descricao) VALUES ('Gadgets', 'Dispositivos eletrônicos para uso pessoal e profissional');

INSERT INTO categoria (nome, descricao) VALUES ('Periféricos', 'Teclados, mouses, webcams e outros periféricos');

INSERT INTO categoria (nome, descricao) VALUES ('Smartphones', 'Celulares, acessórios e dispositivos móveis');


INSERT INTO produto (nome, descricao, preco, estoque, categoria_id) VALUES ('Clean Code', 'Guia sobre boas práticas para desenvolvimento de software', 94.90, 18, 2);

INSERT INTO produto (nome, descricao, preco, estoque, categoria_id) VALUES ('Arquitetura Limpa', 'Princípios e práticas para criação de sistemas sustentáveis', 109.90, 14, 2);

INSERT INTO produto (nome, descricao, preco, estoque, categoria_id) VALUES ('Estruturas de Dados', 'Fundamentos de estruturas de dados e algoritmos', 82.50, 22, 2);

INSERT INTO produto (nome, descricao, preco, estoque, categoria_id) VALUES ('Java na Prática', 'Material completo para desenvolvimento de aplicações Java', 119.90, 10, 2);

INSERT INTO produto (nome, descricao, preco, estoque, categoria_id) VALUES ('Engenharia de Software', 'Conceitos e técnicas para desenvolvimento de sistemas', 97.90, 26, 2);


INSERT INTO cliente (nome, email, telefone) VALUES ('Rafael Almeida', 'rafael.almeida@gmail.com', '11984561237');

INSERT INTO cliente (nome, email, telefone) VALUES ('Mariana Oliveira', 'mariana.oliveira@outlook.com', '14991234567');

INSERT INTO cliente (nome, email, telefone) VALUES ('Lucas Ferreira', 'lucas.ferreira@hotmail.com', '16987654321');

INSERT INTO cliente (nome, email, telefone) VALUES ('Amanda Souza', 'amanda.souza@gmail.com', '17992345678');

INSERT INTO cliente (nome, email, telefone) VALUES ('Bruno Martins', 'bruno.martins@outlook.com', '18981234567');


INSERT INTO pedido (data, status, valor_total, cliente_id) VALUES ('2026-09-01T10:15:00', 'PAGO', 204.80, 1);

INSERT INTO pedido (data, status, valor_total, cliente_id) VALUES ('2026-09-03T13:40:00', 'ENVIADO', 119.90, 2);

INSERT INTO pedido (data, status, valor_total, cliente_id) VALUES ('2026-09-06T15:25:00', 'AGUARDANDO_PAGAMENTO', 219.80, 3);

INSERT INTO pedido (data, status, valor_total, cliente_id) VALUES ('2026-09-09T09:50:00', 'ENTREGUE', 195.80, 4);

INSERT INTO pedido (data, status, valor_total, cliente_id) VALUES ('2026-09-11T17:30:00', 'PAGO', 247.50, 5);


INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id) VALUES (2, 94.90, 1, 1);

INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id) VALUES (1, 119.90, 2, 4);

INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id) VALUES (2, 109.90, 3, 2);

INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id) VALUES (2, 97.90, 4, 5);

INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id) VALUES (3, 82.50, 5, 3);


INSERT INTO pagamento (valor, data, status, tipo, pedido_id) VALUES (204.80, '2026-09-01T10:25:00', 'APROVADO', 'PIX', 1);

INSERT INTO pagamento (valor, data, status, tipo, pedido_id) VALUES (119.90, '2026-09-03T13:55:00', 'APROVADO', 'CARTAO_CREDITO', 2);

INSERT INTO pagamento (valor, data, status, tipo, pedido_id) VALUES (219.80, '2026-09-06T15:40:00', 'PENDENTE', 'BOLETO', 3);

INSERT INTO pagamento (valor, data, status, tipo, pedido_id) VALUES (195.80, '2026-09-09T10:05:00', 'APROVADO', 'CARTAO_DEBITO', 4);

INSERT INTO pagamento (valor, data, status, tipo, pedido_id) VALUES (247.50, '2026-09-11T17:45:00', 'APROVADO', 'PIX', 5);