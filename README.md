# Controle_De_EstoqueSPRPREV

## 1. Visão geral

O **Controle de Estoque** é uma aplicação desenvolvida em Java para gerenciamento básico de produtos. O sistema permite cadastrar produtos, consultar o estoque, alterar informações, retirar quantidades e excluir produtos.

A aplicação possui interface via terminal e utiliza uma arquitetura baseada em **MVC (Model-View-Controller)**, separando a interface do usuário, as regras de negócio e os dados.

---

## 2. Requisitos

### Software

* Java JDK 8 ou superior

### Hardware

Não há requisitos específicos de hardware. O sistema possui baixo consumo de recursos e pode ser executado em computadores convencionais.

---

## 3. Estrutura do projeto

```text
src/
├── controller/
│   ├── ControleDeEstoque.java
│   └── TesteControle.java
│
├── model/
│   └── Produto.java
│
└── view/
    ├── Main.java
    └── MenuEstoque.java
```

### Controller

Responsável pelas operações e regras relacionadas ao estoque.

**`ControleDeEstoque.java`**

Gerencia a lista de produtos e executa as operações de inclusão, busca, alteração, retirada e exclusão.

---

### Model

**`Produto.java`**

Representa um produto armazenado no sistema.

Possui os seguintes atributos:

| Atributo     | Tipo   | Descrição             |
| ------------ | ------ | --------------------- |
| `nome`       | String | Nome do produto       |
| `quantidade` | int    | Quantidade disponível |

---

### View

Responsável pela interação com o usuário.

**`MenuEstoque.java`**

Exibe o menu, recebe os dados digitados, realiza validações de entrada e solicita ao Controller a execução das operações.

**`Main.java`**

Ponto de entrada da aplicação. Responsável por iniciar a interface do sistema.

---

## 4. Funcionalidades

### Adicionar item

Cadastra um novo produto no estoque informando seu nome e quantidade.

O nome do produto passa por uma validação para impedir o uso de números e símbolos, permitindo apenas letras e espaços.

**Método:** `adicionarProdutos()`

---

### Ver estoque

Exibe todos os produtos cadastrados e suas respectivas quantidades.

Caso não existam produtos cadastrados, o sistema informa que o estoque está vazio.

**Métodos utilizados:**

* `estoqueVazio()`
* `getProdutos()`

---

### Alterar item

Permite alterar o nome e a quantidade de um produto existente.

**Método:** `alterarEstoque(String nome, String novoNome, int novaQuantidade)`

O sistema procura o produto pelo nome informado e, caso ele exista, atualiza seus dados.

Após realizar uma alteração, o sistema permite que o usuário escolha se deseja alterar outro item, podendo repetir a operação enquanto responder `sim`.

---

### Retirar item

Reduz a quantidade disponível de um produto.

**Método:** `retirarProduto(String nome, int quantidade)`

A operação não é realizada caso o produto não exista ou a quantidade solicitada seja superior à quantidade disponível.

---

### Deletar item

Remove completamente um produto do estoque.

**Método:** `deletarProduto(String nome)`

---

## 5. Interface do sistema

Ao iniciar a aplicação, é apresentado o seguinte menu:

```text
============ CONTROLE DE ESTOQUE =============
ESCOLHA A FUNCIONALIDADE QUE DESEJA ACESSAR:
1 - ADICIONAR ITEM
2 - VER ESTOQUE
3 - ALTERAR ITEM DO ESTOQUE
4 - RETIRAR ITEM
5 - DELETAR ITEM
0 - SAIR DO PROGRAMA
```

O usuário seleciona uma opção digitando o número correspondente.

Na opção de alteração, após modificar um produto, o sistema pergunta se o usuário deseja alterar outro item.

---

## 6. Fluxo da aplicação

A aplicação segue o fluxo:

```text
Usuário
   ↓
MenuEstoque
   ↓
ControleDeEstoque
   ↓
Produto
```

A `View` recebe a entrada do usuário e encaminha a solicitação para o `Controller`. O `Controller` executa a operação sobre os objetos `Produto` armazenados na `ArrayList`.

---

## 7. Armazenamento dos dados

Os produtos são armazenados em memória utilizando:

```java
ArrayList<Produto>
```

Os dados permanecem disponíveis enquanto o programa estiver em execução.

**Observação:** a versão atual não utiliza banco de dados ou armazenamento permanente. Ao encerrar o programa, os produtos cadastrados são perdidos.

---

## 8. Interface e arquitetura

O projeto utiliza **MVC** para separar as responsabilidades:

* **Model:** representa os dados (`Produto`);
* **View:** interação com o usuário (`MenuEstoque` e `Main`);
* **Controller:** gerenciamento e regras do estoque (`ControleDeEstoque`).

A `MenuEstoque` utiliza uma instância de `ControleDeEstoque` para encaminhar as operações realizadas pelo usuário, mantendo a separação entre a interface e o gerenciamento dos dados.

---

## 9. Execução

Para executar o sistema:

1. Abra o projeto em uma IDE compatível com Java.
2. Certifique-se de que o JDK esteja configurado.
3. Execute a classe:

```text
view.Main
```

4. Utilize o menu exibido no terminal para realizar as operações.

---

## 10. Tratamento das operações

O sistema utiliza valores booleanos para informar o resultado de algumas operações.

Por exemplo:

```java
boolean sucesso = controller.retirarProduto(nome, quantidade);
```

O retorno `true` indica que a operação foi realizada. O retorno `false` indica que a operação não pôde ser realizada, como no caso de um produto inexistente ou quantidade insuficiente.

O sistema também verifica se o estoque está vazio antes de executar operações que dependem da existência de produtos.

---

## 11. Limitações atuais

* Os dados são armazenados somente em memória.
* Não há persistência em banco de dados.
* Não existe autenticação de usuários.
* A interface é executada exclusivamente pelo terminal.
* O sistema não possui controle de categorias, preços ou fornecedores.
* A validação de entrada é limitada aos campos atualmente tratados pela interface.

---

## 12. Possíveis evoluções

O sistema pode ser posteriormente expandido para incluir:

* Persistência em banco de dados;
* Interface gráfica ou aplicação web;
* Cadastro de usuários e níveis de acesso;
* Controle de preços;
* Categorias de produtos;
* Histórico de movimentações;
* Relatórios de estoque;
* Controle de entrada e saída de produtos.

```

**Observação importante:** também corrigi na documentação os nomes dos métodos de `retirar` e `deletar` para corresponderem ao código que você acabou de enviar: `retirarProduto()` e `deletarProduto()`.
```
