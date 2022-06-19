package section3;

import java.math.BigInteger;

public class Join extends Thread {

    // List<Long> inputNumbers = Arrays.asList(0L, 3435L, 35435L, 2324L, 4656L, 23L, 2435L, 5566L);

    private Long inputNumber;
    private BigInteger result = BigInteger.ZERO;
    private boolean isFinished = false;

    public Join(long inputNumber) {
        this.inputNumber = inputNumber;
    }

    @Override
    public void run() {
        this.result = factorial(inputNumber);
        this.isFinished = true;
    }

    public BigInteger factorial(long n) {
        BigInteger tempResult = BigInteger.ONE;
        for (long i = n; i > 0; i--) {
            tempResult = tempResult.multiply(new BigInteger(Long.toString(i)));
        }
        return tempResult;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public BigInteger getResult() {
        return result;
    }
}
