class Nodo<T extends Comparable<T>> {
    T valor;
    Nodo<T> izquierdo;
    Nodo<T> derecho;

    public Nodo(T valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}
