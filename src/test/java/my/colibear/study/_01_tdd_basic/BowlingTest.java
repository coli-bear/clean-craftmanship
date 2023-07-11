package my.colibear.study._01_tdd_basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {

    private Game game;

    @BeforeEach
    public void setup() {
        this.game = new Game();
    }

    @Test
    public void nothing() {
    }
    // 단정문이 없으면 삭제하는게 좋다.
    // 이러한 테스트들은 이미 제 역할을 다했으며, 이러한 테스트를 계단 테스트라고 한다.(stair step)
//   public void canRoll() throws Exception {
//         공을 한번 굴린다.
//        this.game.roll(0);
//    }

    // 개임 점수를 계산, 게임을 굴려서 게임을 마쳐야 한다.
    @Test
    public void gutterGame() throws Exception {
//        for (int i = 0; i < 20; i++) {
//            this.game.roll(0);
//        }
        this.rollMany(20, 0);
        assertEquals(0, this.game.score());
    }

    @Test
    public void allOnes() throws Exception {
//        for (int i = 0; i < 20; i++) {
//            this.game.roll(1);
//        }
        this.rollMany(20, 1);
        assertEquals(20, this.game.score());
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            this.game.roll(pins);
        }
    }

    @Test
    public void oneSpare() throws Exception {
        this.rollSpare();
        this.game.roll(7);
        this.rollMany(17, 0);
        assertEquals(24, this.game.score());
    }

    private void rollSpare() {
        this.rollMany(2, 5);
    }

    @Test
    public void oneStrike() {
        this.roleStrike();
        this.game.roll(2);
        this.game.roll(3);
        this.rollMany(16, 0);
        assertEquals(20, this.game.score());
    }

    @Test
    public void perfectGame() throws Exception {
        this.rollMany(12, 10);
        assertEquals(300, this.game.score());
    }

    private void roleStrike() {
        this.game.roll(10);
    }
}
