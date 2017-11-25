# DM107-trabalho

## JAVA
**Endpoints:**
- GET -> http://localhost:8081/trabalho_dm107/rest/apiEntrega/numeroPedido/{id} (Retorna informações da entrega)
- POST -> http://localhost:8081/trabalho_dm107/rest/apiEntrega/numeroPedido/ (Adiciona uma nova entrega)
  - Parâmetros que vão no Body:
  ```
  {
  "numeroPedido": Int,
  "idCliente": Int, 
   "nomeRecebedor": String, 
   "cpfRecebedor": String, 
   "dataEntrega": String 
  }
  ```
  
**Autenticação:**
- Basic Auth;
- Usuário: admin;
- Senha: admin;

**Media Type:**
- Media Type consumida: contentType/Json;
- Media Type produzida: contentType/Json;

**Status:**
- 200: Success
- 401: Unauthorized
- 500: Internal Server Erro

## PHP
**Endpoints:**
- GET -> http://localhost/DM107/TrabalhoDM107/src/public/entrega/numeroPedido/{id} (Retorna pedido por id)
- PUT -> http://localhost/DM107/TrabalhoDM107/src/public/entrega/{id} (Atualiza informações do pedido)
 - Parâmentros que vão no Body:
  ```
  {
   "numero_pedido": Long,
   "id_cliente": Long,
   "nome_recebedor":string,
   "cpf_recebedor": string ,
   "data_entrega": "YYYY-mm-dd"
  }
  ```
- DELETE -> http://localhost/DM107/TrabalhoDM107/src/public/entrega/delete/{id} (Deleta entrega)

**Autenticação:**
- Basic Auth;
- Usuário: admin;
- Senha: admin;

**Media Type:**
- Media Type consumida: contentType/Json;
- Media Type produzida: contentType/Json;

**Status:**
- 200: Success
- 401: Unauthorized
- 500: Internal Server Erro
