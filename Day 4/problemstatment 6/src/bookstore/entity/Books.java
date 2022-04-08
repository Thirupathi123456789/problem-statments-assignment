package bookstore.entity;

public class Books { 
	int Book_id;
	String Book_name;
	String Author;
	int Price;
	public Books(int book_id, String book_name, String author, int price) {
		Book_id = book_id;
		Book_name = book_name;
		Author = author;
		Price = price;
	}
	public Books() {
		
	}
	public int getBook_id() {
		return Book_id;
	}
	public void setBook_id(int book_id) {
		Book_id = book_id;
	}
	public String getBook_name() {
		return Book_name;
	}
	public void setBook_name(String book_name) {
		Book_name = book_name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	
}
