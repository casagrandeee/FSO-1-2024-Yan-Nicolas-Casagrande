# NutriWeb

NutriWeb é uma plataforma moderna e intuitiva para profissionais e empreendedores no ramo de nutrição. Facilita o gerenciamento de clientes, produtos e pedidos, além de oferecer um blog para compartilhar dicas e novidades sobre nutrição.

## Funcionalidades

- **Gerenciamento de Clientes**: Cadastre, edite e exclua informações de clientes, incluindo nome, endereço, data de nascimento e cidade.
- **Gerenciamento de Produtos**: Adicione, edite e exclua produtos, com detalhes como descrição, valor, imagem e categoria.
- **Gerenciamento de Pedidos**: Crie, edite e finalize pedidos, incluindo itens, endereço de entrega e método de pagamento.
- **Blog**: Publique posts no blog, com título, conteúdo, imagem e data de publicação. Os usuários podem comentar, curtir e descurtir os posts.
- **Loja**: Exiba um catálogo de produtos para os clientes, com detalhes e opção de compra.

## Estrutura do Projeto
**Controladores da aplicação.**: src/main/java/br/univille/fsoweb20242yan/controller: 
**Entidades JPA.**: src/main/java/br/univille/fsoweb20242yan/entity: 
**Serviços da aplicação.**: src/main/java/br/univille/fsoweb20242yan/service:
**Arquivos estáticos (CSS, JS, imagens).**: src/main/resources/static: 
**Templates Thymeleaf.**: src/main/resources/templates: 

## Tecnologias Utilizadas
**Java:** Linguagem de programação principal.
**Spring Boot:** Framework para criação de aplicações Java.
**Thymeleaf:** Motor de templates para renderização de páginas HTML.
**Bootstrap:** Framework CSS para estilização das páginas.
**H2 Database:** Banco de dados em memória para desenvolvimento e testes.

## Como Executar o Projeto

**Clone o repositório:**
git clone https://github.com/casagrandeee/nutriweb.git
cd nutriweb

**Configure o banco de dados:**
O projeto está configurado para usar o H2 Database. As configurações estão no arquivo src/main/resources/application.properties.

**Execute a aplicação:**
./mvnw spring-boot:run

**Acesse a aplicação:**
Abra o navegador e acesse http://localhost:8080.

**© Aluno: Yan Nicolas Casagrande - FSO-I - 2024 NUTRIWEB**

![image](https://github.com/user-attachments/assets/93889cb7-01b0-4b74-bbf0-9a8d37c71783)
