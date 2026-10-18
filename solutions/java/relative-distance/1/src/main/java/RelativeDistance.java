import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class RelativeDistance {

    // Grafo: cada persona -> conjunto de personas conectadas directamente a ella.
    private final Map<String, Set<String>> graph = new HashMap<>();

    RelativeDistance(Map<String, List<String>> familyTree) {
        // Recorremos cada entrada: padre -> lista de hijos.
        for (Map.Entry<String, List<String>> entry : familyTree.entrySet()) {
            String parent = entry.getKey();
            List<String> children = entry.getValue();

            for (String child : children) {
                connect(parent, child); // conexión padre <-> hijo

                for (String sibling : children) {
                    if (!sibling.equals(child)) {
                        connect(child, sibling); // conexión hermano <-> hermano
                    }
                }
            }
        }
    }

    // Conecta a dos personas en ambos sentidos.
    private void connect(String a, String b) {
        graph.computeIfAbsent(a, k -> new HashSet<>()).add(b);
        graph.computeIfAbsent(b, k -> new HashSet<>()).add(a);
    }

    int degreeOfSeparation(String personA, String personB) {
        // Si alguna no existe en los datos, no hay relación conocida.
        if (!graph.containsKey(personA) || !graph.containsKey(personB)) {
            return -1;
        }

        Map<String, Integer> distance = new HashMap<>(); // persona -> distancia desde personA
        Queue<String> queue = new ArrayDeque<>();        // personas pendientes de explorar

        distance.put(personA, 0);
        queue.add(personA);

        while (!queue.isEmpty()) {
            String current = queue.poll(); // saca la primera de la fila

            if (current.equals(personB)) {
                return distance.get(current); // llegamos: esta es la distancia mínima
            }

            for (String neighbor : graph.get(current)) {
                if (!distance.containsKey(neighbor)) { // solo si no la hemos visitado
                    distance.put(neighbor, distance.get(current) + 1);
                    queue.add(neighbor);
                }
            }
        }
        return -1; // se agotó la fila sin encontrar a personB
    }
}