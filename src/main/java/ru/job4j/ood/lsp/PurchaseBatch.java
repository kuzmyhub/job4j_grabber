package ru.job4j.ood.lsp;

import java.util.List;

public class PurchaseBatch {
    public static void main(String[] args) {
        TownLink townLink = new TownLink(10, 70000);
        List<VideoCard> videoCards = List.of(
                new Gigabit("turbo-2030"),
                new MSS("212-12"),
                new ASOS("B12-12"),
                new Gigabit("48494TI")
        );
        System.out.println(townLink.pricePerBatch(videoCards));
    }
}
