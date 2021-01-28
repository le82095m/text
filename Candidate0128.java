import java.util.HashMap;

interface Vote{
    int AddCandidate(char[] charCandidate);
    void VoteCandidate(char[] charCandidate);
    int GetVoteResult(char[] charCandidate);
    void clean();
}
public class Candidate implements Vote{
    public static HashMap<char[],Integer> map = new HashMap<>();

    @Override
    public int AddCandidate(char[] charCandidate) {
        if(charCandidate == null){
            return 0;
        }
        if(map.containsKey(charCandidate)){
            return 0;
        }else{
            map.put(charCandidate,0);
            return 1;
        }
    }

    @Override
    public void VoteCandidate(char[] charCandidate) {
        if(charCandidate == null){
            return;
        }
        int count = map.get(charCandidate);
        map.put(charCandidate,count+1);
    }

    @Override
    public int GetVoteResult(char[] charCandidate) {
        if(charCandidate == null){
            return 0;
        }
        return map.get(charCandidate);
    }

    @Override
    public void clean() {
        map.clear();
    }
}