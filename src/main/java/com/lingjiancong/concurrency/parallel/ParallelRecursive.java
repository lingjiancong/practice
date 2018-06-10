package com.lingjiancong.concurrency.parallel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lingjiancong
 */
public class ParallelRecursive {

    public <T> void sequentialRecursive(List<Node<T>> nodes, Collection<T> results) {
        if (nodes != null) {
            for (Node<T> n : nodes) {
                results.add(n.compute());
                sequentialRecursive(n.getChild(), results);
            }
        }
    }

    public <T> void parallelRecursive(final Executor exec, List<Node<T>> nodes, final Collection<T> results) {

        if (nodes != null) {
            for (final Node<T> n : nodes) {
                exec.execute(new Runnable() {
                    @Override
                    public void run() {
                        results.add(n.compute());
                    }
                });
                parallelRecursive(exec, n.getChild(), results);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Node<Integer> node3 = new Node<>(3, null);
        Node<Integer> node4 = new Node<>(4, null);
        Node<Integer> node5 = new Node<>(5, null);

        List<Node<Integer>> node1Child = new ArrayList<>();
        node1Child.add(node3);
        node1Child.add(node4);
        node1Child.add(node5);

        Node<Integer> node6 = new Node<>(6, null);
        Node<Integer> node7 = new Node<>(7, null);
        List<Node<Integer>> node2Child = new ArrayList<>();
        node2Child.add(node6);
        node2Child.add(node7);

        Node<Integer> node1 = new Node<>(1, node1Child);
        Node<Integer> node2 = new Node<>(2, node2Child);

        List<Node<Integer>> root = new ArrayList<>();
        root.add(node1);
        root.add(node2);

        ParallelRecursive pr = new ParallelRecursive();
        Queue<Integer> queueSeq = new ConcurrentLinkedQueue<>();
        pr.sequentialRecursive(root, queueSeq);

        for (Integer i : queueSeq) {
            System.out.print(i + "  ");
        }
        System.out.println();
        System.out.println("-------------");


        ExecutorService exec = Executors.newCachedThreadPool();
        Queue<Integer> queueRecur = new ConcurrentLinkedQueue<>();
        pr.parallelRecursive(exec, root, queueRecur);
        exec.shutdown();
        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        for (Integer i : queueRecur) {
            System.out.print(i + "  ");
        }
        System.out.println();
        System.out.println("-------------");
    }

}

class Node<T> {
    private T value;
    private List<Node<T>> child;

    Node(T value, List<Node<T>> child) {
        this.value = value;
        this.child = child;
    }

    T compute() {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException ignored) {
        }
        return value;
    }

    List<Node<T>> getChild() {
        return this.child;
    }
}
