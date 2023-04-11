import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings({"Convert2MethodRef", "CodeBlock2Expr"})
final class StackTest {
    public interface StackFactory<T> {
        Stack<T> create();
    }

    public static Stream<Arguments> localParameters() {
        return Stream.of(
            Arguments.of((StackFactory)(ArrayStack::new)),
            Arguments.of((StackFactory)(LinkedStack::new))
        );
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void clear(StackFactory<Integer> factory) {
        var stack = factory.create();

        for (int i = 0; i < 10; ++i) {
            stack.push(i);
        }
        stack.clear();

        assertEquals(0, stack.length());

        stack.push(0);

        assertEquals(1, stack.length());
        assertEquals(0, stack.topValue());
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void push(StackFactory<Integer> factory) {
        var stack = factory.create();

        for (int i = 0; i < 10; ++i) {
            stack.push(i);
        }
        assertEquals(10, stack.length());

        for (int i = 9; i >= 0; --i) {
            assertEquals(i, stack.topValue());
            assertEquals(i, stack.pop());
        }
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void pop(StackFactory<Integer> factory) {
        var stack = factory.create();

        for (int i = 0; i < 10; ++i) {
            stack.push(i);
        }
        assertEquals(10, stack.length());

        for (int i = 9; i >= 0; --i) {
            assertEquals(i, stack.topValue());
            assertEquals(i, stack.pop());
        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.pop();
        });
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void topValue(StackFactory<Integer> factory) {
        var stack = factory.create();

        for (int i = 0; i < 10; ++i) {
            stack.push(i);
        }
        assertEquals(10, stack.length());

        for (int i = 9; i >= 0; --i) {
            assertEquals(i, stack.topValue());
            stack.pop();
        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.topValue();
        });
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void length(StackFactory<Integer> factory) {
        var stack = factory.create();

        for (int i = 0; i < 10; ++i) {
            stack.push(i);
            assertEquals(i + 1, stack.length());
        }

        for (int i = 9; i >= 0; --i) {
            assertEquals(i + 1, stack.length());
            stack.pop();
        }
    }
}