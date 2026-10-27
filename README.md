# Trabalho Prático — Divisão e Conquista

##  Sobre o projeto

Este projeto foi desenvolvido para a disciplina como parte do trabalho prático sobre a técnica de **Divisão e Conquista**. O objetivo é implementar algoritmos para dois problemas, comparar suas versões com soluções de força bruta e analisar experimentalmente seus tempos de execução.

**Prazo de entrega:** 28/10/2026  
**Integrantes:** Pedro Lucas de Oliveira Duarte e Samuel Batista Oliveira  
**Linguagem:** Java

##  Objetivos

- Implementar soluções por força bruta e por divisão e conquista.
- Comparar a correção e o desempenho das implementações.
- Criar casos de teste, incluindo situações de borda.
- Medir o tempo de execução para diferentes tamanhos de entrada.
- Comparar os resultados observados com as complexidades teóricas.

##  Problemas do trabalho

### 1. Subarranjo de Soma Máxima

Dada uma sequência de inteiros que representa variações diárias no preço de uma ação, o objetivo é encontrar o intervalo contínuo cuja soma seja máxima.

**Entrada:** um inteiro `n`, seguido de `n` valores inteiros.  
**Saída:** a soma máxima e os índices inicial e final do intervalo encontrado.

Implementações:
- **Força bruta — O(n²):** examina os intervalos possíveis e identifica aquele com a maior soma.
- **Divisão e conquista — O(n log n):** divide o vetor em duas metades, resolve cada metade recursivamente e calcula a melhor solução que cruza o meio.
- **Kadane — O(n):** implementação adicional do algoritmo linear.

**Casos de borda cobertos pelos testes:**
- Vetor com apenas valores negativos.
- Vetor de tamanho 1.
- Empates entre intervalos com a mesma soma máxima.
- Vetor com zeros.

### 2. Par de Pontos Mais Próximos

Dadas as coordenadas de `n` pontos em um plano, o objetivo é encontrar o par cuja distância euclidiana é a menor.

Implementações previstas:
- **Força bruta — O(n²):** calcula a distância entre todos os pares de pontos.
- **Divisão e conquista — O(n log n):** divide os pontos pela mediana das coordenadas `x`, resolve recursivamente os dois lados e verifica os pontos próximos à linha divisória.

Na etapa de combinação, os pontos da faixa são considerados em ordem de coordenada `y`, comparando-se cada ponto com no máximo sete vizinhos seguintes. A justificativa desse limite deve ser apresentada no relatório.

##  Testes da Etapa 1

O projeto já contém uma bateria de testes para o problema do subarranjo de soma máxima.

- `TestesEtapa1.java`: executa 14 casos de teste nas três implementações (força bruta, divisão e conquista e Kadane) e informa quantos passaram.
- `tests/casos_etapa1.txt`: contém os mesmos 14 casos, com entrada, saída esperada e a justificativa de cada um.

Os casos incluem vetor só com negativos, vetor de tamanho 1, empates entre intervalos de mesma soma, zeros e casos em que o melhor intervalo cruza o meio ou fica inteiro em uma das metades.


##  Análise experimental

O arquivo `BenchmarkEtapa1.java` mede o tempo de execução das três implementações da Etapa 1, com cinco execuções por tamanho de entrada, e gera `data/medicoes_etapa1.csv` (medições brutas, em nanossegundos).

A configuração da máquina usada está em `data/configuracao_maquina.txt` (preenchida manualmente). A tabela e os gráficos, gerados a partir do CSV, estão em `figuras/`.

A análise final deverá comparar os tempos observados com as complexidades teóricas, discutir em quais tamanhos cada abordagem apresenta melhor desempenho e justificar o limiar escolhido na Etapa 2, caso seja utilizado.

##  Como executar

Os comandos abaixo pressupõem que os arquivos estejam organizados conforme a estrutura de pastas deste README e que os comandos sejam executados na raiz do repositório.

### 1. Compilar os programas Java

É necessário utilizar uma versão compatível com Java 17 ou superior.

```bash
mkdir out
javac -d out src/SubarranjoMaximo.java src/TestesEtapa1.java src/BenchmarkEtapa1.java
```

### 2. Executar um algoritmo da Etapa 1

O programa recebe `n` e, em seguida, os `n` inteiros pela entrada padrão. A saída contém `soma inicio fim`, com índices começando em zero.

```bash
java -cp out SubarranjoMaximo forca-bruta
java -cp out SubarranjoMaximo dc
java -cp out SubarranjoMaximo kadane
```

Também é possível redirecionar uma entrada salva em arquivo:

```bash
java -cp out SubarranjoMaximo dc < entrada.txt
```

### 3. Executar os testes

```bash
java -cp out TestesEtapa1
```

### 4. Executar o benchmark

```bash
java -cp out BenchmarkEtapa1
```

O benchmark cria a pasta data/ e gera o arquivo de medições data/medicoes_etapa1.csv.

### 5. Tabela e gráficos

A tabela de médias e os gráficos (escala linear, log-log, cruzamento e normalizado) estão em `figuras/` e foram gerados a partir de `data/medicoes_etapa1.csv`.

##  Estrutura do repositório

A estrutura recomendada para os arquivos já enviados é:

```text
.
├── src/
│   ├── SubarranjoMaximo.java
│   ├── TestesEtapa1.java
│   └── BenchmarkEtapa1.java
├── tests/
│   └── casos_etapa1.txt
├── data/
│   ├── medicoes_etapa1.csv
│   └── configuracao_maquina.txt
├── figuras/
├── report/
│   └── relatorio.pdf
├── README.md
└── .gitignore
```

O CSV é gerado pelo benchmark; a configuração da máquina foi preenchida manualmente e os gráficos foram gerados a partir do CSV. Os arquivos da Etapa 2 (Samuel) ficam em `src/` e `tests/`.

##  Relatório

O relatório em PDF, com até oito páginas, deverá apresentar:

- As recorrências dos algoritmos.
- Os resultados das medições em tabelas e gráficos.
- A discussão dos resultados observados em comparação com a análise teórica.
- A comparação entre força bruta e divisão e conquista para diferentes tamanhos de entrada.
- A justificativa do limite de comparações na faixa do problema do par de pontos mais próximos e do limiar utilizado, se aplicável.
- A configuração da máquina usada nos experimentos.

##  Integrantes

- **Pedro Lucas de Oliveira Duarte**
- **Samuel Batista Oliveira**

---

Trabalho acadêmico desenvolvido para estudar e avaliar algoritmos baseados na técnica de **Divisão e Conquista**.
