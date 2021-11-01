package com.jjh.bookstore.domain;

public class Book {

	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private double price;

	public Book() {}

	public Book(String isbn, String title, String author, String publisher, double price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "BookImpl [author=" + author + ", isbn=" + isbn + ", price="
				+ price + ", publisher=" + publisher + ", title=" + title + "]";
	}

}
