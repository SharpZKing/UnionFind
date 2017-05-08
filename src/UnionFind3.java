/**
 * Created by zjfsharp on 2017/5/8.
 * 元素值为最原始的根
 * 优化：基于 size 的优化, sz[i]代表以 i 为节点根的集合中元素的个数
 */
public class UnionFind3 {

    int[] parent;
    int[] sz;
    int count;

    public UnionFind3(int n){
        this.count = n;
        this.parent = new int[n];
        this.sz = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            sz[i] = 1;
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

        if( sz[pRoot] < sz[qRoot] ){
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else{
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }

}
