# Tic Tac Toe Game


Um simples Jogo da Velha feito em Java.

O objetivo do jogo é ser o primeiro a conseguir marcar três espaços em uma reta.


## Main

A classe Main fica encarregada de:

- Identificar e administrar os jogadores.
  
- Fazer o Print do jogo.
  
- Tratar as exceções.
  
- Finalizar o jogo.
  


## Classe Board

#### Atributos

A classe Board possui 2 atributos List de Integers que representam os jogadores. Os Lists guardam as jogadas dos jogadores.

```java
    private List<Integer> player1;
    private List<Integer> player2;
```

Outro atributo importante é o **combination**, ele é uma matriz estática com todas as combinações possíveis de vitórias.

```java
private static Integer[][] combination = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9}};
```

#### Métodos

O método **play** insere a jogada nas List dos jogadores. O método verifica se a posição já foi jogada ou se está fora limite do jogo. A verificação da posiçao de jogada é tratada lançando uma exceção.

**checkGame** retorna o estado do jogo.

- `return 0` se o Jogador 1 é o vencedor.
  
- `return 1` se o Jogador 2 é o vencedor.
  
- `return 2` se o jogo ainda está em andamento (nenhum dos jogadores venceu e falta espaços no jogo a serem jogados).
  
- `return 3` se o jogo terminou em empate.
  

O método **checkWin** compara a List do jogador com a matriz combination. Caso o jogador possua alguma das combinações, o método retornará **true**.
