package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;

public class Product {// product
    String productId;
    String productName;
    Date productSnapshotDate;
    String productType;
    BigDecimal productPrice;


    private String currency;


    public Product() {
    }

    public String getCurrency() {
        return currency;
    }

    public String getProductId() {
        return productId;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
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