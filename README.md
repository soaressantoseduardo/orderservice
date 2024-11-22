# Order Service API

## Descrição

O **Order Service API** é um serviço REST projetado para o gerenciamento eficiente de pedidos, possibilitando integração com sistemas externos para a recepção e envio de pedidos processados. O serviço atua como um intermediário, garantindo que a lógica de cálculo e o processamento de dados estejam centralizados, assegurando escalabilidade e eficiência no manuseio de grandes volumes de informações.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação adotada.
- **Spring Boot**: Framework utilizado para a construção do microserviço.
- **PostgreSQL**: Banco de dados relacional para armazenamento das informações de pedidos.
- **Redis**: Usado para caching, melhorando a performance das operações.
- **Docker**: Gerencia a implantação do serviço através de containers.
- **Docker Compose**: Orquestra os serviços Docker necessários.

## Como Inicializar o Sistema com Docker Compose

### Pré-requisitos

- **Docker**: Certifique-se de ter o Docker instalado e funcionando. Veja como instalar o Docker [aqui](https://docs.docker.com/get-docker/).
- **Docker Compose**: Verifique se o Docker Compose está instalado. Acesse o guia de instalação [aqui](https://docs.docker.com/compose/install/).

### Passos para Inicialização

1. **Clonar o Repositório**

   Comece clonando o repositório do seu projeto localmente:

   `git clone https://github.com/soaressantoseduardo/orderservice.git`
   
   `cd orderservice`

2. **Configuração do Arquivo `docker-compose.yml`**

   Certifique-se de que seu arquivo `docker-compose.yml` está configurado corretamente para incluir os serviços necessários (app, PostgreSQL, Redis).

3. **Construir e Subir os Contêineres**

   Navegue até o diretório que contém o `docker-compose.yml` e execute o comando abaixo para construir e subir os contêineres todos de uma vez:

   `docker-compose up --build`

   Este comando irá:
   - Construir a imagem da aplicação;
   - Baixar e iniciar o contêiner do PostgreSQL e do Redis se não estiverem localmente disponíveis.

4. **Acessar a API**

   Com todos os serviços em execução, a API deve estar acessível em `http://localhost:8080/swagger-ui/index.html`, onde você pode verificar a documentação e testar os endpoints.

5. **Logs e Monitoramento**

   - Para visualizar os logs dos serviços em execução, use: `docker-compose logs -f`

6. **Derrubar os Contêineres**

   Após testar a aplicação, você pode parar e remover todos os contêineres com o seguinte comando: `docker-compose down`

## Contribuições

Para contribuir, relatar problemas ou sugerir melhorias, por favor, entre em contato.

## Contato

- **Nome**: Eduardo Soares Santos
- **Email**: soaressantoseduardo@gmail.com
- **Telefone/WhatsApp**: (61) 98561-0389

---

Obrigado por utilizar o Order Service API!