# java.spring.med.vell

Feito com 
- IDE Intellij
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
    "nome": (String não vazia, obrigatório),
    "email": (String de email válida, obrigatório),
    "crm": (String com 4 a 6 dígitos, obrigatório),
    "especialidade": (String com apenas um dos valores: ["ORTOPEDIA", "CARDIOLOGIA", "GINECOLOGIA", "DERMATOLOGIA"], obrigatório),
    "telefone": (String no formato "(99) [9]9999-9999" - onde [9] é opcional, obrigatório),
    "endereco": {
        "logradouro": (String não vazia, obrigatório),
        "numero": (String, opcional),
        "complemento": (String, opcional)
        "bairro": (String não vazia, obrigatório),
        "cep": (String no formato 99999-999, obrigatório),
        "cidade": (String não vazia, obrigatório),
        "uf": (String não vazia, obrigatório)
  }
```
2. GET: http://localhost:8080/medicos
   2.1 parâmetros:
   - size (opcional) - quantidade de registros do retorno, por padrão o valor é 20
   - page (opcional) - página da listagem, a contagem é iniciada em 0
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
     
