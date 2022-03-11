package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {// product

    String productId;
    String productName;
    Date productSnapshotDate;
    String productType;
    Money price;


    private Product() {
    }

    public Product(String productId, String productName, Date productSnapshotDate, String productType, Money price) {
        this.productId = productId;
        this.productName = productName;
        this.productSnapshotDate = productSnapshotDate;
        this.productType = productType;
        this.price = price;
    }


    public String getProductId() {
        return productId;
    }

    public BigDecimal getProductPrice() {
        return price.getAmount();
    }

    public String getProductName() {
        return productName;
    }

    public Date getProductSnapshotDate() {
        return productSnapshotDate;
    }

    public String getProductType() {
        return productType;
    }
}