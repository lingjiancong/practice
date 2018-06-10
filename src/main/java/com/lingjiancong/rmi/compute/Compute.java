package com.lingjiancong.rmi.compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author lingjiancong
 */
public interface Compute extends Remote {

    <T> T executeTask(Task<T> t) throws RemoteException;
}
