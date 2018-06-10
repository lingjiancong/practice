package com.lingjiancong.rmi.client;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.lingjiancong.rmi.compute.Compute;

/**
 * @author lingjiancong
 */
public class ComputePi {

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry();
            Compute comp = (Compute) registry.lookup(name);
            BigDecimal pi = comp.executeTask(new Pi());
            System.out.println(pi);
        } catch (Exception e) {
            System.err.println("ComputePi exception: ");
            e.printStackTrace();
        }
    }
}
