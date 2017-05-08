/**
 * Created by zjfsharp on 2017/5/8.
 * 元素值为最原始的根
 */
public class UnionFind2 {

    int[] parent;
    int count;

    public UnionFind2(int n){
        this.count = n;
        this.parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }

    public int size(){
        return this.count;
    }

    public int find(int p){ //找根
        if( p < 0 || p >= this.count ){
            return -1;
        }
        while( p!=parent[p] ){
            p = parent[p];
        }

        return p;
    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public void unionElements(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if( pRoot == qRoot ){
            return ;
        }

        parent[qRoot] = pRoot;
    }

}
