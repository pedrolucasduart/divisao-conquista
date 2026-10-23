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
- **Kadane — O(n):** implementação adicional do algoritmo linear, exigida como questão-desafio.

**Casos de borda cobertos pelos testes:**
- Vetor com apenas valores negativos.
- Vetor de tamanho 1.
- Empates entre intervalos com a mesma soma máxima.
- Vetor com zeros e valores grandes.

### 2. Par de Pontos Mais Próximos

Dadas as coordenadas de `n` pontos em um plano, o objetivo é encontrar o par cuja distância euclidiana é a menor.

Implementações previstas:
- **Força bruta — O(n²):** calcula a distância entre todos os pares de pontos.
- **Divisão e conquista — O(n log n):** divide os pontos pela mediana das coordenadas `x`, resolve recursivamente os dois lados e verifica os pontos próximos à linha divisória.

Na etapa de combinação, os pontos da faixa são considerados em ordem de coordenada `y`, comparando-se cada ponto com no máximo sete vizinhos seguintes. A justificativa desse limite deve ser apresentada no relatório.

##  Testes da Etapa 1

O projeto já contém uma bateria de testes para o problema do subarranjo de soma máxima.

- `TestesEtapa1.java`: executa os casos do arquivo de testes e testes aleatórios, comparando os resultados dos três algoritmos.
- `tests/casos_etapa1.txt`: contém entradas e saídas esperadas para casos de borda e outros cenários.

Os testes incluem vetores negativos, vetores de tamanho 1, empates, zeros e somas acima do limite de `int`. A execução deve ser realizada para confirmar os resultados no ambiente local.

##  Análise experimental

O arquivo `BenchmarkEtapa1.java` mede o tempo de execução das três implementações da Etapa 1, com cinco execuções por tamanho de entrada. O programa gera:

- `data/medicoes_etapa1.csv`: medições brutas dos tempos.
- `data/configuracao_maquina.txt`: informações do sistema e do ambiente Java; o modelo da CPU e a quantidade de RAM devem ser completados manualmente.

O script `scripts/graficos.py` lê o CSV e gera uma tabela Markdown e gráficos de comparação na pasta `figuras/`.

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

Por padrão, o programa procura `tests/casos_etapa1.txt`. Para usar outro arquivo:

```bash
java -cp out TestesEtapa1 caminho/do/arquivo.txt
```

### 4. Executar o benchmark

```bash
java -cp out BenchmarkEtapa1
```

O benchmark cria a pasta `data/` e gera os arquivos de medições e configuração da máquina.

### 5. Instalar dependências e gerar os gráficos

É necessário ter Python 3 instalado. Instale as bibliotecas:

```bash
python -m pip install pandas numpy matplotlib
```

Depois de gerar o CSV, execute:

```bash
python scripts/graficos.py data/medicoes_etapa1.csv etapa1
```

Os gráficos e a tabela serão salvos na pasta `figuras/`.

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
├── scripts/
│   └── graficos.py
├── data/
│   ├── medicoes_etapa1.csv
│   └── configuracao_maquina.txt
├── figuras/
├── report/
│   └── relatorio.pdf
├── README.md
└── .gitignore
```

Os arquivos CSV, de configuração e os gráficos são gerados durante a execução. Ajuste a estrutura caso os arquivos estejam em outros caminhos.

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
