/**
 * Union Find (Disjoint Set) data structure implementation
 * Time Complexity:
 * - Construction: O(n)
 * - Find: O(α(n)) amortized - α is the inverse Ackermann function (practically constant)
 * - Union: O(α(n)) amortized
 * - Connected: O(α(n)) amortized
 * Space Complexity: O(n)
 */
public class UnionFind {
    private int[] parent;  // parent[i] = parent of i
    private int[] rank;    // rank[i] = rank of subtree rooted at i (never decreases)
    private int count;     // number of components

    /**
     * Initialize Union Find data structure with n elements (0 to n-1)
     *
     * @param n number of elements
     */
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // Each element is initially its own parent
            rank[i] = 0;    // Initially, all elements have rank 0
        }
    }

    /**
     * Recursive find implementation with full path compression
     *
     * @param p the element
     * @return the representative of p
     */
    public int find(int p) {
        validate(p);
        if (p == parent[p]) {
            return p;
        }
        return parent[p] = find(parent[p]);  // Full path compression
    }

    /**
     * Check if elements p and q are in the same component
     *
     * @param p first element
     * @param q second element
     * @return true if p and q are in the same component; false otherwise
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Join components containing elements p and q
     *
     * @param p first element
     * @param q second element
     * @return true if p and q were not already in the same component; false otherwise
     */
    public boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return false;

        // Make root of smaller rank point to root of larger rank
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;  // Increase rank if same
        }
        count--;  // Decrease the number of components
        return true;
    }

    /**
     * Returns the number of disjoint sets
     *
     * @return number of components
     */
    public int count() {
        return count;
    }

    /**
     * Validate that p is a valid element
     *
     * @param p element to validate
     */
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public static void main(String[] args) {
        // Create a UnionFind data structure with 10 elements (0-9)
        UnionFind uf = new UnionFind(10);

        System.out.println("Initial number of components: " + uf.count());

        // Perform some union operations
        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(4, 5);
        uf.union(6, 7);
        uf.union(8, 9);
        System.out.println("After 5 unions, components: " + uf.count());

        // Connect some components
        uf.union(1, 3);  // Connects the first and second components
        uf.union(5, 7);  // Connects the third and fourth components
        System.out.println("After 2 more unions, components: " + uf.count());

        // Check connectivity
        System.out.println("Are 0 and 3 connected? " + uf.connected(0, 3));
        System.out.println("Are 4 and 7 connected? " + uf.connected(4, 7));
        System.out.println("Are 2 and 8 connected? " + uf.connected(2, 8));

        // Find representatives
        System.out.println("Representative of 2: " + uf.find(2));
        System.out.println("Representative of 6: " + uf.find(6));
    }
}
