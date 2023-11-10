# java.spring.med.vell

API com fins acadêmicos para CRUD no banco de dados.

Feito com:
- [IDE Intellij](https://www.jetbrains.com/pt-br/idea/)
- [Sprint Initializr](https://start.spring.io/)
- [Java 17](https://www.oracle.com/java)
- Rest API
- [Spring Boot 3](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)
- MVC
- [MySQL](https://www.mysql.com/)
- [Hibernate](https://hibernate.org/)
- [Flyway](https://flywaydb.org/)
- [Lombok](https://projectlombok.org/)

## Para executar:
- [Instalação do Java 17](https://www.oracle.com/br/java/technologies/downloads/#java17)
- MySQL 8.0 executado em serviço windows (abaixo) ou docker
>![image](https://github.com/felipegilisk/java.spring.med.vell/assets/95372771/828d630d-4183-4af7-86fe-69108380f02e)

## Endpoints:
- Recomendado o uso do [Postman](https://www.postman.com/downloads/) ou [Insomnia](https://insomnia.rest/download) para fazer as requisições.

### POST (medicos)
```
http://localhost:8080/medicos
```
1. Corpo da requisição
```
   {
    "nome": (Obrigatório; String não vazia),
    "email": (Obrigatório; String de email válida),
    "crm": (Obrigatório; String com 4 a 6 dígitos),
    "especialidade": (Obrigatório; String com apenas um dos valores: ["ORTOPEDIA", "CARDIOLOGIA", "GINECOLOGIA", "DERMATOLOGIA"] ),
    "telefone": (Obrigatório; String no formato "(99) [9]9999-9999" - onde [9] é opcional),
    "endereco": (Obrigatório) {
        "logradouro": (Obrigatório; String não vazia),
        "numero": (Opcional, String),
        "complemento": (Opcional; String)
        "bairro": (Obrigatório; String não vazia),
        "cep": (Obrigatório; String no formato 99999-999),
        "cidade": (Obrigatório; String não vazia),
        "uf": (Obrigatório; String com 2 caracteres)
  }
```
2. Parâmetros: - sem parâmetros -
3. Retorno: - sem retorno -

### GET (medicos)
```
http://localhost:8080/medicos
```

1. Corpo da requisição: - sem corpo de requisição -
2. Parâmetros:
- tamanho (opcional) - Quantidade de registros do retorno. Por padrão o valor é 10.
```
http://localhost:8080/medicos?tamanho=3
```
- pagina (opcional) - Página da listagem, a contagem é iniciada em 0
```
http://localhost:8080/medicos?pagina=1
```
- ordem (opcional) - Campo da ordenação, sendo as opções: ["nome", "email", "crm", "especialidade"], também é possível fazer a ordem decrescente adicionando ",desc" após o campo. Por padrão a ordenação é por especialidade.
```
http://localhost:8080/medicos?ordem=nome,desc
```
3. Exemplo de retorno:
```
  {
    "content": [
        {
            "nome": "xxxx",
            "email": "xxxx@voll.med",
            "crm": "xxxx",
            "especialidade": "xxxx"
        },
        {
            "nome": "yyyy",
            "email": "yyyy@voll.med",
            "crm": "yyyy",
            "especialidade": "yyyy"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 20,
        "sort": {
            "empty": true,
            "unsorted": true,
            "sorted": false
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalElements": N,
    "totalPages": N,
    "size": 20,
    "number": 0,
    "sort": {
        "empty": true,
        "unsorted": true,
        "sorted": false
    },
    "numberOfElements": N,
    "first": true,
    "empty": false
  }
```

⚠️ Nota ⚠️: São trazidos apenas médicos cuja coluna 'status' contém o valor true (1)

### PUT (medicos)
```
http://localhost:8080/medicos
```
1. Corpo da requisição
```
{
   "id": (Obrigatório; ID do médico a atualizar),
   "nome: (Opcional; String com o novo nome do médico),
   "telefone": (Opcional; String no formato "(99) [9]9999-9999" - onde [9] é opcional),
   "endereco": (Opcional) {
        "logradouro": (Opcional; String),
        "numero": (Opcional, String),
        "complemento": (Opcional; String)
        "bairro": (Opcional; String),
        "cep": (Opcional; String no formato "99999-999"),
        "cidade": (Opcional; String),
        "uf": (Opcional; String com 2 caracteres)
  }
}
```
2. Parâmetros: - sem parâmetros -
3. Retorno: - sem retorno -

### DELETE (medicos)
```
http://localhost:8080/medicos/{id}
```
1. Corpo da requisição: - sem corpo da requisição - 
2. Parâmetros:
- id do médico a excluir
3. Retorno: - sem retorno -

⚠️ Nota ⚠️: A requisição DELETE realiza apenas uma exclusão lógica na tabela medicos, sendo alterada a coluna 'status' de 1 para 0

## Licença
Desenvolvido com auxílio da escola Alura e o instrutor [Rodrigo Ferreira](https://cursos.alura.com.br/user/rodrigo-ferreira)
