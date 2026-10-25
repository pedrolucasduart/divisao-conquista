public class TestesEtapa1 {

    static int total = 0;
    static int falhas = 0;

    public static void testar(String descricao, int[] v, int somaEsp, int iniEsp, int fimEsp) {
        int[] fb = SubarranjoMaximo.forcaBruta(v);
        int[] dc = SubarranjoMaximo.divisaoConquista(v);
        total++;

        boolean fbOk = fb[0] == somaEsp && fb[1] == iniEsp && fb[2] == fimEsp;
        boolean dcOk = dc[0] == somaEsp && dc[1] == iniEsp && dc[2] == fimEsp;

        if (fbOk && dcOk) {
            System.out.println("OK     - " + descricao);
        } else {
            falhas++;
            System.out.println("FALHOU - " + descricao);
            System.out.println("   esperado:            " + somaEsp + " " + iniEsp + " " + fimEsp);
            System.out.println("   força bruta:         " + fb[0] + " " + fb[1] + " " + fb[2]);
            System.out.println("   divisão e conquista: " + dc[0] + " " + dc[1] + " " + dc[2]);
        }
    }

    public static void main(String[] args) {
        testar("só negativos", new int[]{-8, -3, -6, -2, -5}, -2, 3, 3);
        testar("só negativos com empate", new int[]{-4, -4, -4}, -4, 0, 0);
        testar("tamanho 1, positivo", new int[]{7}, 7, 0, 0);
        testar("tamanho 1, negativo", new int[]{-3}, -3, 0, 0);
        testar("empate: 1, 1 e 1-1+1 têm soma 1", new int[]{1, -1, 1}, 1, 0, 0);
        testar("empate múltiplo", new int[]{3, -3, 3, -3, 3}, 3, 0, 0);
        testar("empate no meio", new int[]{-1, 2, -2, 2}, 2, 1, 1);

        testar("dois elementos negativos, melhor é o segundo", new int[]{-2, -1}, -1, 1, 1);
        testar("todos positivos", new int[]{1, 2, 3, 4}, 10, 0, 3);
        testar("todos zeros", new int[]{0, 0, 0}, 0, 0, 0);
        testar("exemplo clássico", new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6, 3, 6);
        testar("vetor inteiro atravessa o meio", new int[]{5, -1, -1, 5}, 8, 0, 3);
        testar("melhor na metade esquerda", new int[]{4, 5, -20, 1, -1, 2}, 9, 0, 1);
        testar("melhor na metade direita", new int[]{1, -1, 2, -20, 6, 7}, 13, 4, 5);

        System.out.println();
        System.out.println((total - falhas) + " de " + total + " testes passaram");
    }
}
