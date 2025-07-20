# 🗓️ Agendador de Tarefas

Este é um microserviço em Spring Boot responsável por gerenciar tarefas de usuários.

---

## 🔗 Integração

Este projeto depende do projeto **usuario**. A comunicação é feita via **FeignClient**, e o token JWT gerado na autenticação do usuário é utilizado para validar e vincular a tarefa corretamente.

---

## 🧩 Tecnologias Utilizadas

- **Spring Boot Starter Web** – API REST  
- **Spring Boot Starter Security** – Autenticação com JWT  
- **Spring Boot Starter Data MongoDB** – Persistência NoSQL  
- **Spring Cloud OpenFeign** – Comunicação entre microserviços  
- **MapStruct** – Conversão entre DTOs e entidades  
- **Lombok** – Redução de código repetitivo  
- **JJWT** – Manipulação e validação de tokens JWT

---

## 🔐 Segurança

- A autenticação é baseada em **JWT (JSON Web Token)**.
- O token deve ser enviado em **todas as requisições protegidas** usando o header HTTP:

```http
Authorization: Bearer SEU_TOKEN_JWT
```

- O sistema valida o token, extrai o e-mail do usuário e, com isso, permite o acesso apenas aos dados do próprio usuário.
- Não é possível criar/editar/listar tarefas sem um token válido.

---

## ✅ Funcionalidades

- 🔄 Criar uma nova tarefa
- ✏️ Atualizar tarefas existentes
- 🗑️ Deletar tarefas
- 📋 Listar tarefas por usuário
- ⏰ Controlar status de notificação de cada tarefa

---

## 📚 Endpoints da API

| Método | URI               | Descrição                          | Parâmetros                            | Headers                                                  | Autenticado      |
|--------|-------------------|------------------------------------|---------------------------------------|------------------                                        |------------------|
| POST   | `/tarefas`        | Cria uma nova tarefa               |                                       | Token JWT passado pelo Uusuario                          | ✅               |
| GET    | `/tarefas/periodo`| Buscar tarefas por períodos        | DATA INICIAL & DATA FINAL             | Token JWT passado pelo Uusuario                          | ✅               |
| GET    | `/tarefas`        | Lista todas as tarefas do usuário  |                                       | Token JWT passado pelo Uusuario                          | ✅               |
| PATCH  | `/tarefas`        | Altera o status de Notificação     | ID & STATUS                           | Token JWT passado pelo Uusuario                          | ✅               |
| PUT    | `/tarefas`        | Atualiza dados da tarefa existente | ID                                    | Token JWT passado pelo Uusuario                          | ✅               |
| DELETE | `/tarefas`        | Deleta uma tarefa                  | ID                                    | Token JWT passado pelo Uusuario                          | ✅               |

> ⚠️ Todas as rotas exigem envio de token JWT no cabeçalho Authorization.

---
## 🧑‍💻 Autor

Feito por **Kaio Cesar aka Kadoo The Developer** com muito café e código!
