package section3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Blocking Task
        /*
        Thread thread= new Thread(new BlockingTask());
        thread.start();
        thread.interrupt();
         */

        // LongComputationTask
       /* Thread thread = new Thread(new LongComputationTask(new BigInteger("20000"), new BigInteger("10000000000000")));
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        */

        // Join
        List<Long> inputNumbers = Arrays.asList(10000000L, 3435L, 35435L, 2324L, 4656L, 23L, 2435L, 5566L);
        List<Join> threads = new ArrayList<>();

        for (long inputNumber : inputNumbers) {
            threads.add(new Join(inputNumber));
        }
        for (Thread thread : threads) {
            thread.setDaemon(true);
            thread.start();
        }
        // main thread to wait untill all other join threads are finished
        for (Thread thread : threads) {
            thread.join(2000);
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            Join joinThread = threads.get(i);
            if (joinThread.isFinished()) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + joinThread.getResult());
            } else {
                System.out.println("The calculation for : " + inputNumbers.get(i) + " is still in progress");
            }
        }
    }
}
