// Guilherme Moreira de Carvalho, 09/07/2021 - para Laboratório de Algoritmos e Estruturas de Dados II, 2021/1
// Classe Heap: constroi um heap a partir de um vetor; possui um atributo Item[] v ordenável e um atributo int "count"
// para contar as comparações; refaz e constroi o heap.

public class Heap {
    private Item v[];

    private int count;

    public Heap(Item v[]) { // Cria uma fila de prioridades vazia
        this.v = v;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void refaz(int esq, int dir) {
    // ajusta "esq" para atender o requisito de um heap (pai > filho)
        Item x = this.v[esq];   // posição corrente
        int j = esq*2;          // filho à esquerda
        while (j <= dir) {  // até o último descendente
            if (j<dir && this.v[j].compara(this.v[j+1])<0) {
            // se a posição é valida e o maior filho está a direita
            // j passa a refenciar o filho à direita
                count++;
                j++;
            }
            if (x.compara(this.v[j]) >= 0) {
            // se a posição corrente for maior ou igual ao filho
            // não altera
                count++;
                break;
            }
            // senão, troca o nó corrente com o maior filho
            this.v[esq] = this.v[j];
            esq = j;
            j = esq*2;
        }
        this.v[esq] = x;
    }

    public void constroi() {
    // refaz o heap do primeiro elemento possivelmente deslocado
    // até o começo do heap
        int n = this.v.length-1;
        int esq = n/2 + 1;
        while (esq > 1) {
            esq--;
            this.refaz(esq, n);
        }
    }
}