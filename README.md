# Trabalho Prático — Divisão e Conquista

## 📌 Sobre o projeto

Este projeto foi desenvolvido para a disciplina como parte do trabalho prático sobre a técnica de **Divisão e Conquista**. O objetivo é implementar algoritmos para dois problemas, comparar suas versões com soluções de força bruta e analisar experimentalmente seus tempos de execução.

**Prazo de entrega:** 28/10/2026  
**Integrantes:** [Nome do integrante 1] e [Nome do integrante 2]  
**Linguagem:** [Informar linguagem utilizada]

## 🎯 Objetivos

- Implementar soluções por força bruta e por divisão e conquista.
- Comparar a correção e o desempenho das implementações.
- Criar casos de teste, incluindo situações de borda.
- Medir o tempo de execução para diferentes tamanhos de entrada.
- Comparar os resultados observados com as complexidades teóricas.

## 🧩 Problemas implementados

### 1. Subarranjo de Soma Máxima

Dada uma sequência de inteiros que representa variações diárias no preço de uma ação, o objetivo é encontrar o intervalo contínuo cuja soma seja máxima.

**Entrada:** um inteiro `n`, seguido de `n` valores inteiros.  
**Saída:** a soma máxima e os índices inicial e final do intervalo encontrado.

Foram previstas duas abordagens:

- **Força bruta — O(n²):** examina os intervalos possíveis e identifica aquele com a maior soma.
- **Divisão e conquista — O(n log n):** divide o vetor em duas metades, resolve cada metade recursivamente e calcula a melhor solução que cruza o meio. A resposta é o maior resultado entre essas três possibilidades.

**Casos de borda:**
- Vetor com apenas valores negativos.
- Vetor com apenas um elemento.
- Dois ou mais intervalos com a mesma soma máxima.

### 2. Par de Pontos Mais Próximos

Dadas as coordenadas de `n` pontos em um plano, o objetivo é encontrar o par cuja distância euclidiana é a menor.

Foram previstas duas abordagens:

- **Força bruta — O(n²):** calcula a distância entre todos os pares de pontos.
- **Divisão e conquista — O(n log n):** divide os pontos pela mediana das coordenadas `x`, resolve recursivamente os dois lados e verifica os pontos próximos à linha divisória.

Na etapa de combinação, os pontos da faixa são considerados em ordem de coordenada `y`, comparando-se cada ponto com no máximo sete vizinhos seguintes, conforme o método descrito no enunciado. A justificativa desse limite deve ser apresentada no relatório.

## 🧪 Testes

O projeto deve incluir um arquivo com os casos de teste, suas entradas e as saídas esperadas.

Os testes devem verificar:
- Entradas pequenas e casos mínimos.
- Casos de borda específicos de cada problema.
- Situações com resultados iguais ou muito próximos.
- Concordância entre os resultados das versões de força bruta e divisão e conquista.

**Arquivo de testes:** `[caminho do arquivo de testes]`

## 📊 Análise experimental

Para avaliar o desempenho, serão medidos os tempos de execução dos algoritmos com tamanhos crescentes de entrada, calculando a média de pelo menos cinco execuções para cada tamanho.

Os resultados serão apresentados em:
- Tabelas com os tempos medidos.
- Gráficos para comparar os algoritmos.
- Arquivo CSV com as medições brutas.
- Descrição da configuração da máquina utilizada nos experimentos.

A análise deverá comparar os tempos observados com as complexidades teóricas, discutir em quais tamanhos cada abordagem apresenta melhor desempenho e justificar o limiar escolhido para a implementação da segunda etapa, caso seja utilizado.

**Arquivos de resultados:**
- CSV das medições: `[caminho do arquivo CSV]`
- Gráficos: `[caminho dos gráficos]`
- Relatório em PDF: `[caminho do relatório]`

## ▶️ Como executar

> Complete esta seção com os comandos correspondentes à linguagem e à estrutura deste repositório.

1. Clone o repositório:

   ```bash
   git clone [URL_DO_REPOSITORIO]
   ```

2. Entre na pasta do projeto:

   ```bash
   cd [NOME_DA_PASTA]
   ```

3. Compile ou instale as dependências, se necessário:

   ```bash
   [COMANDO_DE_COMPILACAO_OU_INSTALACAO]
   ```

4. Execute o programa:

   ```bash
   [COMANDO_DE_EXECUCAO]
   ```

5. Para executar os testes:

   ```bash
   [COMANDO_PARA_EXECUTAR_TESTES]
   ```

## 📁 Estrutura do repositório

A estrutura abaixo é uma sugestão e deve ser ajustada aos arquivos reais do projeto.

```text
.
├── src/                 # Código-fonte dos algoritmos
├── tests/               # Casos de teste e saídas esperadas
├── results/
│   ├── measurements.csv # Medições brutas de tempo
│   └── graphs/          # Gráficos da análise experimental
├── report/
│   └── relatorio.pdf    # Relatório final (até 8 páginas)
└── README.md            # Documentação do projeto
```

## 📝 Relatório

O relatório em PDF, com até oito páginas, deverá apresentar:

- As recorrências dos algoritmos.
- Os resultados das medições, em tabelas e gráficos.
- A discussão dos resultados observados em comparação com a análise teórica.
- A comparação entre força bruta e divisão e conquista para diferentes tamanhos de entrada.
- A justificativa do limite de comparações na faixa do problema do par de pontos mais próximos e do limiar utilizado, se aplicável.
- A configuração da máquina usada nos experimentos.

## 👥 Integrantes

- **[Nome do integrante 1]**
- **[Nome do integrante 2]**

---

Trabalho acadêmico desenvolvido para estudar e avaliar algoritmos baseados na técnica de **Divisão e Conquista**.
