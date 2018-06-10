package com.lingjiancong.concurrency.deadlock;

/**
 * @author lingjiancong
 */
public class LockOrder {

    private static final Object tieLock = new Object();

    public void transferMoney(final Account fromAcct, final Account toAcct, final DollarAmount amount) {

        class Helper {
            public void transfer() {
                if (fromAcct.getBalance().compareTo(amount) < 0)
                    throw new InsufficientFundsException();
                else {
                    fromAcct.debit(amount);
                    toAcct.credit(amount);
                }
            }
        }
        int fromHash = System.identityHashCode(fromAcct);
        int toHash = System.identityHashCode(toAcct);
        if (fromHash < toHash) {
            synchronized (fromAcct) {
                synchronized (toAcct) {
                    new Helper().transfer();
                }
            }
        } else if (toHash > fromHash) {
            synchronized (toAcct) {
                synchronized (fromAcct) {
                    new Helper().transfer();
                }
            }
        } else {
            synchronized (tieLock) {
                synchronized (fromAcct) {
                    synchronized (toAcct) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }
}

class Account {
    DollarAmount getBalance() {
        return null;
    }
    void debit(DollarAmount amount) {}
    void credit(DollarAmount amount) {}
}

class DollarAmount implements Comparable {
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
class InsufficientFundsException extends RuntimeException {}
