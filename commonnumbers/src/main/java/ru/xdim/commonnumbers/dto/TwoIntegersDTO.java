package ru.xdim.commonnumbers.dto;

public class TwoIntegersDTO {
    public int a;
    public int b;

    public TwoIntegersDTO(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int findGCD() {
        return this.findGCD(this.a, this.b);
    }

    public int findLCM() {
        return this.findLCM(this.a, this.b);
    }

    private int findLCM(int a, int b) {
        return a * (b / findGCD(a, b));
    }

    private int findGCD(int a, int b) {
        return (b == 0) ? a : findGCD(b, a % b);
    }
}
