/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2018 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.cactoos.iterable;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Test case for {@link Limited}.
 *
 * @author Dusan Rychnovsky (dusan.rychnovsky@gmail.com)
 * @version $Id$
 * @since 0.6
 * @checkstyle JavadocMethodCheck (500 lines)
 */
public final class LimitedTest {

    @Test
    public void iteratesOverPrefixOfGivenLength() {
        // @checkstyle MagicNumber (7 lines)
        MatcherAssert.assertThat(
            "Can't limit an iterable with more items",
            new Limited<>(
                3, new IterableOf<>(0, 1, 2, 3, 4)
            ),
            Matchers.contains(0, 1, 2)
        );
    }

    @Test
    public void iteratesOverWholeIterableIfThereAreNotEnoughItems() {
        // @checkstyle MagicNumber (7 lines)
        MatcherAssert.assertThat(
            "Can't limit an iterable with less items",
            new Limited<>(
                10, new IterableOf<>(0, 1, 2, 3, 4)
            ),
            Matchers.contains(0, 1, 2, 3, 4)
        );
    }

    @Test
    public void limitOfZeroProducesEmptyIterable() {
        // @checkstyle MagicNumber (7 lines)
        MatcherAssert.assertThat(
            "Can't limit an iterable to zero items",
            new Limited<>(
                0, new IterableOf<>(0, 1, 2, 3, 4)
            ),
            Matchers.iterableWithSize(0)
        );
    }

    @Test
    public void negativeLimitProducesEmptyIterable() {
        // @checkstyle MagicNumber (7 lines)
        MatcherAssert.assertThat(
            "Can't limit an iterable to negative number of items",
            new Limited<>(
                -1, new IterableOf<>(0, 1, 2, 3, 4)
            ),
            Matchers.iterableWithSize(0)
        );
    }

    @Test
    public void emptyIterableProducesEmptyIterable() {
        // @checkstyle MagicNumber (7 lines)
        MatcherAssert.assertThat(
            "Can't limit an empty iterable",
            new Limited<>(
                10, new IterableOf<>()
            ),
            Matchers.iterableWithSize(0)
        );
    }
}
