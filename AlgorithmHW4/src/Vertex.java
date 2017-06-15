import java.util.ArrayList;

public class Vertex {

	public String name;
	public ArrayList<Edge> edges;
	public ArrayList<Book> books;
	
	

	public Vertex(String name) {
		this.name = name;
		edges = new ArrayList<Edge>();
		books = new ArrayList<Book>();
	}

	public void addEdges(Edge edge) {
		edges.add(edge);
	}
	public void addBook(Book book){
		books.add(book);
	}
	/*public void print(){//deneme
		for(int i=0;i<books.size();i++){
			System.out.println(books.get(i).value);
		}
	}*/

	
}
