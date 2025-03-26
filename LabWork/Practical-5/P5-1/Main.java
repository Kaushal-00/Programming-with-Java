public class Main{
    public static void main(String[] args) {

        CPU cpu = new CPU(25000);

        // Create Processor object using CPU object
        CPU.Processor processor = cpu.new Processor(8, "Intel", 16);

        // Create RAM object using CPU object
        CPU.RAM ram = cpu.new RAM(16, "Corsair", 3.2);

        System.out.println("CPU Price: Rs. " + cpu.price);
        processor.displayProcessorDetail();
        ram.displayRAMDetail();
    }
}