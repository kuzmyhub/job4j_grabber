package ru.job4j.ood.lsp;

import java.util.List;

public class ElectronicsStore {

    protected int quantity;

    protected int priceForEachVideoCard;

    public ElectronicsStore(int quantity, int priceForEachVideoCard) {
        this.quantity = quantity;
        this.priceForEachVideoCard = priceForEachVideoCard;
    }

    public int pricePerBatch(List<VideoCard> videoCards) {
        int totalPrice = priceForEachVideoCard * videoCards.size();
        if (videoCards.size() < quantity) {
            totalPrice = 0;
        }
        return totalPrice;
    }
}
