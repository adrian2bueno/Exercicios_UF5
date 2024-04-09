public class MyCalculator {
    public long power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("Ni n ni p poden ser negatius.");
        } else if (n == 0 && p == 0) {
            throw new Exception("Ni n ni p poden ser zero.");
        } else {
            return (long) Math.pow(n, p);
        }
    }
}


