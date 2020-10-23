class Solution2 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        sum /= A.length;
        int count = 0;
        int temp = 0;
        for (int i = 0; i < A.length - 1; i++) {
            count += A[i];
            if (count == sum) {
                count = 0;
                temp++;
            }
        }
        return count == 0 && temp == 3;
    }
}
