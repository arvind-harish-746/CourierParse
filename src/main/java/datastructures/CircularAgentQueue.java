package datastructures;

// Custom circular array based FIFO queue used to assign agents in order
public class CircularAgentQueue {
    private String[] items;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularAgentQueue(int capacity) {
        this.capacity = capacity;
        this.items = new String[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(String agentId) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        // Advance rear index with wraparound to the start of array when reaching capacity
        rear = (rear + 1) % capacity;
        items[rear] = agentId;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        String value = items[front];
        // Advance front index with wraparound to the start of array when reaching capacity
        front = (front + 1) % capacity;
        size--;
        return value;
    }
}
