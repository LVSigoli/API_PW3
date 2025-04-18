# 🚗 API de Consertos de Veículos — IFSP PW3

Esta API permite o cadastro, consulta, atualização e exclusão lógica de **consertos de veículos**, incluindo dados do veículo e do mecânico responsável.

---

## 🛠️ Endpoints

---

### 📌 POST `/consertos`

Cria um novo conserto.

- **Request body (JSON):**
```json
{
  "dataEntrada": "10/04/2024",
  "dataSaida": "15/04/2024",
  "ativo": true,
  "mecanico": {
    "nome": "João Mecânico",
    "anosExperiencia": 5
  },
  "veiculo": {
    "marca": "Volkswagen",
    "modelo": "Gol",
    "ano": "2010",
    "cor": "Prata",
    "placa": "ABC1234"
  }
}
```

- **Response:**
  - `201 Created`
  - Header: `Location: /consertos/{id}`

---

### 📌 GET `/consertos/todos`

Retorna todos os consertos **ativos**, com paginação.

- **Query params:**
  - `page` (ex: `0`)
  - `size` (ex: `10`)

- **Response:**
  - `200 OK`
  - Corpo: JSON paginado de consertos

---

### 📌 GET `/consertos/resumo`

Retorna apenas os dados principais dos consertos ativos:

- **Campos retornados:**
  - `id`
  - `dataEntrada`
  - `dataSaida`
  - `nomeMecanico`
  - `marca`
  - `modelo`

- **Response:**
  - `200 OK`
```json
[
  {
    "id": 1,
    "dataEntrada": "10/04/2024",
    "dataSaida": "15/04/2024",
    "nomeMecanico": "João Mecânico",
    "marca": "Volkswagen",
    "modelo": "Gol"
  }
]
```

---

### 📌 GET `/consertos/{id}`

Retorna um conserto pelo ID.

- **Response:**
  - `200 OK` → Conserto encontrado
  - `404 Not Found` → Se não existir
```json
"Conserto não encontrado"
```

---

### 📌 PUT `/consertos/{id}`

Atualiza **data de saída**, **nome** e **experiência do mecânico**.

- **Request body (JSON):**
```json
{
  "dataSaida": "20/04/2024",
  "nomeMecanico": "Carlos Lima",
  "anosExperiencia": 7
}
```

- **Response:**
  - `200 OK` → Com dados atualizados
  - `404 Not Found` → Se o ID não existir
  - `400 Bad Request` → Se o JSON estiver inválido

---

### 📌 DELETE `/consertos/{id}`

Faz a exclusão lógica de um conserto (`ativo = false`).

- **Response:**
  - `204 No Content` → Exclusão realizada
  - `404 Not Found` → Se o conserto não existir

---

## ✅ Validações

- `dataEntrada` e `dataSaida`: formato `dd/MM/yyyy`
- `nome`, `marca`, `modelo`: obrigatórios
- `ano`: deve conter 4 dígitos (ex: `"2012"`)

---

## ⚙️ Banco de Dados

- Usando **H2 em memória**
- Flyway usado para controle de migrations

---

## 👨‍🔧 Aluno

- Desenvolvido por: **Lucas Vinicius SIgoli**
- RA: **3020428**
- Projeto da disciplina: **Programação Web 3 — IFSP**