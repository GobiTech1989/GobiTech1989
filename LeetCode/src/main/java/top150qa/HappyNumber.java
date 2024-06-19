package top150qa;

public class HappyNumber {

	public static void main(String[] args) {
		HappyNumber hn = new HappyNumber();
		int n = 2;
		boolean isHappy = hn.isHappy(n);
		System.out.println(isHappy);
	}
	
	public boolean isHappy(int n) {
		int slow = n;
        int fast = n;
        do {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));

        }while(fast != slow);

        return slow == 1;
    }
	
	int squareSum(int n) {
		int ans = 0;
	    while(n > 0) {
	        int rem = n % 10;
	        ans+=rem*rem;
	        n/=10;
	    }
	    return ans;
    }

}
