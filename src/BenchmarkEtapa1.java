import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
public class BenchmarkEtapa1 {
    public static int[] gerarVetor(int n, long semente) {
        Random sorteio = new Random(semente);
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sorteio.nextInt(2001) - 1000;
        }
        return v;
    }

    public static void main(String[] args) throws Exception {
        int[] tamanhos = {100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600, 51200};
        int execucoes = 5;
        long total = 0;

        for (int k = 0; k < 30; k++) {
            int[] v = gerarVetor(5000, k);
            total = total + SubarranjoMaximo.forcaBruta(v)[0];
            total = total + SubarranjoMaximo.divisaoConquista(v)[0];
            total = total + SubarranjoMaximo.kadane(v)[0];
        }

        new File("data").mkdirs();
        PrintWriter csv = new PrintWriter("data/medicoes_etapa1.csv");
        csv.println("algoritmo,n,execucao,tempo_ns");

        for (int t = 0; t < tamanhos.length; t++) {
            int n = tamanhos[t];

            for (int e = 1; e <= execucoes; e++) {
                int[] v = gerarVetor(n, n * 31L + e);

                long inicio = System.nanoTime();
                int[] r1 = SubarranjoMaximo.forcaBruta(v);
                long fim = System.nanoTime();
                total = total + r1[0];
                csv.println("forca-bruta," + n + "," + e + "," + (fim - inicio));

                inicio = System.nanoTime();
                int[] r2 = SubarranjoMaximo.divisaoConquista(v);
                fim = System.nanoTime();
                total = total + r2[0];
                csv.println("divisao-conquista," + n + "," + e + "," + (fim - inicio));

                inicio = System.nanoTime();
                int[] r3 = SubarranjoMaximo.kadane(v);
                fim = System.nanoTime();
                total = total + r3[0];
                csv.println("kadane," + n + "," + e + "," + (fim - inicio));
            }

            System.out.println("n = " + n + " concluído");
        }

        csv.close();
        System.out.println("Pronto! (verificação: " + total + ")");
    }
}
