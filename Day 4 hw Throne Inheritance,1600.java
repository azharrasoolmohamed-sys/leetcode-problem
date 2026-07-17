import java.util.*;

class ThroneInheritance {
    private final String king;
    private final Map<String, List<String>> familyTree;
    private final Set<String> dead;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.familyTree = new HashMap<>();
        this.dead = new HashSet<>();
        this.familyTree.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        // Initialize parent's children list if not already present
        familyTree.putIfAbsent(parentName, new ArrayList<>());
        // Add child to parent's children list
        familyTree.get(parentName).add(childName);
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String current, List<String> order) {
        // If the current person is alive, add them to the order list
        if (!dead.contains(current)) {
            order.add(current);
        }
        
        // Traverse the children of the current person
        List<String> children = familyTree.get(current);
        if (children != null) {
            for (String child : children) {
                dfs(child, order);
            }
        }
    }
}
