import java.util.Random;

public class Main {
    public static void main(String[] args) {
        
        int size = 50;
        int ss = size*size;
        int pr = 60;
        int num = (int)(ss*(pr*1.0/100));
        Random r = new Random();
        Matrix m = new Matrix(size);;
        UF q = new UF(ss);
        
        int total_runs = 100;
        int runs = total_runs;

        int total_open = 0;
        double sum = 0;

        while (runs > 0){
            m = new Matrix(size);
            q = new UF(ss);
            total_open = 0;
            while (!q.connected(0, ss+1)){
                int x = r.nextInt(1,ss+1);
                while (m.array[x]==" ") {
                    x = r.nextInt(1,ss);
                }
                total_open += 1;
                m.open(x);
                q.open(m, x);
            }
            sum += total_open*1.0/ss;
            runs--;
        }

        System.out.println(100*sum/total_runs);
        
        m = new Matrix(size);;
        q = new UF(ss);
        for (int i = 0; i < num; i++){
            int x = r.nextInt(1,ss);
            while (m.array[x]==" ") {
                x = r.nextInt(1,ss);
            }
            m.open(x);
            q.open(m, x);
        }
        System.out.println(m);
        System.err.println(q.connected(0, ss+1));

    }
}