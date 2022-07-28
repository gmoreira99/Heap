// Guilherme Moreira de Carvalho, 09/07/2021 - para Laboratório de Algoritmos e Estruturas de Dados II, 2021/1

import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

public class Teste {
    public static void main(String[] args) {
        String out = "";    /*saída para um arquivo de texto - resultado das comparações e tempo gasta em cada caso*/
        SecureRandom generator = new SecureRandom();    /*para gerar num aleatórios*/

        for(int n = 10000; n <= 100000; n += 10000) {   /*heaps com n variando de 10000 a 100000 com passo 10000 - 10x3 heaps*/
            out += "n = " + n + "\n";

            // vetores de Item's a serem ordenados com tamanho n
            Item ordC[] = new Item[n];
            Item ordD[] = new Item[n];
            Item rand[] = new Item[n];
            for(int i = 0; i < n; i++) {
                ordC[i] = new Item(i);  // ordenado crescente
                ordD[i] = new Item((n-1)-i);    // ordenado decrescente
                rand[i] = new Item(generator.nextInt(n)); // aleatórios
            }

            Heapsort.heapsort(ordC);
            out += "Elementos ORDENADOS EM ORDEM CRESCENTE - ";
            out += "Comparações realizadas: " + Heapsort.count + "\n";

            Heapsort.heapsort(ordD);
            out += "Elementos ORDENADOS EM ORDEM DECRESCENTE - ";
            out += "Comparações realizadas: " + Heapsort.count + "\n";

            Heapsort.heapsort(rand);
            out += "Elementos ALEATORIOS - ";
            out += "Comparações realizadas: " + Heapsort.count + "\n\n";
        }

        /*escreve a saída em um arquivo "pratica04.txt"*/
        try {
            FileWriter fp = new FileWriter("Heap_Saida.txt");
            fp.write(out);
            fp.close();
        } catch (IOException e) {
            System.out.println("ERRO:NAO FOI POSSIVEL CRIAR O ARQUIVO");
        }
    }
}
