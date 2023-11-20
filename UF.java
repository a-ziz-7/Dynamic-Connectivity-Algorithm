public class UF { // Union Find
    int[] connections;
    int[] sizes;
    int size;

    public UF(int n) {
        this.connections = new int[n+2];
        this.sizes = new int[n+2];
        this.size = (int)Math.pow(n,0.5);
        for (int i = 0; i < n+2; i++) {
            this.connections[i] = i;
        }
        for (int i = 1; i <= this.size; i++) {
            this.union(0, i);
            // System.err.println(0 + " " + (i));
            this.union(n+1, n+1-i);
            // System.err.println(n+1 + " " + (n+1-i));
            // System.err.println(Arrays.toString(this.connections));
        }
    }

    public void open(Matrix m, int x) {
        int o1 = x%this.size!=1 && m.array[x-1] != "X" ? x-1:x;
        int o2 = x%this.size!=0 && m.array[x+1] != "X"? x+1:x;
        int o3 = x-this.size>0 && m.array[x-this.size>0 ? x-this.size:x] != "X"? x-this.size:x;
        int o4 = x+this.size<this.sizes.length-2 && m.array[x+this.size<this.sizes.length-2 ? x+this.size:x] != "X"? x+this.size:x;
        int[] adj = {o1,o2,o3,o4};
        // System.out.print(m);
        // System.err.println(x + "    " + Arrays.toString(adj)+"\n");
        for (int iter : adj) {
            this.union(x, iter);
        }
    }

    private int root(int i) {
        while (i != this.connections[i]) {
            this.connections[i] = this.connections[this.connections[i]]; // flatening
            i = this.connections[i];
        }
        return i;
    }

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