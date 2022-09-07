package ru.job4j.ood.dip;

import java.util.Objects;

public class Contract {

    private int contractAmount;

    public Contract(int contractAmount) {
        this.contractAmount = contractAmount;
    }

    public int getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(int contractAmount) {
        this.contractAmount = contractAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contract contract = (Contract) o;
        return contractAmount == contract.contractAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contractAmount);
    }
}
