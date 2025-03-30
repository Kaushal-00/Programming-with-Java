public class GenericStack<T> {
    T[] stack;
    int top = -1;
    int size;

    @SuppressWarnings("unchecked")
    GenericStack(int size) {
        this.size = size;
        stack = (T[]) new Object[this.size]; // Generic array workaround
    }

    void push(T element) {
        if (isFull()) {
            System.out.println("Stack Overflow!");
            return;
        } else {
            stack[++top] = element;
            System.out.println("Pushed: " + element);
        }
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return;
        } else {
            top--;
        }
    }

    T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        } else {
            System.out.println("Top element: " + stack[top]);
            return null;
        }
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == size - 1;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}
