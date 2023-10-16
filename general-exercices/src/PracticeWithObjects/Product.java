package PracticeWithObjects;

import java.util.Arrays;
import java.util.UUID;

public class Product {

    private UUID id;
    private String name;
    private String description;
    private Category category;
    private Double price;
    private Integer totalAvailable;
    private Boolean available;
    private Float discount;
    private UUID[] relatedProducts;
    private int ranking;
    private Product product;

    public Product(){}

    public Product(UUID id, String name, String description, Category category, Double price,
                   Integer totalAvailable, Boolean available, Float discount, UUID[] relatedProducts, int ranking) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.totalAvailable = totalAvailable;
        this.available = available;
        this.discount = discount;
        this.relatedProducts = relatedProducts;
        this.ranking = ranking;
    }

    public Product(Product product,int totalAvailable) {
        this.id = product.getId();
        this.totalAvailable = totalAvailable;
        this.name = product.getName();
        this.description = product.getDescription();
        this.category = product.getCategory();
        this.price = product.getPrice();
        this.totalAvailable = totalAvailable;
        this.available = product.getAvailable();
        this.discount = product.getDiscount();
        this.relatedProducts = product.getRelatedProducts();
        this.ranking = product.getRanking();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", totalAvailable=" + totalAvailable +
                ", available=" + available +
                ", discount=" + discount +
                ", relatedProducts=" + Arrays.toString(relatedProducts) +
                ", ranking=" + ranking +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTotalAvailable() {
        return totalAvailable;
    }

    public void setTotalAvailable(Integer totalAvailable) {
        this.totalAvailable = totalAvailable;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public UUID[] getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(UUID[] relatedProducts) {
        this.relatedProducts = relatedProducts;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
