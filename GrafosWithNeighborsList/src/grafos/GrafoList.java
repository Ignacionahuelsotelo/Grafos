package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrafoList {
    private List<Set<Integer>> vecinos;

    public GrafoList(int vertices) {
        vecinos = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            vecinos.add(new HashSet<>()); // Cada vértice tiene un conjunto de vecinos
        }
    }

    public void agregarArista(int i, int j) {
        verificarVertice(i);
        verificarVertice(j);

        vecinos.get(i).add(j);
        vecinos.get(j).add(i);
    }

    public void eliminarArista(int i, int j) {
        verificarVertice(i);
        verificarVertice(j);

        vecinos.get(i).remove(j);
        vecinos.get(j).remove(i);
    }

    public boolean existeArista(int i, int j) {
        verificarVertice(i);
        verificarVertice(j);

        return vecinos.get(i).contains(j);
    }

    public int tamano() {
        return vecinos.size();
    }

    public Set<Integer> vecinos(int i) {
        verificarVertice(i);
        return new HashSet<>(vecinos.get(i));
    }

    public void agregarVertice() {
        vecinos.add(new HashSet<>()); // O(1) amortizado
    }

    private void verificarVertice(int i) {
        if (i < 0 || i >= vecinos.size()) {
            throw new IllegalArgumentException("El vértice debe estar entre 0 y " + (vecinos.size() - 1) + ": " + i);
        }
    }
}
