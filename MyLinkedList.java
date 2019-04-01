public class MyLinkedList {
	private int size;
	private Node start, end;

	public MyLinkedList() {
		size = 0;
		start = null;
		end = null;
	}

	public int size() {
		return size;
	}
	public boolean add(int value) {
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


	public Integer get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index is out of range");
		}
		return getNthNode(index).getData();
	}
	public Integer set(int index, Integer value) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index is out of range");
		}
		Integer x = getNthNode(index).getData();
		getNthNode(index).setData(value);
		return x;
	}
	public boolean contains(Integer value) {
		Node current = start;
		while (current != null) {
			if (current.getData() == value) {
				return true;
			}
			current = current.next();
		}
		return false;
	}
	public int indexOf(Integer value) {
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
	public void add(int index, Integer value) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("index is out of range");
		}
		Node addition = new Node(value);
		if (index != size()) {
			getNthNode(index).setPrev(addition);
			addition.setNext(getNthNode(index));
		}
		if (index != 0) {
			getNthNode(index-1).setNext(addition);
			addition.setPrev(getNthNode(index-1));
		} else {
			start = addition;
		}
		size++;
	}
	public Integer remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index is out of range");
		}
		Integer x = getNthNode(index).getData();
		if (index == size()-1) {
			getNthNode(index-1).setNext(getNthNode(index+1).next());
		}
		if (index == 0) {
			getNthNode(index+1).setPrev(getNthNode(index-1).prev());
		} else {
			getNthNode(index-1).setNext(getNthNode(index+1));
			getNthNode(index+1).setPrev(getNthNode(index-1));
		}
		size--;
		return x;
	}
	public boolean remove(Integer value) {
		int index = indexOf(value);
		if (index == -1) {
			return false;
		}
		if (index != 0) {
			getNthNode(index-1).setNext(getNthNode(index+1));
		}
		if (index != size()-1) {
			getNthNode(index+1).setPrev(getNthNode(index-1));
		}
		size--;
		return true;
	}
	public void extend(MyLinkedList other){
    //in O(1) runtime, move the elements from other onto the end of this
    //The size of other is reduced to 0
    //The size of this is now the combined sizes of both original lists
		end.setNext(other.start);
		other.start.setPrev(end);
		end = other.end;
		size += other.size();
		other.size = 0;
  }
}
