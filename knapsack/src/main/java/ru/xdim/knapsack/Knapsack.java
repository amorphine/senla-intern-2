package ru.xdim.knapsack;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private final int capacity;

    public final List<KnapsackItem> items;

    public Knapsack(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * Get total weight of knapsack items
     *
     * @return total weight of knapsack items
     */
    public int getTotalWeight() {
        int w = 0;

        for (KnapsackItem item : items) {
            w += item.weight;
        }

        return w;
    }

    /**
     * Get total value of knapsack items
     *
     * @return total value of knapsack items
     */
    public int getTotalValue() {
        int v = 0;

        for (KnapsackItem item : items) {
            v += item.value;
        }

        return v;
    }

    /**
     * Get left free weight
     *
     * @return available weight value
     */
    public int getFreeSpace() {
        return this.getCapacity() - this.getTotalWeight();
    }

    /**
     * Add item to the knapsack
     *
     * @param item item to add
     */
    public void addItem(KnapsackItem item) {
        this.items.add(item);
    }
}
