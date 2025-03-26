public class CPU {

    double price;

    public CPU(double price) {
        this.price = price;
    }

    class Processor {
        double cores;
        String manufacturer;
        double cache;

        Processor(double cores, String manufacturer, double cache) {
            this.cores = cores;
            this.manufacturer = manufacturer;
            this.cache = cache;
        }

        double getCache() {
            return cache;
        }

        void displayProcessorDetail() {
            System.out.println("Processor Details:");
            System.out.println("Cores: " + cores);
            System.out.println("Manufacturer: " + manufacturer);
            System.out.println("Cache: " + cache + " MB");
        }
    }

    protected class RAM {
        double memory;
        String manufacturer;
        double clockSpeed;

        RAM(double memory, String manufacturer, double clockSpeed) {
            this.memory = memory;
            this.manufacturer = manufacturer;
            this.clockSpeed = clockSpeed;
        }

        double getClockSpeed() {
            return clockSpeed;
        }

        void displayRAMDetail() {
            System.out.println("RAM Details:");
            System.out.println("Memory: " + memory + " GB");
            System.out.println("Manufacturer: " + manufacturer);
            System.out.println("Clock Speed: " + clockSpeed + " GHz");
        }
    }
}