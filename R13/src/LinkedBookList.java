

public class LinkedBookList {

	private BookNode head;
	private int size;

	public LinkedBookList(){
		head = null;
		size = 0;
	}

	public int size(){
		return size;
	}

	//adds a book to the end of the linked list
	public void add(Book b){

		if(size==0){
			head = new BookNode(b, null);
		}

		else{
			BookNode curr = head;
			for(int i = 0; i < size -1; i++){
				curr= curr.getNext();
			}
			curr.setNext(new BookNode(b, null));

		}
		size++;
	}

	//adds a book at the specific index, or at the end if index is greater than size
	public void add(Book b, int index){

		if(index<0 || index>size)
			throw new IndexOutOfBoundsException("out of bounds!");
		if(index == 0){
			head = new BookNode(b, head);
		}
		else{
			BookNode curr = head;
			for(int i = 0; i < index-1; i++){
				curr = curr.getNext();
			}

			curr.setNext(new BookNode(b, curr.getNext()));
		}
		size++;
	}

	//removes a book and returns it, or returns null if it is not present
	public Book remove(Book b){

		boolean found = false;
		BookNode curr = head;
		int index = 0;

		for(index = 1; index < size; index++){

			if(curr.getBook().equals(b) == true){
				found = true;
				break;
			}

			else{
				curr = curr.getNext();
			}
		}


		if(index == size && found == false){

			return null;
		}

		else{

			if(index == 0){
				head = head.getNext();
			}
			else{
				for(int i = 0; i < index-1; i++){
					curr = curr.getNext();
				}

				b = curr.getNext().getBook();
				curr.setNext(curr.getNext().getNext());}
		}

		return b;
	}

	//removes a book at a specific index and returns it, 
	//or returns null if it is not present
	public Book remove(int index){

		Book b = null;

		if(index<0 || index>size)
			return null;
		if(index == 0){
			b = head.getBook();
			head = head.getNext();
			size--;
			return b;
		}
		else{
			BookNode curr = head;
			for(int i = 0; i < index-1; i++){
				curr = curr.getNext();
			}

			b = curr.getNext().getBook();
			curr.setNext(curr.getNext().getNext());
		}

		size--;
		return b;
	}

	//returns the total number of pages in the linked list
	public int totalPages(){

		int total = 0;
		BookNode curr = head;
		for(int i = 0; i < size; i++){
			total += curr.getBook().getNumPages();
			curr = curr.getNext();
		}
		return total;
	}

	public String toString(){

		String res = "";

		BookNode curr = head;
		while(curr != null){
			res += curr.getBook().toString() + "\n";
			curr = curr.getNext();
		}

		return res;
	}

}




