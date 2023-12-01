package org.example;

public class Action {
    private float wager;
    private final float currentBet;
    private final float maxBet;
    private boolean complete;
    public Action(float currentBet, float maxBet) {
        this.currentBet = currentBet;
        this.complete = false;
        this.maxBet = maxBet;
    }

    public boolean fold() {
        if (currentBet == 0.0f) {
            return false;
        } else {
            this.complete = true;
            return true;
        }
    }

    public boolean check() {
        if (currentBet == 0.0f) {
            this.complete = true;
            return true;
        } else {
            return false;
        }
    }

    public float call() {
        if (currentBet == 0.0f) {
            return 0.0f;
        } else {
            this.complete = true;
            this.wager = Math.min(currentBet, maxBet);
            return wager;
        }
    }

    public float raise(float raise) {
        if (raise >= currentBet || raise + currentBet > maxBet) {
            this.complete = true;
            this.wager = Math.min(raise + currentBet, maxBet);
            return wager;
        } else {
            return 0.0f;

        }
    }

    public boolean isComplete() {
        return this.complete;
    }
}
