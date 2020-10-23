class Solution1{
    public int findJudge(int N,int[][] trust){
        if(trust.length == 0){
            return N;
        }
        int[] inDegree = new int[N+1];
        int[] outDegree = new int [N+1];
        for(int[] path : trust){
            int start = path[0];
            int end = path[1];
            inDegree[start]++;
            outDegree[end]++;
        }
        for (int i = 0; i <= N ; i++) {
            if(inDegree[i] ==0 && outDegree[i] == N-1){
                return i;
            }
        }
        return -1;
    }
}
