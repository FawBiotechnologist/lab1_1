package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.List;

public class Offer {

    private final List<OfferItem> availableItems;

    private final List<OfferItem> unavailableItems;

    public Offer(List<OfferItem> availabeItems, List<OfferItem> unavailableItems) {
        this.availableItems = availabeItems;
        this.unavailableItems = unavailableItems;
    }

    public List<OfferItem> getAvailableItems() {
        return availableItems;
    }

    public List<OfferItem> getUnavailableItems() {
        return unavailableItems;
    }

    /**
     * @param seenOffer
     * @param delta     acceptable difference in percent
     * @return
     */
    public boolean sameAs(Offer seenOffer, double delta) {
        if (availableItems.size() != seenOffer.availableItems.size()) {
            return false;
        }

        for (OfferItem item : availableItems) {
            OfferItem sameItem = seenOffer.findItem(item.getProduct().getId());
            if (sameItem == null) {
                return false;
            }
            if (!sameItem.sameAs(item, delta)) {
                return false;
            }
        }

        return true;
    }

    private OfferItem findItem(String productId) {
        for (OfferItem item : availableItems) {
            if (item.getProduct().getId().equals(productId)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (availableItems == null ? 0 : availableItems.hashCode());
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
        Offer other = (Offer) obj;
        if (availableItems == null) {
            return other.availableItems == null;
        } else return availableItems.equals(other.availableItems);
    }

}
