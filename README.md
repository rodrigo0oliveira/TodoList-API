# TodoList-API
# Descrição do projeto
Esse projeto é uma API Rest de tarefas,a genérica to-do-list, além disso, foi implementado uma relação one to many com usuários ou funcionários,por exemplo: um funcinário pode ter muitas tarefas.

# Tecnologias utilizadas
* Java 17
* Spring Web
* Spring JPA
* Banco de dados H2
* Postman para realizar requisições http

# Funcinalidades da API

A api possui as requisições http implementadas para tarefas e usuários.
* Cadastrar,excluir,editar,requisitar e atribuir uma tarefa para algum usuário ou funcionário.

# Padrão de Projeto MVC
* Foi utilizado o padrão de projeto MVC(model-view-controller) implementado dentro do framework Spring Web.
* A utilização do padrão MVC traz como benefício o isolamento das regras de negócios da lógica de apresentação, que é a interface com o usuário. Isto possibilita a existência de várias interfaces com o usuário que podem ser modificadas sem a necessidade de alterar as regras de negócios, proporcionando muito mais flexibilidade e oportunidades de reuso das classe.
* Nesse projeto estão separados por Resources(camada de configuração),Repositories(que implementam o Spring Jpa que contém as operações do banco de dados), Services(que realizam a regras de negócio) e Controllers (que realizam o controle da aplicação com as anotações e verbos http).

# Autor 
Rodrigo Lucas -> Estudante de Desenvolvimento - rodrigo.coelho@maisunifacisa.com.br
