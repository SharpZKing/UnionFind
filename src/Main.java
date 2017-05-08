import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("并查集算法示例：");
        int n = 100000;

        UnionFind uf1 = new UnionFind(n);
        UnionFind2 uf2 = new UnionFind2(n);
        UnionFind3 uf3 = new UnionFind3(n);
        UnionFind4 uf4 = new UnionFind4(n);

        int a, b;

        long start = System.currentTimeMillis();
        for(int i=0; i<n; i++){
            a = new Random().nextInt(n);
            b = new Random().nextInt(n);
            uf1.unionElements(a,b);
        }
        long end = System.currentTimeMillis();
        System.out.println("UnionFind1: " + (end - start));

        start = System.currentTimeMillis();
        for(int i=0; i<n; i++){
            a = new Random().nextInt(n);
            b = new Random().nextInt(n);
            uf2.unionElements(a,b);
        }
        end = System.currentTimeMillis();
        System.out.println("UnionFind2: " + (end - start));

        start = System.currentTimeMillis();
        for(int i=0; i<n; i++){
            a = new Random().nextInt(n);
            b = new Random().nextInt(n);
            uf3.unionElements(a,b);
        }
        end = System.currentTimeMillis();
        System.out.println("UnionFind3: " + (end - start));

        start = System.currentTimeMillis();
        for(int i=0; i<n; i++){
            a = new Random().nextInt(n);
            b = new Random().nextInt(n);
            uf4.unionElements(a,b);
        }
        end = System.currentTimeMillis();
        System.out.println("UnionFind4: " + (end - start));
    }


}
