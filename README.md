# Trabalho Prático — Divisão e Conquista

**Disciplina:** Trabalho prático de algoritmos  
**Integrantes:** Pedro Lucas de Oliveira Duarte e Samuel Batista Oliveira  
**Linguagem:** Java (JDK 21 utilizado nos experimentos)  
**Data de entrega:** 28/10/2026

## Sobre o projeto

Implementação, validação e análise experimental de algoritmos de **força bruta** e **divisão e conquista** em dois problemas: **Subarranjo de Soma Máxima** e **Par de Pontos Mais Próximos**. Também foi implementado o algoritmo linear de Kadane para a primeira etapa. As medições foram registradas em CSV e apresentadas em tabelas e gráficos.

## Etapa 1 — Subarranjo de Soma Máxima

Dada uma sequência de inteiros, encontrar a maior soma de um subarranjo contínuo e seus índices inicial e final (base zero).

| Algoritmo | Complexidade de tempo | Descrição |
|---|---|---|
| Força bruta | O(n²) | Examina todos os intervalos, acumulando as somas incrementalmente. |
| Divisão e conquista | O(n log n) | Resolve as duas metades e combina o melhor intervalo que cruza o meio. |
| Kadane | O(n) | Percorre o vetor uma vez, mantendo a melhor soma corrente. |

**Recorrência de divisão e conquista:** `T(n) = 2T(n/2) + O(n)`.

### Testes da Etapa 1

`src/TestesEtapa1.java` executa **14 casos** nas três implementações. Os casos incluem vetores somente negativos, tamanho 1, zeros, empates, intervalos cruzando o meio e soluções restritas a uma das metades. As entradas e saídas esperadas estão em `tests/casos_etapa1.txt`.

### Experimentos da Etapa 1

`src/BenchmarkEtapa1.java` mede as três soluções em dez tamanhos de entrada, com **5 repetições por tamanho e algoritmo**. Os dados brutos estão em `data/medicoes_etapa1.csv`. O relatório da equipe registra o ambiente AMD Ryzen 5 5600GT, 16 GB de RAM, Windows 10 e Java 21.

## Etapa 2 — Par de Pontos Mais Próximos

Dado um conjunto de pontos `(x, y)`, encontrar a menor distância euclidiana entre dois deles.

| Algoritmo | Complexidade de tempo | Arquivo |
|---|---|---|
| Força bruta | O(n²) | `src/ForcaBrutaPontos.java` |
| Divisão e conquista | O(n log n) | `src/DivisaoConquistaPontos.java` |

Na divisão e conquista, os pontos são separados pela mediana de `x`; após resolver as metades, verifica-se a faixa central de largura `2δ`, ordenada por `y`, comparando até **7 vizinhos seguintes** por ponto. A justificativa geométrica está no relatório final.

**Recorrência:** `T(n) = 2T(n/2) + O(n)`, assumindo manutenção eficiente da ordem por `y`.

### Testes da Etapa 2

`tests/TestesPontos.java` foi executado com **1.007 testes aprovados**: sete casos específicos (dois pontos, duplicados, alinhados, quatro pontos, par cruzando a divisão, mesmo `y` e empate) e mil casos aleatórios comparados à força bruta.

### Experimentos da Etapa 2

- `src/BenchmarkPontos.java`: compara o desempenho das duas implementações.
- `src/BenchmarkLimiar.java`: avalia os limiares **3, 8, 16, 32 e 64** para usar força bruta nos subproblemas pequenos.
- `data/benchmark_pontos.csv`: medições de comparação.
- `data/benchmark_limiares.csv`: medições dos limiares.
- `figuras/tabela_etapa2.md` e `figuras/tabela_limiares.md`: tabelas dos resultados.

O **limiar 16** foi adotado porque apresentou o melhor resultado agregado nas medições documentadas, embora outros limiares possam vencer em tamanhos isolados. O relatório descreve a metodologia, os gráficos, as limitações e a interpretação dos resultados.

**Ambiente documentado para a Etapa 2:** AMD Ryzen 5 5600GT com Radeon Graphics, 16 GB de RAM, Windows 11 Pro e Java 21. Consulte também `data/configuracao_maquina.txt` para os registros de configuração do projeto.

## Como compilar e executar

Execute os comandos a partir da **raiz do repositório**, com o **JDK 21** instalado e `javac` e `java` apontando para a mesma instalação. No PowerShell do Windows, crie a pasta de saída:

```powershell
New-Item -ItemType Directory -Force out | Out-Null
```

### Etapa 1

```powershell
javac -d out src/SubarranjoMaximo.java src/TestesEtapa1.java src/BenchmarkEtapa1.java
java -cp out TestesEtapa1
java -cp out BenchmarkEtapa1
```

Para executar uma solução com dados digitados na entrada padrão:

```powershell
java -cp out SubarranjoMaximo forca-bruta
java -cp out SubarranjoMaximo dc
java -cp out SubarranjoMaximo kadane
```

Informe `n` seguido dos `n` valores inteiros. A saída apresenta `soma inicio fim`, com índices iniciando em zero.

### Etapa 2 — Testes

```powershell
javac -d out src/ForcaBrutaPontos.java src/DivisaoConquistaPontos.java tests/TestesPontos.java
java -cp out TestesPontos
```

### Etapa 2 — Benchmarks

```powershell
javac -d out src/ForcaBrutaPontos.java src/DivisaoConquistaPontos.java src/BenchmarkPontos.java src/BenchmarkLimiar.java
java -cp out BenchmarkPontos
java -cp out BenchmarkLimiar
```

**Atenção no Windows:** se o `java` do terminal apontar para Java 8, enquanto `javac` usa Java 21, pode ocorrer `UnsupportedClassVersionError`. Verifique com `java -version`, `javac -version` e `where.exe java`. No IntelliJ IDEA, configure o SDK e a execução para Java 21.

## Gráficos e tabelas

A pasta `figuras/` contém:

| Etapa 1 | Etapa 2 |
|---|---|
| `grafico_linear.png` | `grafico_comparacao_pontos.png` |
| `grafico_loglog.png` | `grafico_divisao_conquista.png` |
| `grafico_cruzamento.png` | `grafico_limiares.png` |
| `grafico_normalizado.png` | `tabela_etapa2.md` |
| `tabela_etapa1.md` | `tabela_limiares.md` |

Os gráficos foram produzidos a partir dos dados experimentais. `src/GeradorGraficos.java` também está presente no projeto.

## Organização do repositório

```text
.
├── src/
│   ├── SubarranjoMaximo.java
│   ├── TestesEtapa1.java
│   ├── BenchmarkEtapa1.java
│   ├── ForcaBrutaPontos.java
│   ├── DivisaoConquistaPontos.java
│   ├── BenchmarkPontos.java
│   ├── BenchmarkLimiar.java
│   └── GeradorGraficos.java
├── tests/
│   ├── casos_etapa1.txt
│   └── TestesPontos.java
├── data/
│   ├── medicoes_etapa1.csv
│   ├── benchmark_pontos.csv
│   ├── benchmark_limiares.csv
│   └── configuracao_maquina.txt
├── figuras/
│   ├── *.png
│   └── tabela_*.md
├── README.md
└── .gitignore
```

## Relatório final

O **relatório consolidado de 7 páginas** reúne as duas etapas, as recorrências, os testes, a comparação experimental com gráficos e tabelas, a justificativa das sete comparações na faixa e a escolha do limiar 16. O PDF deve ser incluído na entrega conforme as orientações do professor (por exemplo, em `report/relatorio.pdf`).

## Observações

- A aprovação dos testes locais não substitui a bateria de avaliação do professor.
- Os tempos são específicos das máquinas e das condições de medição; a comparação direta de tempos absolutos entre as etapas requer cautela.
- Os arquivos CSV permitem consultar as medições brutas; os gráficos e o relatório apresentam resultados resumidos.
