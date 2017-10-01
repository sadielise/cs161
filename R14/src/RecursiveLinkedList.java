
public class RecursiveLinkedList {

	private Node head;
	private int size;

	//constructor
	public RecursiveLinkedList(){
		head = null;
		size = 0;
	}

	//clear the list
	public void clear() {
		head = null;
	}

	//add method which uses a helper
	public void add(Object item) {
		head = addRecursive(head, item);
		size++;
	}

	//helper method for add
	private Node addRecursive(Node node, Object item) {

		if(size==0){
			head = new Node(item, null);
		}

		if(node == null)
			node = new Node(item, node);
		else
			node.setNext(addRecursive(node.getNext(), item));  		

		return node;
	} 

	public void add(Object item, int index) {
		addRecursive(head, item, index, 0);
		size++;
	}

	//helper method for index add
	private Node addRecursive(Node node, Object item, int index, int currentIndex) {

		if(size==0){
			node = new Node(item, null);
		}
		else if(index<0 || index>size)
			throw new IndexOutOfBoundsException("out of bounds!");
		else if(index == 0){
			node = new Node(item, head);
		}
		else if(currentIndex == index-1){
			node.setNext(new Node(item, node.getNext()));
		}

		else{
			currentIndex++;
			node = node.getNext();
			addRecursive(node, item, index, currentIndex);
		}
		size++;
		return node;
	} 

	public void remove(int index){
		head = removeRecursive(head, index, 0);
		size--;
	}

	private Node removeRecursive(Node node, int index, int currentIndex) {

		if(index<0 || index>size)
			throw new IndexOutOfBoundsException("out of bounds!");
		else if(index == 0){
			node = node.getNext();
		}
		else if(currentIndex == index-1){
			node.setNext(node.getNext().getNext());
		}
		else{
			removeRecursive(node.getNext(), index, ++currentIndex);
		}

		return node;
	} 

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String toString(){
		String s = "";
		Node curr = head;
		while(curr != null){
			s += curr.getItem().toString() + " ";
			curr = curr.getNext();
		}
		return s;
	}

	public static void main(String[] args) {

		RecursiveLinkedList list = new RecursiveLinkedList();
		list.add("Jane");
		list.add("Jane", 0);
		System.out.println(list);
		list.add("John");
		System.out.println(list);
		list.add("Jess");
		System.out.println(list);
		list.add("Jeremy", 1);
		System.out.println(list);
		list.add("Sadie", 3);
		System.out.println(list);

		list.remove(2);
		System.out.println(list);
		list.remove(2);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		

	}

}
