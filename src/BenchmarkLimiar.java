
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Random;

public class BenchmarkLimiar {

    public static void main(String[] args) {

        int[] limiares = {3, 8, 16, 32, 64};
        int[] tamanhos = {100, 200, 400, 800, 1600, 3200, 6400};
        int repeticoes = 5;

        File pasta = new File("data");

        if (!pasta.exists() && !pasta.mkdirs()) {
            throw new IllegalStateException(
                    "Nao foi possivel criar a pasta data."
            );
        }

        Random random = new Random(123);


        double[][][][] entradas =
                new double[tamanhos.length][repeticoes][][];

        for (int i = 0; i < tamanhos.length; i++) {
            for (int r = 0; r < repeticoes; r++) {
                entradas[i][r] =
                        gerarPontos(tamanhos[i], random);
            }
        }

        // Aquecimento da JVM
        for (int limiar : limiares) {

            DivisaoConquistaPontos.definirLimiar(limiar);

            for (int i = 0; i < 100; i++) {
                DivisaoConquistaPontos.calcular(
                        entradas[1][0]
                );
            }
        }

        try (PrintWriter csv = new PrintWriter(
                new FileWriter("data/benchmark_limiares.csv"))) {

            csv.println("n,limiar,repeticao,tempo_ms");

            System.out.println(
                    "N | Limiar | Tempo medio (ms)"
            );

            for (int nIndex = 0;
                 nIndex < tamanhos.length;
                 nIndex++) {

                int n = tamanhos[nIndex];

                for (int limiar : limiares) {

                    DivisaoConquistaPontos.definirLimiar(limiar);

                    double total = 0;

                    for (int r = 0; r < repeticoes; r++) {

                        double[][] pontos =
                                entradas[nIndex][r];

                        long inicio = System.nanoTime();

                        double resultado =
                                DivisaoConquistaPontos.calcular(pontos);

                        long fim = System.nanoTime();

                        double tempo =
                                (fim - inicio) / 1_000_000.0;

                        double esperado =
                                ForcaBrutaPontos.calcular(pontos);

                        if (Math.abs(resultado - esperado) > 0.000001) {
                            throw new IllegalStateException(
                                    "Resultados diferentes para n="
                                            + n
                                            + ", limiar="
                                            + limiar
                            );
                        }

                        total += tempo;

                        csv.printf(
                                Locale.US,
                                "%d,%d,%d,%.6f%n",
                                n,
                                limiar,
                                r + 1,
                                tempo
                        );
                    }

                    System.out.printf(
                            Locale.US,
                            "%d | %d | %.4f%n",
                            n,
                            limiar,
                            total / repeticoes
                    );
                }

                System.out.println("-----------------------");
            }

            System.out.println(
                    "CSV gerado em data/benchmark_limiares.csv"
            );

        } catch (IOException e) {
            System.out.println(
                    "Erro ao gerar CSV: " + e.getMessage()
            );
        } finally {

            DivisaoConquistaPontos.definirLimiar(3);
        }
    }

    private static double[][] gerarPontos(
            int n,
            Random random
    ) {

        double[][] pontos = new double[n][2];

        for (int i = 0; i < n; i++) {
            pontos[i][0] = random.nextDouble() * 10000;
            pontos[i][1] = random.nextDouble() * 10000;
        }

        return pontos;
    }
}
