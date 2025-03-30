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
            System.out.println("Stack Overflow! Cannot push " + element);
            return;
        } else {
            stack[++top] = element;
            System.out.println("Pushed: " + element);
        }
    }

    T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return null;
        } else {
            return stack[top--];
        }
    }

    T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        } else {
            return stack[top];
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
