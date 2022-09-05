package ru.job4j.ood.ocp;

public class Pizza {

    public class FourCheesePizza {

        private int dough;

        private int cheese;

        public FourCheesePizza(int dough, int cheese) {
            this.dough = dough;
            this.cheese = cheese;
        }

        public FourCheesePizza makePizza() {
            return new FourCheesePizza(200, 200);
        }
    }

    public class MargaritaPizza extends FourCheesePizza {

        int tomatoes;

        public MargaritaPizza(int dough, int cheese, int tomatoes) {
            super(dough, cheese);
            this.tomatoes = tomatoes;
        }

        public MargaritaPizza makePizza() {
            return new MargaritaPizza(200, 100, 100);
        }
    }
}
