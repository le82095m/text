package book;


class Book {
    private String name;
    private String author;
    private int price;
    private String type;
    private boolean state;

    public Book(String name, String author, int price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }
}


    class BookList{
        int size = 3;
        Book[] books = new Book[10];
        public BookList() {
            books[0] = new Book("三国演义","罗贯中",18,"名著");
            books[1] = new Book("西游记","吴承恩",18,"名著");
            books[2] = new Book("红楼梦","曹雪芹",18,"名著");
        }

        public Book getBooks(int pos) {
            return books[pos];
        }
        public void setBooks(Book book,int pos) {
            this.books[pos] = book;
        }

        public int getSize() {
            return size;
        }
        public void setSize(int size) {
            this.size = size;
        }
    }
