# Screenmatch - Sistema de Avaliação de Filmes e Séries

Este projeto é uma aplicação Java para gerenciar e avaliar filmes e séries. Ele permite que os usuários adicionem avaliações, calculem médias de avaliações e armazenem informações sobre filmes e séries.

## Funcionalidades

- Adicionar e gerenciar filmes e séries.
- Adicionar avaliações a filmes e séries.
- Calcular a média de avaliações para cada filme e série.
- Armazenar e recuperar informações sobre filmes e séries.

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

- `src/main/java/org/mach/modelos/`: Contém as classes principais para filmes (`Filme`), séries (`Serie`) e a superclasse comum (`Titulo`).

## Classes

### Titulo

A classe `Titulo` é a superclasse para `Filme` e `Serie`. Ela contém atributos e métodos comuns para gerenciar avaliações.

### Filme

A classe `Filme` estende `Titulo` e inclui atributos adicionais específicos para filmes.

### Serie

A classe `Serie` estende `Titulo` e inclui atributos adicionais específicos para séries.

## Uso

### Adicionando um Filme

Para adicionar um filme, crie uma instância da classe `Filme`:

```java
Filme filme = new Filme("Nome do Filme", 2023, 120, "Nome do Diretor");