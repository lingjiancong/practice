package com.lingjiancong.concurrency.nonblocking;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author lingjiancong
 */
public class LinkedQueue<E> {
    private static class Node<E> {
        final E item;
        final AtomicReference<Node<E>> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = new AtomicReference<Node<E>>(next);
        }
    }

    private final Node<E> dummy = new Node<E>(null, null);
    private final AtomicReference<Node<E>> head = new AtomicReference<Node<E>>(dummy);
    private final AtomicReference<Node<E>> tail = new AtomicReference<Node<E>>(dummy);

    public boolean put(E item) {
        Node<E> node = new Node<E>(item, null);

        while (true) {
            Node<E> last = tail.get();
            Node<E> lastNext = last.next.get();
            if (last == tail.get()) {
                if (lastNext != null) {
                    tail.compareAndSet(last, lastNext);
                } else {
                    if (last.next.compareAndSet(null, node)) {
                        tail.compareAndSet(last, node);
                        return true;
                    }
                }
            }
        }

    }
}
