
public class ForcaBrutaPontos {

    public static double calcular(double[][] pontos) {

        if (pontos == null || pontos.length < 2) {
            throw new IllegalArgumentException(
                    "Informe pelo menos dois pontos."
            );
        }

        double menorDistancia = Double.MAX_VALUE;

        for (int i = 0; i < pontos.length; i++) {
            for (int j = i + 1; j < pontos.length; j++) {

                double dx = pontos[i][0] - pontos[j][0];
                double dy = pontos[i][1] - pontos[j][1];

                double distancia = Math.hypot(dx, dy);

                if (distancia < menorDistancia) {
                    menorDistancia = distancia;
                }
            }
        }

        return menorDistancia;
    }
}
