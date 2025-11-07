import java.util.*;

public class AnalizadorCalificaciones {
    public static void main(String[] args) {
        System.out.println("=== ANALIZADOR DE CALIFICACIONES CON ÁRBOL BINARIO ===\n");

        // Crear árbol
        ArbolBinarioBusqueda<Double> arbol = new ArbolBinarioBusqueda<>();

        // Insertar calificaciones
        double[] calificaciones = {85.5, 92.0, 78.5, 65.0, 88.5, 95.0, 72.5, 81.0, 90.5, 68.0};

        System.out.println("Calificaciones insertadas:");
        for (double calif : calificaciones) {
            arbol.insertar(calif);
            System.out.printf("%.1f ", calif);
        }
        System.out.println("\n");

        // Recorridos
        System.out.println("IN-ORDEN (ordenadas): " + arbol.inOrden());
        System.out.println("PRE-ORDEN: " + arbol.preOrden());
        System.out.println("POST-ORDEN: " + arbol.postOrden());
        System.out.println("POR NIVELES: " + arbol.nivelOrden());
        System.out.println();

        // Análisis
        System.out.println("=== ANÁLISIS ===");
        System.out.printf("Mínima: %.1f\n", arbol.minimo());
        System.out.printf("Máxima: %.1f\n", arbol.maximo());
        System.out.printf("Altura del árbol: %d\n", arbol.altura());
        System.out.printf("¿Balanceado? %s\n", arbol.estaBalanceado());
        System.out.println();

        // Búsquedas
        System.out.println("=== BÚSQUEDAS ===");
        double[] buscar = {85.5, 60.0, 95.0, 72.5};
        for (double calif : buscar) {
            System.out.printf("¿%.1f? %s\n", calif, arbol.buscar(calif) ? "SÍ" : "NO");
        }
        System.out.println();

        // Rangos
        System.out.println("=== DISTRIBUCIÓN ===");
        System.out.printf("Reprobados (<70): %d\n", arbol.contarEnRango(0.0, 69.9));
        System.out.printf("Aprobados (70-79): %d\n", arbol.contarEnRango(70.0, 79.9));
        System.out.printf("Buenos (80-89): %d\n", arbol.contarEnRango(80.0, 89.9));
        System.out.printf("Excelentes (90-100): %d\n", arbol.contarEnRango(90.0, 100.0));
        System.out.println();

        // Comparación con TreeSet
        System.out.println("=== COMPARACIÓN CON TreeSet ===");
        TreeSet<Double> treeSet = new TreeSet<>();
        for (double calif : calificaciones) treeSet.add(calif);

        System.out.println("TreeSet: " + treeSet);
        System.out.println("Mínimo TreeSet: " + treeSet.first());
        System.out.println("Máximo TreeSet: " + treeSet.last());

        System.out.println("\n=== VENTAJAS/LIMITACIONES ===");
        System.out.println("MI IMPLEMENTACIÓN:");
        System.out.println("✓ Aprendizaje de estructura interna");
        System.out.println("✓ Control total del código");
        System.out.println("✗ Menos optimizada");

        System.out.println("\nTreeSet:");
        System.out.println("✓ Muy optimizado");
        System.out.println("✓ Probado y confiable");
        System.out.println("✗ Caja negra");
    }
}