import java.util.*;
import java.io.*;
public class Main {
	static int[] parents;
	static int N;
	static int M;
	static int count = 0;
	static boolean vis[];
	static ArrayList<ArrayList<Integer>> a = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N =Integer.parseInt(st.nextToken()) ;
        M =Integer.parseInt(st.nextToken()) ;
        
        for(int i = 0 ; i<N ; i++) {
        	a.add(new ArrayList<>());
        }
        for(int i = 0 ; i<M ; i++) {
        	st = new StringTokenizer(bf.readLine());
        	int c = Integer.parseInt(st.nextToken()) ;
        	int b = Integer.parseInt(st.nextToken()) ;
        	if(!a.get(c).contains(b)) {
        		a.get(c).add(b);
        	}
        	if(!a.get(b).contains(c)) {
        		a.get(b).add(c);
        	}
        	
        }
        for(int i = 0 ; i<N ; i++) {
        	vis=new boolean[N];
        	dfs(i,0);
        
        if(count==1)break;
        }
        System.out.println(count);
        
    }
    static void dfs(int node,int depth) {

    	if(depth==5) {
    		int cnt=0;
    		for(int i = 0 ; i<N ; i++) {
    			if(vis[i])cnt++;
    		}
    		if(cnt==5) {
    		count =1;
    		return;}
    		
    	}
    	
    	if(!vis[node]) {
    		vis[node]=true;
    		for(int i=0; i<a.get(node).size(); i++) {

    			dfs(a.get(node).get(i),depth+1);
    			if(count==1) break;
    		}
    		vis[node]=false;
    	}else return;
    }
}
