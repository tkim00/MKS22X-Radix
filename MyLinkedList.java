public class MyLinkedList<E>{

	private class Node{
		private E data;
		private Node next, prev;

		public Node(E value) {
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
		public E getData() {
			return data;
		}
		public E setData(E i) {
			E x = data;
			data = i;
			return x;
		}
		public String toString() {
			return "" + data;
		}
	}


	private int size;
	private Node start, end;
	@SuppressWarnings("unchecked")

	public MyLinkedList() {
		size = 0;
		start = null;
		end = null;
	}

	public int size() {
		return size;
	}
	public boolean add(E value) {
		Node addition = new Node(value);
		if (size() == 0) {
			start = addition;
			end = addition;
		} else {
			addition.setPrev(end);
			end.setNext(addition);
			end = addition;
		}
		size++;
		return true;
	}
	public String toString() {
		Node current = start;
		//Node current = end;
		String result = "[";
		while (current != null) {
			//System.out.println("success");
			result += current.getData();
			if (current.next() != null) {
			//if (current.prev() != null) {
				result+=", ";
			}
			current = current.next();
			//current = current.prev();
		}
		result += "]";
		return result;
	}
	public void clear() {
		size = 0;
		start = null;
		end = null;
	}

	private Node getNthNode(int n) {
		if (n < 0 || n >= size) {
			return null;
		}
		Node current = start;
		for (int c = 0; c < n; c++) {
			current = current.next();
		}
		return current;
	}


	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index is out of range");
		}
		return (E)getNthNode(index).getData();
	}
	public E set(int index, E value) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index is out of range");
		}
		E x = (E)getNthNode(index).getData();
		getNthNode(index).setData(value);
		return x;
	}
	public boolean contains(E value) {
		Node current = start;
		while (current != null) {
			if (current.getData() == value) {
				return true;
			}
			current = current.next();
		}
		return false;
	}
	public int indexOf(E value) {
		Node current = start;
		int c = 0;
		while (current != null) {
			if (current.getData() == value) {
				return c;
			}
			current = current.next();
			c++;
		}
		return -1;
	}
	public E removeFront() {
		E element = (E)start.getData();
		start = start.next();
		size--;
		return element;
	}
	// public boolean remove(E value) {
	// 	 index = indexOf(value);
	// 	if (index == -1) {
	// 		return false;
	// 	}
	// 	if (index != 0) {
	// 		getNthNode(index-1).setNext(getNthNode(index+1));
	// 	}
	// 	if (index != size()-1) {
	// 		getNthNode(index+1).setPrev(getNthNode(index-1));
	// 	}
	// 	size--;
	// 	return true;
	// }
	public void extend(MyLinkedList<E> other){
    //in O(1) runtime, move the elements from other onto the end of this
    //The size of other is reduced to 0
    //The size of this is now the combined sizes of both original lists
		if (size() == 0) {
			start = other.start;
			end = other.end;
		} else {
			end.setNext(other.start);
			other.start.setPrev(end);
			end = other.end;
		}
		size += other.size();
		other.clear();
  }
}
