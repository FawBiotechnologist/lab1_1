package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Objects;

public class Discount {
    private final Money money;// discount
    private final String discountCause;

    public Discount(Money money, String discountCause) {
        this.money = money;
        this.discountCause = discountCause;
    }

    public Money getValue() {
        return money;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discount)) return false;
        Discount discount = (Discount) o;
        return Objects.equals(getValue(), discount.getValue()) && Objects.equals(getDiscountCause(), discount.getDiscountCause());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discountCause == null ? 0 : discountCause.hashCode());
        result = prime * result + (money == null ? 0 : money.hashCode());
        return result;
    }
}