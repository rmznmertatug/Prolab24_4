public class Node implements Comparable<Node> {
    private int row;
    private int col;
    private int gValue;
  
    private Node parent;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
        this.gValue = 0;
        this.parent = null;
    }

    // Getters and setters
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getGValue() {
        return gValue;
    }

    public void setGValue(int gValue) {
        this.gValue = gValue;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.gValue, o.gValue);
    }
}