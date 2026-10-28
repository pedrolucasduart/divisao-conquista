# Comparação dos limiares — Par de Pontos Mais Próximos

Tempos médios em milissegundos, considerando cinco execuções por configuração.

| n | Limiar 3 | Limiar 8 | Limiar 16 | Limiar 32 | Limiar 64 |
|---:|---:|---:|---:|---:|---:|
| 100 | 0,1445 | 0,0889 | 0,1005 | 0,0916 | 0,0971 |
| 200 | 0,6096 | 0,2292 | 0,2181 | 0,2212 | 0,2471 |
| 400 | 1,0015 | 0,8134 | 0,6399 | 0,5823 | 0,4836 |
| 800 | 1,2499 | 0,8138 | 0,5321 | 0,4858 | 0,4928 |
| 1600 | 1,5284 | 1,1052 | 0,7953 | 0,7523 | 0,8535 |
| 3200 | 1,9954 | 1,9234 | 1,8118 | 1,9822 | 1,8181 |
| 6400 | 4,4816 | 4,3419 | 3,7693 | 3,8121 | 4,3292 |

## Conclusão

O limiar 16 apresentou o menor somatório dos tempos médios entre os valores avaliados. Por isso, foi escolhido como configuração experimental.

Os resultados podem variar conforme a máquina, o aquecimento da JVM e as condições de execução.
