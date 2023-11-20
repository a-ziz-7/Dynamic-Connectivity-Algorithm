public class QuickFindUF {
    int[] connections;

    // O(n)
    public QuickFindUF(int n) {
        this.connections = new int[n];
        for (int i = 0; i < n; i++) {
            this.connections[i] = i;
        }
    }

    // O(n)
    public void union(int value1, int value2) {
        if (this.connected(value1, value2)) {
            return;
        }
        int value = this.connections[value1];
        for (int i = 0; i < this.connections.length; i++) {
            if (this.connections[i] == value) {
                this.connections[i] = value2;
            }
        }
    }

    // quick find algorithm
    // O(1)
    public boolean connected(int value1, int value2) {
        return this.connections[value1] == this.connections[value2];
    }
}
