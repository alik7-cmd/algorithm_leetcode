package design;

import java.util.List;

public class BookLibrary {

    private List<Book> bookList;

    public BookLibrary(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void addBook(Book book){
        bookList.add(book);
    }


}


class Book{
    private int id;
    private int numberOfPage;
    boolean isActive;
    private String author;
    private String title;
    private List<String> pages;
    private int currentPage = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getPages() {
        return pages;
    }

    public void setPages(List<String> pages) {
        this.pages = pages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getCurrentContent(){
        return pages.get(currentPage);
    }

    public void turnPage(){
        currentPage++;
        getCurrentContent();
    }
}
