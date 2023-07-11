package my.colibear.study._02_tdd_advanced;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarpTest {
    @Test
    public void testWrap() {
        this.assertWrapped("", 1, "");
        this.assertWrapped("x", 1, "x");
        this.assertWrapped("xx", 1, "x\nx");
        this.assertWrapped("xx", 2, "xx");
        this.assertWrapped("xxx", 1, "x\nx\nx");
        this.assertWrapped("xxx", 3, "xxx");
        this.assertWrapped("x x", 1, "x\nx");
        this.assertWrapped("x x x", 1, "x\nx\nx");
        this.assertWrapped("x x", 3, "x x");
        this.assertWrapped("x x x", 1, "x\nx\nx");
        this.assertWrapped("x x x", 2, "x\nx\nx");
        this.assertWrapped("x x x", 3, "x x\nx");
        this.assertWrapped("x x x", 4, "x x\nx");
        this.assertWrapped("x x x", 5, "x x x");
        this.assertWrapped("xx xx", 1, "x\nx\nx\nx");
        this.assertWrapped("xx xx", 2, "xx\nxx");
        this.assertWrapped("xx xx", 3, "xx\nxx");
        this.assertWrapped("xx xx", 4, "xx\nxx");
        this.assertWrapped("xx xx", 5, "xx xx");
        this.assertWrapped("xx xx  xx", 5, "xx xx\nxx");
        String str = "Four score and seven years ago our fathers brought forth upon this continent a new nation conceived in liberty and dedicated to the proposition that all men are created equal";
        this.assertWrapped(str, 15, "Four score and\nseven years ago\nour fathers\nbrought forth\nupon this\ncontinent a new\nㅋnation\nconceived in\nliberty and\ndedicated to\nthe proposition\nthat all men\nare created\nequal");
        // assertWrapped("Four", 7, "Four");
//        this.assertWrapped("Four Score", 7, "Four\nScore");
//        this.assertWrapped("Four score and seven years ago our", 7, "Four\nscore\nand\nseven\nyears\nago our");
//        this.assertWrapped("ago our", 7, "ago our");
    }

    private String wrap(String s, int w) {
//        return s.replace(" ", "\n");
        if (w >= s.length()) {
            return s;
        }
        int br = s.lastIndexOf(" ", w);
        if (br == -1) {
            br = w;
        }
        return s.substring(0, br).trim() + "\n" + this.wrap( s.substring(br).trim(), w);
    }

    private void assertWrapped(String s, int width, String expected) {
        assertEquals(expected, wrap(s, width));
    }
}
