public class UncaughtException {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("International Exception");
            }
        });

        thread.setName("Misbehave thread");
        /*
        This handler will be called if an exception was thrown inside the thread and did not get caught
        anywhere. In this case it would be a place where we could clean up some resource or log
        additional data to enable us trouble shoot this issue.
         */
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread: " + t.getName()
                        + " the error is " + e.getMessage());
            }
        });
        thread.start();

    }
}
