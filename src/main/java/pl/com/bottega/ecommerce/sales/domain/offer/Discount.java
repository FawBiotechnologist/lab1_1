package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Discount {
    final Money money;// discount
    String discountCause;

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