# Desafio do Labirinto — Laboratório II

	Este projeto foi desenvolvido como parte da disciplina **Laboratório de Programação II**, com o objetivo de praticar leitura de arquivos, manipulação de arrays bidimensionais e recursividade em Java.

	O desafio consiste em simular um labirinto, onde o programa deve ser capaz de ler a estrutura do labirinto a partir de um arquivo `.txt`, armazená-lo em uma matriz e verificar se há um caminho possível da entrada até o destino.

---

## Enunciado

	Você deve criar um programa que simule um labirinto. O labirinto será representado por um array bidimensional de caracteres, onde:

- `'X'` representa uma parede (não é possível passar);
- `' '` (espaço) representa um caminho livre;
- `'D'` representa o destino (ponto de chegada).

A entrada do labirinto é sempre a posição `[0][0]`.

### Requisitos:

- Criar uma classe `Labirinto` com os seguintes métodos:
  - `criaLabirinto(String filename)`: lê o conteúdo de um arquivo `.txt` e preenche o array bidimensional com os dados do labirinto.
  - `percorreLabirinto()`: método público que chama o método recursivo privado para verificar se existe um caminho até o destino `'D'`.

---

## Funcionalidades

- Leitura de arquivos `.txt` contendo o labirinto.
- Armazenamento em matriz bidimensional.
- Caminhamento recursivo pelo labirinto.
- Retorno booleano indicando se existe ou não um caminho até o destino.
