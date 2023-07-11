package my.colibear.study._01_tdd_basic;

public class Game {

//    private int score;

    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        // 여기는 점수가 계산 되어야 하지 않느다.
//        this.score += pins;
        rolls[currentRoll++] = pins;
    }


    // 여기가 점수를 계산해야 하는 확실한 곳이다.
    public int score() {
        int score = 0;

        // 이 부분을 frame 단위로 나눠 보자
//        for (int i = 0; i < rolls.length; i++) {
//            score += rolls[i];
//        }

        int frameIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + this.strikeBonus(frameIndex);
                frameIndex++;
            } else if (this.isSpare(frameIndex)) { // spare
                score += 10 + this.spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += this.oneFrameFins(frameIndex);
                frameIndex += 2;
            }
        }

        return score;
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + spareBonus(frameIndex);
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return this.oneFrameFins(frameIndex) == 10;
    }

    private int oneFrameFins(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }
}
