
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class BenchmarkPontos {

    public static void main(String[] args) {

        int[] tamanhos = {100, 200, 400, 800, 1600, 3200, 6400};
        int repeticoes = 5;

        File pasta = new File("data");
        if (!pasta.exists() && !pasta.mkdirs()) {
            throw new IllegalStateException("Nao foi possivel criar a pasta data.");
        }

        Random aquecimento = new Random(42);

        for (int r = 0; r < 100; r++) {
            double[][] pontos = gerarPontos(200, aquecimento);
            ForcaBrutaPontos.calcular(pontos);
            DivisaoConquistaPontos.calcular(pontos);
        }

        try (PrintWriter csv = new PrintWriter(
                new FileWriter("data/benchmark_pontos.csv"))) {

            csv.println("n,repeticao,forca_bruta_ms,divisao_conquista_ms");

            Random random = new Random(123);

            System.out.println(
                    "N | Forca Bruta (ms) | Divisao e Conquista (ms)"
            );

            for (int n : tamanhos) {

                double totalBruta = 0;
                double totalDivisao = 0;

                for (int r = 1; r <= repeticoes; r++) {

                    double[][] pontos = gerarPontos(n, random);

                    long inicio = System.nanoTime();
                    double resultadoBruta =
                            ForcaBrutaPontos.calcular(pontos);
                    long fim = System.nanoTime();

                    double tempoBruta = (fim - inicio) / 1_000_000.0;

                    inicio = System.nanoTime();
                    double resultadoDivisao =
                            DivisaoConquistaPontos.calcular(pontos);
                    fim = System.nanoTime();

                    double tempoDivisao = (fim - inicio) / 1_000_000.0;

                    if (Math.abs(resultadoBruta - resultadoDivisao) > 0.000001) {
                        throw new IllegalStateException(
                                "Resultados diferentes para n = " + n
                        );
                    }

                    totalBruta += tempoBruta;
                    totalDivisao += tempoDivisao;

                    csv.printf(
                            java.util.Locale.US,
                            "%d,%d,%.6f,%.6f%n",
                            n, r, tempoBruta, tempoDivisao
                    );
                }

                System.out.printf(
                        "%d | %.4f | %.4f%n",
                        n,
                        totalBruta / repeticoes,
                        totalDivisao / repeticoes
                );
            }

            System.out.println(
                    "CSV gerado em data/benchmark_pontos.csv"
            );

        } catch (IOException e) {
            System.out.println("Erro ao gerar CSV: " + e.getMessage());
        }
    }

    private static double[][] gerarPontos(int n, Random random) {

        double[][] pontos = new double[n][2];

        for (int i = 0; i < n; i++) {
            pontos[i][0] = random.nextDouble() * 10000;
            pontos[i][1] = random.nextDouble() * 10000;
        }

        return pontos;
    }
}
