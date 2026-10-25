
import java.util.Arrays;
import java.util.Comparator;

public class DivisaoConquistaPontos {

    public static double calcular(double[][] pontos) {

        if (pontos == null || pontos.length < 2) {
            throw new IllegalArgumentException(
                    "Informe pelo menos dois pontos."
            );
        }

        double[][] ordenadosX = pontos.clone();
        double[][] ordenadosY = pontos.clone();

        Arrays.sort(ordenadosX,
                Comparator.comparingDouble(p -> p[0]));

        Arrays.sort(ordenadosY,
                Comparator.comparingDouble(p -> p[1]));

        return resolver(ordenadosX, ordenadosY);
    }


    private static double resolver(double[][] px, double[][] py) {

        int n = px.length;

        if (n <= 3) {
            return ForcaBrutaPontos.calcular(px);
        }

        int meio = n / 2;

        double[][] esquerdaX = Arrays.copyOfRange(px, 0, meio);
        double[][] direitaX = Arrays.copyOfRange(px, meio, n);

        java.util.Set<double[]> pontosEsquerda =
                java.util.Collections.newSetFromMap(
                        new java.util.IdentityHashMap<>()
                );

        pontosEsquerda.addAll(Arrays.asList(esquerdaX));

        double[][] esquerdaY = new double[meio][];
        double[][] direitaY = new double[n - meio][];

        int e = 0;
        int d = 0;

        for (double[] ponto : py) {
            if (pontosEsquerda.contains(ponto)) {
                esquerdaY[e++] = ponto;
            } else {
                direitaY[d++] = ponto;
            }
        }

        double distanciaEsquerda = resolver(esquerdaX, esquerdaY);
        double distanciaDireita = resolver(direitaX, direitaY);

        double menorDistancia =
                Math.min(distanciaEsquerda, distanciaDireita);

        double linhaCentral = px[meio][0];

        double[][] faixa = new double[n][];
        int quantidade = 0;

        for (double[] ponto : py) {
            if (Math.abs(ponto[0] - linhaCentral) < menorDistancia) {
                faixa[quantidade++] = ponto;
            }
        }

        for (int i = 0; i < quantidade; i++) {
            for (int j = i + 1;
                 j < quantidade && j <= i + 7;
                 j++) {

                double dx = faixa[i][0] - faixa[j][0];
                double dy = faixa[i][1] - faixa[j][1];

                double distancia = Math.hypot(dx, dy);

                menorDistancia =
                        Math.min(menorDistancia, distancia);
            }
        }

        return menorDistancia;
    }

}
