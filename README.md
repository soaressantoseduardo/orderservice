# Order Service API

## Descrição
O **Order Service API** é um serviço REST projetado para o gerenciamento eficiente de pedidos, possibilitando integração com sistemas externos para a recepção e envio de pedidos processados. O serviço atua como um intermediário, garantindo que a lógica de cálculo e o processamento de dados estejam centralizados, assegurando escalabilidade e eficiência no manuseio de grandes volumes de informações — entre 150 mil e 200 mil pedidos por dia.

As principais responsabilidades do serviço incluem:
- Receber pedidos de um sistema externo A.
- Calcular o valor total dos produtos em cada pedido recebido.
- Expor os dados dos pedidos, juntamente com seu status, para um sistema externo B.

## Objetivo
Prover um serviço robusto que centralize a lógica de integração e processamento de pedidos, promovendo eficiência e desempenho em ambientes de alta demanda.

## Tecnologias Utilizadas
- **Java 17**: Linguagem de programação adotada.
- **Spring Boot**: Framework utilizado para a construção do microserviço.
- **PostgreSQL**: Banco de dados para armazenamento das informações de pedidos.
- **Redis** (opcional): Integrável para caching, melhorando a performance das operações.
- **Spring Security**: Implementado para garantir a proteção dos endpoints da API.
- **Springdoc OpenAPI**: Usado para documentação e visualização da API.

## Funcionalidades
- Integração com um sistema externo A para o recebimento de pedidos.
- Cálculo do valor total dos produtos para cada pedido.
- Exposição das informações dos pedidos para um sistema externo B.
- Verificação de pedidos duplicados.
- Testes de unidade e integração com cobertura de código garantida.

## Como Rodar com Docker

### Passo 1: Pré-requisitos
- **Docker**: Assegure-se de que o Docker Desktop está instalado e operacional.

### Passo 2: Configurar o Banco de Dados PostgreSQL
Se o PostgreSQL não estiver em funcionamento, você pode executá-lo em um container Docker com o seguinte comando: `docker run --name postgres-db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=order_database -p 5432:5432 -d postgres`

### Passo 3: Construir a Imagem Docker
Para construir a imagem do projeto, navegue até a raiz do seu projeto e execute: `docker build -t orderservice .`

### Passo 4: Executar o Container
Após a construção da imagem, inicie o container com o seguinte comando: `docker run --name orderservice --link postgres-db:db -p 8080:8080 orderservice`

### Passo 5: Acessar a Aplicação
Assim que o container estiver em execução, você pode acessar a aplicação em: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Informações do Autor
- **Nome**: Eduardo Soares Santos
- **Email**: soaressantoseduardo@gmail.com
- **Telefone/WhatsApp**: (61) 98561-0389

---

Para contribuir, relatar problemas ou sugerir melhorias, por favor, entre em contato através do e-mail fornecido. Obrigado por utilizar o Order Service API!