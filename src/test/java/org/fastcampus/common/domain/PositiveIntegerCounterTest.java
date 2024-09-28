package org.fastcampus.common.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.fastcompus.common.domain.PositiveIntegerCounter;
import org.junit.jupiter.api.Test;

class PositiveIntegerCounterTest {
    @Test
    void givenCreated_whenIncrease_thenCountIsOne() throws Exception {
        // given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        // when
        counter.increase();
        // then
        assertEquals(1, counter.getCount());
    }

    @Test
    public void givenCreatedAndIncrease_whenDecrease_thenCountIsZero() throws Exception {
        // given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        counter.increase();
        // when
        counter.decrease();
        // then
        assertEquals(0, counter.getCount());
    }

    @Test
    void givenCreated_whenDecrease_thenCountIsZero() throws Exception {
        // given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();
        // when
        counter.decrease();
        // then
        assertEquals(0, counter.getCount());
    }
}
