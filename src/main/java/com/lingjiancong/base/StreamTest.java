package com.lingjiancong.base;

import java.math.BigInteger;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author lingjiancong
 * @since 2019-03-12
 */
public class StreamTest {

    @Test
    public void primesTest() {
        primes().map(p -> BigInteger.valueOf(2L).pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
    }

    public static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.valueOf(2L), BigInteger::nextProbablePrime);
    }

    /**
     * Returns a stream of all the sublists of its input list
     */
    public static class SubLists {

        public static <E> Stream<List<E>> of(List<E> list) {
            return Stream.concat(Stream.of(Collections.emptyList()), prefixes(list).flatMap(SubLists::suffixes));
        }

        private static <E> Stream<List<E>> prefixes(List<E> list) {
            return IntStream.rangeClosed(1, list.size()).mapToObj(end -> list.subList(0, end));
        }

        private static <E> Stream<List<E>> suffixes(List<E> list) {
            return IntStream.range(0, list.size()).mapToObj(start -> list.subList(start, list.size()));
        }
    }

    /**
     * returns the power set of an input as custom collection
     */
    public static class PowerSet {
        public static final <E> Collection<Set<E>> of(Set<E> s) {
            List<E> src = new ArrayList<>(s);
            if (src.size() > 30) {
                throw new IllegalArgumentException("Set to big " + s);
            }
            return new AbstractList<Set<E>>() {
                @Override
                public Set<E> get(int index) {
                    Set<E> result = new HashSet<>();
                    for (int i = 0; index != 0; i++, index >>= 1) {
                        if ((index & 1) == 1) {
                            result.add(src.get(i));
                        }
                    }
                    return result;
                }

                @Override
                public int size() {
                    return 1 << src.size();
                }

                @Override
                public boolean contains(Object object) {
                    return object instanceof Set && src.contains((Set) object);
                }
            };

        }
    }



}
