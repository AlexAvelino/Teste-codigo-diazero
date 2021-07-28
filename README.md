# Teste codigo Diazero

Teste de código proposto pela empresa Diazero Security para registro de incidentes.

# Começando

Para executar o projeto, será necessário instalar os seguintes programas:

-  [Java JDK: Necessário para executar os projetos Java](https://www.oracle.com/java/technologies/javase-downloads.html)
-  [Eclipse: para desenvolvimento do projeto](https://www.eclipse.org/downloads/packages/release/oxygen/3a/eclipse-ide-java-ee-developers)
-  [MySQL: Onde será gerado o banco de dados do projeto](https://www.mysql.com/)
-  [Postman: Para se fazer as requisições e passar as rotas](https://www.postman.com/)*

## Iniciando o Projeto

A aplicação foi feita em Java utilizando framework Spring Boot para a criação de uma API REST com conexão com o banco de dados Mysql. É utilizado o aplicativo Postman para realizar as postagens e testar a aplicação.

##  Dependencias do SpringBoot

Primeiramente foi criado um novo projeto Spring, com as seguintes dependências

-  MySQL Driver
-  Spring Web
-  Spring Boot DevTools
-  Validation
-  Spring Data JPA
- Spring Security
- Commons Codec

Em seguida foi criado o application.properties, para definir a conexão com o banco de dados.

## Rodando a Aplicação

## Camadas

### Model

Logo após veio a criação das camadas, começando pela model, onde se foi instanciado todos os atributos da tabela no banco de dados.

### Repository

Na repository foi criado um repositório que é responsável pela comunicação com a base de dados, é ela que irá realizar as consultas.
Além das consultas padrão foram criados alguns métodos especiais de consulta.

### Service

Já na service é onde ficam as regras de negócio do código.

### Security
Na security é a camada responsável pela segurança da aplicação.

### Controller

E na controller é onde é feito o controle dos endpoints e é disponibilizado os recursos para o client.

###  Rodando a aplicação

Deverá ser dado um run Java Application na aplicação que irá rodar localmente na porta 8080.


#  Requisições no Postman

Antes de qualquer coisa, deverá ser cadastrado um novo usuário e senha, já que a aplicação possui uma camada de segurança, nesse caso entraremos na rota ("users/register") para passar o "user" e o "password".

Logo após na rota ("/users/login") será passado o "user" e "password" novamente para pegar o token que será colocado na cabeça da requisição para que sejam liberadas as outras rotas.

Na rota ("/incidents")  através do método Post será possivel registrar um novo incidente com nome e descrição, ao fazer isso no campo createdAt ficará registrado a data do registro.

### Update e Close
Nas rotas ("/update") com o método put poderão  ser feitas alterações nos registros anteriores e o campo "updateAt" guardará a data da útima alteração. Já na rota de ("/close/id") poderá ser passado o id de um incidente para fechá-lo, impedindo futuras alterações naquela requisição e salvando a data de fechamento no campo "closedAt".

### Requisições
Com o método get será possivel visualizar todos os incidentes cadastrados com as datas de criação de atualização e de fechamento. Também é possivel fazer consultas personalizadas por id, por nome e por descrição.
