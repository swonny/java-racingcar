package domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public int generate() {
        return new Random().nextInt(10);
    }
}
