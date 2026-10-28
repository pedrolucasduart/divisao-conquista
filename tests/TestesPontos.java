
public class TestesPontos {

    public static void main(String[] args) {

        testar("Dois pontos",
                new double[][]{{0, 0}, {3, 4}}, 5.0);

        testar("Pontos duplicados",
                new double[][]{{2, 2}, {2, 2}}, 0.0);

        testar("Pontos alinhados",
                new double[][]{{1, 1}, {1, 3}, {1, 8}}, 2.0);

        testar("Quatro pontos",
                new double[][]{{0, 0}, {2, 2}, {1, 1}, {2, 3}}, 1.0);

        testar("Par cruzando a divisao",
                new double[][]{{0, 0}, {1, 10}, {4, 4},
                        {5, 4}, {8, 10}, {9, 0}
                }, 1.0);

        testar("Pontos com mesmo Y",
                new double[][]{
                        {0, 2}, {3, 2}, {4, 2}, {10, 2}
                }, 1.0);

        testar("Empate entre pares",
                new double[][]{
                        {0, 0}, {1, 0}, {5, 5}, {6, 5}
                }, 1.0);

        testarAleatorios();
    }

    public static void testar(String nome,
                              double[][] pontos,
                              double esperado) {

        double forcaBruta = ForcaBrutaPontos.calcular(pontos);
        double divisaoConquista =
                DivisaoConquistaPontos.calcular(pontos);

        boolean passou =
                Math.abs(forcaBruta - esperado) < 0.000001 &&
                        Math.abs(divisaoConquista - esperado) < 0.000001;

        System.out.println(nome + ": " +
                (passou ? "PASSOU" : "FALHOU"));

        if (!passou) {
            System.out.println("Esperado: " + esperado);
            System.out.println("Forca bruta: " + forcaBruta);
            System.out.println("Divisao e conquista: " + divisaoConquista);
        }
    }

    public static void testarAleatorios() {

        java.util.Random random = new java.util.Random(42);

        for (int teste = 1; teste <= 1000; teste++) {

            int n = 2 + random.nextInt(99);
            double[][] pontos = new double[n][2];

            for (int i = 0; i < n; i++) {
                pontos[i][0] = random.nextInt(201) - 100;
                pontos[i][1] = random.nextInt(201) - 100;
            }

            double forcaBruta = ForcaBrutaPontos.calcular(pontos);
            double divisaoConquista =
                    DivisaoConquistaPontos.calcular(pontos);

            if (Math.abs(forcaBruta - divisaoConquista) > 0.000001) {
                System.out.println("FALHOU no teste " + teste);
                System.out.println("Forca bruta: " + forcaBruta);
                System.out.println("Divisao e conquista: " + divisaoConquista);
                return;
            }
        }

        System.out.println("1000 testes aleatorios: PASSOU");
    }
}
