public class Matrix {

    String[] array;
    int size;

    public Matrix(int n) {
        this.array = new String[n*n+2];
        this.size = n;
        for (int i = 0; i < n*n+2; i++) {
            this.array[i] = "X";
        }
    }

    public void open(int i) {
        this.array[i] = " ";
    }

    public String toString(){
        String repr = "";
        String curr = "|";
        for (int i = 0; i < this.size; i++) {
            for (int j = 1; j <= this.size; j++) {
                curr += this.array[i*this.size+j];
            }
            repr += curr + "|\n";
            curr = "|";
        }
        return repr;
    }
}