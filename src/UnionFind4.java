/**
 * Created by zjfsharp on 2017/5/8.
 * 元素值为最原始的根
 * 优化：基于 rank 的优化, rank[i]表示以 i 为根的树的高度
 */
public class UnionFind4 {

    int[] parent;
    int[] rank;
    int count;

    public UnionFind4(int n){
        this.count = n;
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 1;
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

        if ( rank[pRoot] < rank[qRoot] ){
            parent[pRoot] = qRoot;
        }else if ( rank[pRoot] > rank[qRoot] ){
            parent[qRoot] = pRoot;
        }else{
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }

}
