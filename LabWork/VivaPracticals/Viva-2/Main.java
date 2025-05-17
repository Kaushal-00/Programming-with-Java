class PrimeNumbers extends Thread {
    int checkpoint;

    PrimeNumbers(int checkpoint) {
        this.checkpoint = checkpoint;
    }

    public void run() {
        System.out.println("Thread started for checkpoint: " + checkpoint);
    }
}

public class Main {

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        for (int num = 2; num <= 10000; num++) {

            if (num % 1000 == 0) {
                PrimeNumbers t = new PrimeNumbers(num);
                t.start();
            }

            if (isPrime(num)) {
                System.out.println("Prime Number is: " + num);
            }
        }
    }
}
