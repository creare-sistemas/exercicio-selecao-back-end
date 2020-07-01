# exercicio-selecao-back-end
Exercício para avaliação de candidatos à estágio

## Instruções para rodar o serviço de back-end:

### Modelo de projeto com archetype MAVEN já configurado para agilizar o processo inicial de estrutura padrão.
### caso queira utilizá-lo como padrão, apenas exclua o código de exemplo, substitua pelo seu caso queira começar um novo projeto.

## Construído com as seguintes tecnologias

* [Maven] (https://maven.apache.org/) - Gerenciamento de dependências
* [Flyway] (https://flywaydb.org/) - Controle de versão do banco de dados
* [OPENJDK] (https://openjdk.java.net/install/) - Plataforma Java ™, Kit de Desenvolvimento 
* [Spring Boot] (https://spring.io/projects/spring-boot) - Estrutura para facilitar a inicialização e o desenvolvimento de novos aplicativos Spring
* [H2DB] (https://www.h2database.com/html/main.html) - Banco de banco de dados em memória relacional de código aberto para facilitar testes
* [git] (https://git-scm.com/) - Sistema de controle de versão distribuído gratuito e de código aberto 
* [Prometheus] (https://prometheus.io/) - Sistema de monitoramento e banco de dados de séries temporais
* [openapi] (https://swagger.io/specification/) - especificação de api de código aberto apoiada por um grande ecossistema de ferramentas que ajuda os desenvolvedores a projetar, criar, documentar e consumir serviços da Web RESTful.
* [I18n] (https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) - spring boot internacionalização. 

## Executando o aplicativo localmente

Existem várias maneiras de executar um aplicativo Spring Boot em sua máquina local. Uma maneira é executar o método `main` na classe` br/com/crearesistemas/frota/Application.java` do seu IDE.

- Faça o download do zip ou clone o repositório Git.
- Descompacte o arquivo zip (se você tiver baixado)
- Abra o Prompt de Comando e navegue com comando (cd) para a pasta que contém pom.xml
- Abra o Eclipse 
   - Arquivo -> Importar -> Projeto Maven existente -> Navegue até a pasta em que você descompactou o zip
   - Selecione o projeto
- Escolha o arquivo do aplicativo de inicialização do Spring (pesquise @SpringBootApplication)
- Clique com o botão direito do mouse no arquivo e execute como aplicativo Java

### Como alternativa, você pode usar o [plugin Spring Boot Maven] (https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) da seguinte forma:

`` shell
mvn spring-boot:run
``


### Springboot Actuator

Para monitorar e gerenciar o aplicativo:

| URL | Método
| ---------- | -------------- |
| `http://localhost:8080` | GET |
| `http://localhost:8080/actuator` | GET |
| `http://localhost:8080/actuator/health` | GET |
| `http://localhost:8080/actuator/info` | GET |
| `http://localhost: 8080/actuator/prometheus` | GET |
| `http://localhost:8080/actuator/httptrace` | GET |

### URLs

|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:8080/frota/api/v1/vehicles` | POST | |
|`http://localhost:8080/frota/api/v1/vehicles` | GET | |
|`http://localhost:8080/frota/api/v1/vehicles/{id}` | GET | |
|`http://localhost:8080/frota/api/v1/vehicles/{id}` | PUT | |
|`http://localhost:8080/frota/api/v1/vehicles/{id}` | DELETE | |


## Documentação

* [Coleção Postman] (https://github.com/creare-sistemas/docs/postman_collection.json) - offline
* [Swagger/openapi] (https://github.com/creare-sistemas/docs) - Documentação openapi

## Arquivos e diretórios

O projeto possui a estrutura de diretórios abaixo.

```
.
├── Spring Elements
├── src
│   └── main
│       └── java
│           ├── br.com.crearesistemas.frota.config
│           ├── br.com.crearesistemas.frota.controller
│           ├── br.com.crearesistemas.frota.exception
│           ├── br.com.crearesistemas.frota.entity
│           ├── br.com.crearesistemas.frota.util
│           ├── br.com.crearesistemas.frota.repository
│           └── br.com.crearesistemas.frota.service
├── src
│   └── main
│       └── resources
│           └── db
│           │   └── migration
│           │       └── V1__init_create_tables.sql
│           ├── application.properties
│           └── banner.txt
│           
├── src
│   └── test
│       └── java
├── JRE System Library
├── Maven Dependencies
├── target
│   └──exercicio-selecao-0.0.1-SNAPSHOT.jar
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## packages

- `models` - classes das entidades de domínio do projeto;
- `repositories` - classes para comunicar com o banco de dados;
- `services` - classes para as regras de negócio;
- `controllers` - classes dos endpoints da API;

- `resources/` - Contém todos os recursos estáticos da API.
- `resources/db/migration` - Contém os scripts de migração de banco de dados para o flyway.
- `resources/application.properties` - Contém as propriedades da aplicação. O Spring lê as properties definidas neste arquivo para configurar a aplicação.

- `test/` - Contém os unit and integration tests.

- `pom.xml` - Contém todas as declarações de dependências do projeto gerenciadas pelo Maven.
 
