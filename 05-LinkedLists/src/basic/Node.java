package basic;

class Node {
	int data;
	Node next;

	public Node(int data) {
		super();
		this.data = data;
		this.next = null;
	}
	@Override
	public String toString() {
		String other = (next == null) ? "" : next.toString();
		return data +" "+ other;
	}

}