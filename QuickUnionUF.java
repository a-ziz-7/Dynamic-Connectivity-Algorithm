public class QuickUnionUF {
    int[] connections;
    int[] sizes;

    // O(n)
    public QuickUnionUF(int n) {
        this.connections = new int[n];
        this.sizes = new int[n];
        for (int i = 0; i < n; i++) {
            this.connections[i] = i;
        }
    }

    private int root(int i) {
        while (i != this.connections[i]) {
            this.connections[i] = this.connections[this.connections[i]]; // flatening
            i = this.connections[i];
        }
        return i;
    }

    // unweighted
    // public void union(int value1, int value2) {
    //     this.connections[this.root(value1)] = this.root(value2);
    // }

    // weighted
    public void union(int value1, int value2) {
        int i = this.root(value1);
        int j = this.root(value2);
        if (i == j) {
            return;
        }         
        if (this.sizes[i] >= this.sizes[j]) {
            this.connections[j] = this.connections[i];
            this.sizes[j] += this.sizes[i];
        }else {
            this.connections[i] = this.connections[j];
            this.sizes[i] += this.sizes[j];
        }
    }

    public boolean connected(int value1, int value2) {
        return this.root(value1) == this.root(value2);
    }
}
