# java.spring.med.vell

API para CRUD no banco de dados.

Feito com fins acadêmicos com uso das ferramentas:
- IDE Intellij
- Java
- Rest API
- Springboot
- MVC
- MySQL
- Flyway
- lombok

Verificar se o serviço do MySQL está em execução
>![image](https://github.com/felipegilisk/java.spring.med.vell/assets/95372771/828d630d-4183-4af7-86fe-69108380f02e)

- Endpoints:
1. POST: http://localhost:8080/medicos
```
   {
    "nome": (Obrigatório; String não vazia),
    "email": (Obrigatório; String de email válida),
    "crm": (Obrigatório; String com 4 a 6 dígitos),
    "especialidade": (Obrigatório; String com apenas um dos valores: ["ORTOPEDIA", "CARDIOLOGIA", "GINECOLOGIA", "DERMATOLOGIA"] ),
    "telefone": (Obrigatório; String no formato "(99) [9]9999-9999" - onde [9] é opcional),
    "endereco": {
        "logradouro": (Obrigatório; String não vazia),
        "numero": (Opcional, String),
        "complemento": (Opcional; String)
        "bairro": (Obrigatório; String não vazia),
        "cep": (Obrigatório; String no formato 99999-999),
        "cidade": (Obrigatório; String não vazia),
        "uf": (Obrigatório; String com 2 caracteres)
  }
```
2. GET: http://localhost:8080/medicos
   2.1 parâmetros:
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
   2.2 exemplo de retorno:
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
     
