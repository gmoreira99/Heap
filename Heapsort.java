// Guilherme Moreira de Carvalho, 09/07/2021 - para Laboratório de Algoritmos e Estruturas de Dados II, 2021/1
// Classe Heapsort: ordena um vetor em um heap.

public class Heapsort {
    static int count;

    public static void heapsort(Item v[]) {
        Heap heap = new Heap(v);  // heap a ser ordenado
        int dir = v.length-1;     // fim do heap
        heap.constroi();
        while (dir > 1) { // até o começo do heap
        // troca o primeiro elemento com o último
          Item x = v[1];
          v[1] = v[dir];
          v[dir] = x;
          dir--;
          heap.refaz(1, dir);
        }
        count = heap.getCount();
    }
}