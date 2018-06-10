package com.lingjiancong.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author lingjiancong
 */
public class WorkPay {

    public List<Integer> getBestPay(List<Task> tasks, List<Integer> memberPi) {

        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.di.compareTo(o2.di);
            }
        });

        int best = 0;
        for (int i = 0; i < tasks.size(); ++i) {
            if (tasks.get(i).pi > best) {
                best = tasks.get(i).pi;
            }
            tasks.get(i).pi = best;
        }

        List<Integer> bestPays = new ArrayList<>();
        for (int i = 0; i < memberPi.size(); ++i) {
            int ai = memberPi.get(i);
            bestPays.add(getBestPay(tasks, ai));
        }
        return bestPays;
    }

    public Integer getBestPay(List<Task> tasks, Integer ai) {
        if (tasks == null || tasks.isEmpty() || ai == null) {
            return 0;
        }

        int size = tasks.size();
        if (ai < tasks.get(0).di) {
            return 0;
        } else if (ai > tasks.get(size - 1).di) {
            return tasks.get(size - 1).pi;
        }

        int index = getLessIndex(tasks, ai, 0, size - 1);
        return tasks.get(index).pi;
    }

    public Integer getLessIndex(List<Task> tasks, Integer ai, Integer begin, Integer end) {

        if (end <= begin) {
            return begin;
        }
        int mid = (begin + end) / 2;
        if (tasks.get(mid).di > ai) {
            return getLessIndex(tasks, ai, begin, mid - 1);
        } else if (tasks.get(mid).di < ai) {
            if (mid == begin) {
                if (tasks.get(end).di <= ai) {
                    return end;
                } else {
                    return mid;
                }
            }
            return getLessIndex(tasks, ai, mid, end);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int tasks = in.nextInt(), members = in.nextInt();

        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < tasks; ++i) {
            int di = in.nextInt();
            int pi = in.nextInt();
            taskList.add(new Task(di, pi));
        }

        List<Integer> memberPi = new ArrayList<>();
        for (int i = 0; i < members; ++i) {
            memberPi.add(in.nextInt());
        }

        WorkPay workPay = new WorkPay();
        List<Integer> bestPay = workPay.getBestPay(taskList, memberPi);
        for (int i = 0; i < bestPay.size(); ++i) {
            System.out.println(bestPay.get(i));
        }
    }
}

class Task {
    Integer di;
    Integer pi;

    public Task(Integer di, Integer pi) {
        this.di = di;
        this.pi = pi;

    }
}
