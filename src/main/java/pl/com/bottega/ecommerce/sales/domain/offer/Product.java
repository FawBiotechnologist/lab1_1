package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product {// product

    private String id;
    private String name;
    private Date snapshotDate;
    private String type;
    private Money price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId().equals(product.getId()) && getName().equals(product.getName()) && getSnapshotDate().equals(product.getSnapshotDate()) && getType().equals(product.getType()) && getProductPrice().equals(product.getProductPrice());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (type == null ? 0 : type.hashCode());
        result = prime * result + (snapshotDate == null ? 0 : snapshotDate.hashCode());
        result = prime * result + (price == null ? 0 : price.hashCode());
        return result;
    }

    private Product() {
    }

    public Product(String Id, String name, Date snapshotDate, String type, Money price) {
        this.id = Id;
        this.name = name;
        this.snapshotDate = snapshotDate;
        this.type = type;
        this.price = price;
    }


    public String getId() {
        return id;
    }

    public Money getProductPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public String getType() {
        return type;
    }
}