public class Node {
	private Integer data;
	private Node next, prev;

	public Node(int value) {
		data = value;
		prev = null;
		next = null;
	}

	public Node next() {
		return next;
	}
	public Node prev() {
		return prev;
	}
	public void setNext(Node other) {
		next = other;
	}
	public void setPrev(Node other) {
		prev = other;
	}
	public Integer getData() {
		return data;
	}
	public Integer setData(Integer i) {
		Integer x = data;
		data = i;
		return x;
	}
	public String toString() {
		return "" + data;
	}
}
