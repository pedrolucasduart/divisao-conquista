
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
    }

    public static void testar(String nome,
                              double[][] pontos,
                              double esperado) {

        double resultado = ForcaBrutaPontos.calcular(pontos);

        if (Math.abs(resultado - esperado) < 0.000001) {
            System.out.println(nome + ": PASSOU");
        } else {
            System.out.println(nome + ": FALHOU");
            System.out.println("Esperado: " + esperado);
            System.out.println("Obtido: " + resultado);
        }
    }
}
