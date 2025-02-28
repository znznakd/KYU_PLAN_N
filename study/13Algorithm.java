public class Main {
    public static void main(String[] args) {
        // 내림차순
        PriorityQueue<Node> pq1 = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        pq1.add(new Node(1, 1)); pq1.add(new Node(2, 3)); pq1.add(new Node(3, 2));
        while (!pq1.isEmpty()) {
            System.out.println(pq1.peek().getIndex() + " " + pq1.poll().getValue());
        }
        /*
        2 3
        3 2
        1 1
        */

        PriorityQueue<Node> pq2 = new PriorityQueue<>();
        pq2.add(new Node(1, 1)); pq2.add(new Node(2, 3)); pq2.add(new Node(3, 2));
        while (!pq2.isEmpty()) {
            System.out.println(pq2.peek().getIndex() + " " + pq2.poll().getValue());
        }
        /*
        2 3
        3 2
        1 1
        */
        return;
    }
}

class Node implements Comparable<Node> {
    private int index;
    private int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Node newNode) {
        return newNode.value - value; // 내림차순
        return value - newNode.value; // 오름차순
    }
}
