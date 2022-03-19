public class Vertex implements Comparable<Vertex>{
    String label;
    Integer withCost = null;

    public Vertex(String label) {
        this.label = label;
    }

    public Vertex(Integer withCost, String label) {
        this.label = label;
        this.withCost = withCost;
    }

    public void setWithCost(Integer withCost) {
        this.withCost = withCost;
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.withCost > o.withCost) {
            return 1;
        } else if (this.withCost < o.withCost) {
            return -1;
        } else {
            return 0;
        }
    }
}
