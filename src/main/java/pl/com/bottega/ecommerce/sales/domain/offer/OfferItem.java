/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class OfferItem {

    private final Product product;
    private final Discount discount;

    private final int quantity;
    private final Money totalCost;

    public OfferItem(Product product, int quantity) {
        this(product, quantity, null);
    }

    public OfferItem(Product product, int quantity, Discount discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
        String discountCurrency = null;
        BigDecimal discountValue = new BigDecimal(0);
        if (this.discount != null) {
            discountValue = discountValue.subtract(discount.getValue().getAmount());
            discountCurrency = discount.getValue().getCurrency();
        }
        //this looks bad may need refactorization to be more readable
        this.totalCost = new Money(
                this.product.getProductPrice().getAmount().multiply(
                        new BigDecimal(quantity)).subtract(discountValue), (
                product.getProductPrice().getCurrency().equals(discountCurrency) ?
                        discountCurrency : null));
    }

    public Product getProduct() {
        return product;
    }

    public Discount getDiscount() {
        return discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (discount.getValue() == null ? 0 : discount.hashCode());
        result = prime * result + (product == null ? 0 : product.hashCode());
        result = prime * result + quantity;
        result = prime * result + (totalCost == null ? 0 : totalCost.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OfferItem other = (OfferItem) obj;
        if (discount == null) {
            if (other.getDiscount() != null) {
                return false;
            }
        } else if (!discount.equals(other.getDiscount())) {
            return false;
        }
        if (product == null) {
            if (other.getProduct() != null) {
                return false;
            }
        } else if (!product.equals(other.getProduct())) {
            return false;
        }
        if (quantity != other.quantity) {
            return false;
        }
        if (totalCost == null) {
            return other.totalCost == null;
        } else return totalCost.equals(other.getTotalCost());
    }

    /**
     * @param other
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
        //null check
        if (product == null) {
            if (other.getProduct() != null) {
                return false;
            }
            //other products
        } else if (!product.equals(other.getProduct())) {
            return false;
        }
        //other quantities
        if (quantity != other.quantity) {
            return false;
        }
        //acceptable cost range
        BigDecimal max;
        BigDecimal min;
        if (totalCost.getAmount().compareTo(other.getTotalCost().getAmount()) > 0) {
            max = totalCost.getAmount();
            min = other.getTotalCost().getAmount();
        } else {
            max = other.getTotalCost().getAmount();
            min = totalCost.getAmount();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
