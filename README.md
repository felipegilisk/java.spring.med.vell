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

# Endpoints:
- Recomendado o uso do [Postman](https://www.postman.com/downloads/) ou [Insomnia](https://insomnia.rest/download) para fazer as requisições.

## /medicos

### POST
```
http://localhost:8080/medicos
```
1. Corpo da requisição
```
   {
        "nome": (Obrigatório; String não vazia),
        "email": (Obrigatório; String de email válida),
        "crm": (Obrigatório; String com 4 a 6 dígitos),
        "especialidade": {
            "id": (Obrigatório; inteiro que representa o ID da especialidade),
        }
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
3. Retorno: 
```
Status 201
    {
        "id": N,
        "nome": X,
        "email": X,
        "crm": X,
        "telefone": X,
        "especialidade": {
            "id": N,
            "nome": X,
            "descricao": X,
            "status": false
        },
        "endereco": {
            "logradouro": N,
            "numero": N,
            "complemento": X,
            "cep": X,
            "bairro": X,
            "cidade": X,
            "uf": X
        }
    }
```

### GET (1)
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
Status 200
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

### GET (2)
```
http://localhost:8080/medicos/[id]
```

1. Corpo da requisição: - sem corpo de requisição -
2. Parâmetros: - sem parâmetros -
3. Exemplo de retorno:
```
Status 200
    {
        "id": N,
        "nome": X,
        "email": X,
        "crm": X,
        "telefone": X,
        "especialidade": {
            "id": N,
            "nome": X,
            "descricao": X,
            "status": false
        },
        "endereco": {
            "logradouro": N,
            "numero": N,
            "complemento": X,
            "cep": X,
            "bairro": X,
            "cidade": X,
            "uf": X
        }
    }
```

⚠️ Nota ⚠️: Nas requisições "GET" são trazidos apenas médicos cuja coluna 'status' contém o valor true (1)

### PUT
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
3. Exemplo de retorno:
```
Status 200
    {
        "id": N,
        "nome": X,
        "email": X,
        "crm": X,
        "telefone": X,
        "especialidade": {
            "id": N,
            "nome": X,
            "descricao": X,
            "status": false
        },
        "endereco": {
            "logradouro": N,
            "numero": N,
            "complemento": X,
            "cep": X,
            "bairro": X,
            "cidade": X,
            "uf": X
        }
    }
```

### DELETE
```
http://localhost:8080/medicos/{id}
```
1. Corpo da requisição: - sem corpo da requisição - 
2. Parâmetros:
- id do médico a excluir
3. Retorno: - sem retorno -
```
Status 204
```

⚠️ Nota ⚠️: A requisição DELETE realiza apenas uma exclusão lógica na tabela medicos, sendo alterada a coluna 'status' de 1 para 0

## /especialidades

### POST
```
http://localhost:8080/especialidades
```
1. Corpo da requisição
```
   {
        "nome": (Obrigatório; String não vazia),
        "descricao": (Opcional, String)
  }
```
2. Parâmetros: - sem parâmetros -
3. Retorno:
```
Status 201
    {
        "id": N,
        "nome": X,
        "descricao": X
    }
```

### GET (1)
```
http://localhost:8080/especialidades
```

1. Corpo da requisição: - sem corpo de requisição -
2. Parâmetros:
- tamanho (opcional) - Quantidade de registros do retorno. Por padrão o valor é 10.
```
http://localhost:8080/especialidades?tamanho=4
```
- pagina (opcional) - Página da listagem, a contagem é iniciada em 0
```
http://localhost:8080/especialidades?pagina=0
```
- ordem (opcional) - Campo da ordenação, sendo as opções: ["nome", "descricao"], também é possível fazer a ordem decrescente adicionando ",desc" após o campo. Por padrão a ordenação é por especialidade.
```
http://localhost:8080/especialidades?ordem=nome,desc
```
3. Exemplo de retorno:
```
Status 200
    {
        "content": [
            {
                "id": N,
                "nome": X,
                "descricao": X,
                "status": true
            },
            {
                "id": N,
                "nome": X,
                "descricao": X,
                "status": true
            },
            {
                "id": N,
                "nome": X,
                "descricao": X,
                "status": true
            },
            {
                "id": N,
                "nome": X,
                "descricao": X,
                "status": true
            }
        ],
        "pageable": {
            "pageNumber": N,
            "pageSize": N,
            "sort": {
                "empty": false,
                "sorted": true,
                "unsorted": false
            },
            "offset": 0,
            "unpaged": false,
            "paged": true
        },
        "last": false,
        "totalPages": N,
        "totalElements": N,
        "size": N,
        "number": N,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "numberOfElements": N,
        "first": true,
        "empty": false
    }
```

### GET (2)
```
http://localhost:8080/especialidades/[id]
```

1. Corpo da requisição: - sem corpo de requisição -
2. Parâmetros: - sem parâmetros -
3. Exemplo de retorno:
```
Status 200
    {
        "id": N,
        "nome": X,
        "descricao": X
    }
```

⚠️ Nota ⚠️: Nas requisições "GET" são trazidos apenas médicos cuja coluna 'status' contém o valor true (1)

### PUT
```
http://localhost:8080/especialidades
```
1. Corpo da requisição
```
    {
       "id": (Obrigatório; ID da especialidade a atualizar),
       "nome: (Opcional; String com o novo nome da especialidade),
       "descricao": (Opcional; String com a nova descrição da especialidade)
      }
    }
```
2. Parâmetros: - sem parâmetros -
3. Exemplo de retorno:
```
Status 200
    {
        "id": N,
        "nome": X,
        "descricao": X
    }
```

### DELETE
```
http://localhost:8080/especialidades/{id}
```
1. Corpo da requisição: - sem corpo da requisição -
2. Parâmetros:
- id do médico a excluir
3. Retorno: - sem retorno -
```
Status 204
```

⚠️ Nota ⚠️: A requisição DELETE realiza apenas uma exclusão lógica na tabela medicos, sendo alterada a coluna 'status' de 1 para 0

## /pacientes

### POST
```
```

### GET (1)
```
```

### GET (2)
```
```

### PUT
```
```

### DELETE
```
```

## Licença
Desenvolvido com auxílio da escola Alura e o instrutor [Rodrigo Ferreira](https://cursos.alura.com.br/user/rodrigo-ferreira)
