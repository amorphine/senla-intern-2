package ru.xdim.knapsack;

public class KnapsackItem implements Comparable<KnapsackItem> {
    // let's make properties public to make the work with them easier
    public final int weight;
    public final int value;

    public KnapsackItem(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int compareTo(KnapsackItem o) {
        int thisRate = this.value / this.weight;
        int otherRate = o.value / o.weight;

        if (thisRate > otherRate) {
            return -1;
        } else if (thisRate < otherRate) {
            return 1;
        }

        return 0;
    }
}
