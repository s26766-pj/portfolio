package Functions;

import Common.Print;

public class CountDown {
    private int start;
    public CountDown(int start) {
        this.start = start;

    }
    public int getInstance() {
        start = start - 1;
        return start;
    }
}
