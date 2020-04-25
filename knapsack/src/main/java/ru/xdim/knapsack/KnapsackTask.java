package ru.xdim.knapsack;

import ru.xdim.common.Task;

import static java.lang.System.out;

/**
 * Some restrictions
 * 1. This is a 0-1 knapsack problem
 * 2. There's no user input in the task so data has been hardcoded
 */
public class KnapsackTask implements Task {
    @Override
    public void run() {
        final KnapsackItem[] items = {
                new KnapsackItem(1, 2),
                new KnapsackItem(2, 7),
                new KnapsackItem(3, 6),
                new KnapsackItem(4, 1),
        };

        final Knapsack knapsack = new Knapsack(6);

        this.fillUpKnapsack(knapsack, items);

        out.println("Items: ");
        for (KnapsackItem item : items) {
            out.println("w: " + item.weight + " v: " + item.value);
        }

        out.println();

        out.println("Solution:");
        for (KnapsackItem item : knapsack.items) {
            out.println("w: " + item.weight + " v: " + item.value);
        }
        out.println("Max weight: " + knapsack.getCapacity());

        out.println("Total weight: " + knapsack.getTotalWeight());

        out.println("Total value: " + knapsack.getTotalValue());
    }

    /**
     * Fill up knapsack via DP algorithm
     *
     * @param knapsack
     * @param items
     */
    private void fillUpKnapsack(final Knapsack knapsack, final KnapsackItem[] items) {
        int itemsCount = items.length;
        int capacity = knapsack.getCapacity();

        int[][] mtrx = new int[itemsCount + 1][capacity + 1];

        for (int i = 0; i <= capacity; i++)
            mtrx[0][i] = 0;

        for (int i = 1; i <= itemsCount; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (items[i - 1].weight > j)
                    mtrx[i][j] = mtrx[i - 1][j];
                else
                    mtrx[i][j] = Math.max(mtrx[i - 1][j], mtrx[i - 1][j - items[i - 1].weight]
                            + items[i - 1].value);
            }
        }

        int res = mtrx[itemsCount][capacity];
        int w = capacity;

        for (int i = itemsCount; i > 0 && res > 0; i--) {
            if (res != mtrx[i - 1][w]) {
                knapsack.addItem(items[i - 1]);
                res -= items[i - 1].value;
                w -= items[i - 1].weight;
            }
        }
    }
}
