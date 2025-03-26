## Practical-4.1:

- Define two nested classes: Processor and RAM inside the outer class: CPU with following data members.

    **Data Members:**
    ````
    class CPU {
        double price;
        
        class Processor{ // nested class
            double cores;
            double catch()
            String manufacturer;
            double getCache()
            void displayProcesorDetail()
        }
        
        protected class RAM{ // nested protected class
            // members of protected nested class
            double memory;
            String manufacturer;
            Double clockSpeed;
            double getClockSpeed()
            void displayRAMDetail()
        }
    }
    ````
- Write appropriate Constructor and create instance of Outer and inner class and call the methods in main function.