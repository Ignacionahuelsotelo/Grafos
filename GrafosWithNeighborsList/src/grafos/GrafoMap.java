package grafos;

import java.util.*;

public class GrafoMap {
    private Map<Integer, Set<Integer>> vecinos;

    public GrafoMap(int vertices) {
        vecinos = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            vecinos.put(i, new HashSet<>());
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

    private void verificarVertice(int i) {
        if (i < 0)
            throw new IllegalArgumentException("El vértice no puede ser negativo: " + i);

        if (!vecinos.containsKey(i))
            throw new IllegalArgumentException("El vértice no existe en el grafo: " + i);
    }
}