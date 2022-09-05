package ru.job4j.ood.lsp;

import java.util.List;

public class TownLink extends ElectronicsStore {
    public TownLink(int quantity, int priceForEachVideoCard) {
        super(quantity, priceForEachVideoCard);
    }

    @Override
    public int pricePerBatch(List<VideoCard> videoCards) {
        int totalPrice = priceForEachVideoCard * videoCards.size();
        return totalPrice;
    }
}
