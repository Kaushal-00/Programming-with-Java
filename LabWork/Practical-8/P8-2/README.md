## Practical-8.2:

- Assume one class Queue that defines queue of fix size says 15.
- Assume one class Producer which implements Runnable, having priority NORM_PRIORITY +1.
- One more class Consumer implements Runnable, having priority NORM_PRIORITY -1.
- Class TestThread is having main method with maximum priority, which creates 1 thread for producer and 2 threads for consumer.
- Producer produces number of elements and put on the queue. when queue becomes full it notifies other threads.
- Consumer consumes number of elements and notifies other thread when queue become
empty.