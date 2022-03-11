package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {// discount
    String discountCause;
    BigDecimal value;
    private String currency;

    public String getCurrency() {
        return currency;
    }

    public Discount() {
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getDiscountCause() {
        return discountCause;
    }
}