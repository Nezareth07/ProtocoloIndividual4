import java.util.*;

public class ArbolBinarioBusqueda<T extends Comparable<T>> {
    private Nodo<T> raiz;

    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    // INSERTAR
    public void insertar(T valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo<T> insertarRecursivo(Nodo<T> nodo, T valor) {
        if (nodo == null) {
            return new Nodo<>(valor);
        }

        if (valor.compareTo(nodo.valor) < 0) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor.compareTo(nodo.valor) > 0) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }

        return nodo;
    }

    // BUSCAR
    public boolean buscar(T valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(Nodo<T> nodo, T valor) {
        if (nodo == null) return false;
        if (valor.equals(nodo.valor)) return true;

        return valor.compareTo(nodo.valor) < 0
                ? buscarRecursivo(nodo.izquierdo, valor)
                : buscarRecursivo(nodo.derecho, valor);
    }

    // RECORRIDOS
    public List<T> inOrden() {
        List<T> resultado = new ArrayList<>();
        inOrdenRecursivo(raiz, resultado);
        return resultado;
    }

    private void inOrdenRecursivo(Nodo<T> nodo, List<T> resultado) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.izquierdo, resultado);
            resultado.add(nodo.valor);
            inOrdenRecursivo(nodo.derecho, resultado);
        }
    }

    public List<T> preOrden() {
        List<T> resultado = new ArrayList<>();
        preOrdenRecursivo(raiz, resultado);
        return resultado;
    }

    private void preOrdenRecursivo(Nodo<T> nodo, List<T> resultado) {
        if (nodo != null) {
            resultado.add(nodo.valor);
            preOrdenRecursivo(nodo.izquierdo, resultado);
            preOrdenRecursivo(nodo.derecho, resultado);
        }
    }

    public List<T> postOrden() {
        List<T> resultado = new ArrayList<>();
        postOrdenRecursivo(raiz, resultado);
        return resultado;
    }

    private void postOrdenRecursivo(Nodo<T> nodo, List<T> resultado) {
        if (nodo != null) {
            postOrdenRecursivo(nodo.izquierdo, resultado);
            postOrdenRecursivo(nodo.derecho, resultado);
            resultado.add(nodo.valor);
        }
    }

    public List<T> nivelOrden() {
        List<T> resultado = new ArrayList<>();
        if (raiz == null) return resultado;

        Queue<Nodo<T>> cola = new LinkedList<>();
        cola.offer(raiz);

        while (!cola.isEmpty()) {
            Nodo<T> actual = cola.poll();
            resultado.add(actual.valor);

            if (actual.izquierdo != null) cola.offer(actual.izquierdo);
            if (actual.derecho != null) cola.offer(actual.derecho);
        }
        return resultado;
    }

    // ALTURA
    public int altura() {
        return alturaRecursivo(raiz);
    }

    private int alturaRecursivo(Nodo<T> nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(alturaRecursivo(nodo.izquierdo),
                alturaRecursivo(nodo.derecho));
    }

    // BALANCE (OPCIONAL)
    public boolean estaBalanceado() {
        return estaBalanceadoRecursivo(raiz);
    }

    private boolean estaBalanceadoRecursivo(Nodo<T> nodo) {
        if (nodo == null) return true;

        int alturaIzq = alturaRecursivo(nodo.izquierdo);
        int alturaDer = alturaRecursivo(nodo.derecho);

        return Math.abs(alturaIzq - alturaDer) <= 1
                && estaBalanceadoRecursivo(nodo.izquierdo)
                && estaBalanceadoRecursivo(nodo.derecho);
    }

    // MÉTODOS PARA CALIFICACIONES
    public T minimo() {
        if (raiz == null) return null;
        return encontrarMinimo(raiz);
    }

    public T maximo() {
        if (raiz == null) return null;
        return encontrarMaximo(raiz);
    }

    private T encontrarMinimo(Nodo<T> nodo) {
        while (nodo.izquierdo != null) nodo = nodo.izquierdo;
        return nodo.valor;
    }

    private T encontrarMaximo(Nodo<T> nodo) {
        while (nodo.derecho != null) nodo = nodo.derecho;
        return nodo.valor;
    }

    public int contarEnRango(T min, T max) {
        return contarEnRangoRecursivo(raiz, min, max);
    }

    private int contarEnRangoRecursivo(Nodo<T> nodo, T min, T max) {
        if (nodo == null) return 0;

        int count = 0;
        if (nodo.valor.compareTo(min) >= 0 && nodo.valor.compareTo(max) <= 0) {
            count = 1;
        }

        if (nodo.valor.compareTo(min) > 0) {
            count += contarEnRangoRecursivo(nodo.izquierdo, min, max);
        }

        if (nodo.valor.compareTo(max) < 0) {
            count += contarEnRangoRecursivo(nodo.derecho, min, max);
        }

        return count;
    }
}