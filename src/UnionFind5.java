/**
 * Created by zjfsharp on 2017/5/8.
 * 元素值为最原始的根
 * 优化：基于路径压缩的优化
 */
public class UnionFind5 {

    int[] parent;
    int[] rank;
    int count;

    public UnionFind5(int n){
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
            parent[p] = parent[parent[p]]; //基于路径压缩的优化, 即对路径进行2步压缩
            p = parent[p];
        }

        //继续优化，但是建议不用
        /*if( p != parent[p] ){
            parent[p] = find(parent[p]);
        }
        return parent[p];*/

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
