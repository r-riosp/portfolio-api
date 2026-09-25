# Portfolio Tracker API

Uma API RESTful focada na consolidação financeira e gestão de ativos de uma carteira de investimentos. Criada para simular o motor de consolidação de uma corretora, calculando o patrimônio total com base no preço médio e quantidade de ativos sob custódia.

## Tecnologias Utilizadas
* **Kotlin** (Linguagem principal, aproveitando Data Classes e Null Safety)
* **Spring Boot 3** (Framework Web e Injeção de Dependências)
* **Spring Data JPA / Hibernate** (Mapeamento Objeto-Relacional)
* **H2 Database** (Banco de dados relacional em memória para desenvolvimento ágil)
* **Gradle** (Automação de builds)

## Como Rodar o Projeto Localmente
1. Clone este repositório.
2. Abra o terminal na raiz do projeto.
3. Execute o comando de build e inicialização:
   ```bash
   ./gradlew bootRun
   ```
4. A API estará disponível em `http://localhost:8080`.
5. O painel do banco de dados pode ser acessado em `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:portfoliodb`).

## Endpoints Principais
* `POST /api/portfolio` - Registra um novo ativo na carteira (Payload: `ticker`, `quantity`, `averagePrice`).
* `GET /api/portfolio` - Retorna o extrato completo com todos os ativos custodiados.
* `GET /api/portfolio/total` - Retorna o patrimônio financeiro consolidado (Soma de Quantidade * Preço Médio de todos os ativos).

---
**Desenvolvido por Rafael Rios Pereira**