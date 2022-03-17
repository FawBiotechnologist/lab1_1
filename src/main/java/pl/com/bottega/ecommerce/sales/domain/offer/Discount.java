package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    private final Money money;// discount
    private final String discountCause;

    public Discount(Money money, String discountCause) {
        this.money = money;
        this.discountCause = discountCause;
    }

    public BigDecimal getValue() {
        return money.getAmount();
    }

    public String getDiscountCause() {
        return discountCause;
    }
}