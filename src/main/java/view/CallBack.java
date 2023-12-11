package view;

import java.io.IOException;

@FunctionalInterface
public interface CallBack<T> {

    T execute() throws IOException;
}
