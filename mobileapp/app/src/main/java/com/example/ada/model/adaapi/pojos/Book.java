package com.example.ada.model.adaapi.pojos;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book implements Serializable {

    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("availability")
    @Expose
    private Integer availability;
    @SerializedName("avgRating")
    @Expose
    private Double avgRating;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("discount")
    @Expose
    private Double discount;
    @SerializedName("editorial")
    @Expose
    private String editorial;
    @SerializedName("genre")
    @Expose
    private String genre;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("isbn")
    @Expose
    private String isbn;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("publishingdate")
    @Expose
    private String publishingdate;
    @SerializedName("sumRating")
    @Expose
    private Integer sumRating;
    @SerializedName("totRatings")
    @Expose
    private Integer totRatings;
    @SerializedName("reviews")
    @Expose
    private List<Object> reviews = null;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishingdate() {
        return publishingdate;
    }

    public void setPublishingdate(String publishingdate) {
        this.publishingdate = publishingdate;
    }

    public Integer getSumRating() {
        return sumRating;
    }

    public void setSumRating(Integer sumRating) {
        this.sumRating = sumRating;
    }

    public Integer getTotRatings() {
        return totRatings;
    }

    public void setTotRatings(Integer totRatings) {
        this.totRatings = totRatings;
    }

    public List<Object> getReviews() {
        return reviews;
    }

    public void setReviews(List<Object> reviews) {
        this.reviews = reviews;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getPrice() {
        return price;
    }
}
