package ru.job4j.ood.dip;

import java.util.ArrayList;
import java.util.List;

public class Logistics {

    private static final int WAREHOUSE_SIZE = 10;

    private static final int MINIMUM_AMOUNT = 10;

    private List<BuildingMaterials> bm = new ArrayList<>();

    private boolean addBatch(BuildingMaterials buildingMaterials) {
        if (bm.size() >= WAREHOUSE_SIZE) {
            throw new IllegalArgumentException("Склад переполнен");
        }
        return bm.add(buildingMaterials);
    }

    private boolean signContract(Contract contract) {
        boolean rsl = false;
        if (contract.getContractAmount() > MINIMUM_AMOUNT) {
            rsl = true;
            bm.clear();
        }
        return rsl;
    }

}
