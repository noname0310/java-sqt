import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings({"Convert2MethodRef", "CodeBlock2Expr"})
final class QueueTest {
    public interface QueueFactory {
        Queue<Integer> create(int size);
    }

    public static Stream<Arguments> localParameters() {
        return Stream.of(
            Arguments.of((QueueFactory)(size -> new ArrayQueue<>(size)), true),
            Arguments.of((QueueFactory)(size -> new LinkedQueue<>()), false)
        );
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void clear(QueueFactory factory) {
        var queue = factory.create(10);

        for (int i = 0; i < 10; ++i) {
            queue.enqueue(i);
        }
        queue.clear();

        assertEquals(0, queue.length());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            queue.frontValue();
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            queue.dequeue();
        });

        queue.enqueue(0);

        assertEquals(1, queue.length());
        assertEquals(0, queue.frontValue());
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void enqueue(QueueFactory factory, boolean isFixedSize) {
        var queue = factory.create(10);

        for (int i = 0; i < 10; ++i) {
            queue.enqueue(i);
        }
        assertEquals(10, queue.length());

        if (isFixedSize) {
            assertThrows(IndexOutOfBoundsException.class, () -> {
                queue.enqueue(10);
            });
        }

        queue.clear();
        for (int i = 0; i < 10; ++i) {
            queue.enqueue(i);
        }
        assertEquals(10, queue.length());
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void dequeue(QueueFactory factory) {
        var queue = factory.create(10);

        for (int i = 0; i < 10; ++i) {
            queue.enqueue(i);
        }
        assertEquals(10, queue.length());

        for (int i = 0; i < 10; ++i) {
            assertEquals(i, queue.dequeue());
        }
        assertEquals(0, queue.length());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            queue.dequeue();
        });

        queue.enqueue(0);

        assertEquals(1, queue.length());
        assertEquals(0, queue.dequeue());
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void frontValue(QueueFactory factory) {
        var queue = factory.create(10);

        for (int i = 0; i < 10; ++i) {
            queue.enqueue(i);
        }
        assertEquals(10, queue.length());

        for (int i = 0; i < 10; ++i) {
            assertEquals(i, queue.frontValue());
            queue.dequeue();
        }
        assertEquals(0, queue.length());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            queue.frontValue();
        });

        queue.enqueue(0);

        assertEquals(1, queue.length());
    }

    @ParameterizedTest
    @MethodSource("localParameters")
    public void length(QueueFactory factory) {
        var queue = factory.create(10);

        for (int i = 0; i < 10; ++i) {
            queue.enqueue(i);
        }
        assertEquals(10, queue.length());

        for (int i = 0; i < 10; ++i) {
            queue.dequeue();
            assertEquals(10 - i - 1, queue.length());
        }
        assertEquals(0, queue.length());

        queue.enqueue(0);

        assertEquals(1, queue.length());
    }
}
