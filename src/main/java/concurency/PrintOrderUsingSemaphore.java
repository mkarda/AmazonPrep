package concurency;

public class PrintOrderUsingSemaphore {

    public static void main(String[] args) {

        SemaphoredPrinter printer = new SemaphoredPrinter();

        new Thread(() -> {
            try {
                System.out.println("about to print 3");
                printer.third(() -> System.out.println("3"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("about to print 2");
                printer.second(() -> System.out.println("2"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("about to print 1");
                printer.first(() -> System.out.println("1"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
