//**********************************************************************
// Copyright (c) 2017 Telefonaktiebolaget LM Ericsson, Sweden.
// All rights reserved.
// The Copyright to the computer program(s) herein is the property of
// Telefonaktiebolaget LM Ericsson, Sweden.
// The program(s) may be used and/or copied with the written permission
// from Telefonaktiebolaget LM Ericsson or in accordance with the terms
// and conditions stipulated in the agreement/contract under which the
// program(s) have been supplied.
// **********************************************************************
package com.concurrency.concurrency;

import java.util.concurrent.Semaphore;

public class SemaphoreTest
{
    static Semaphore semaphore = new Semaphore(4);

    public static void main(String[] args)
    {
        System.out.println("Total available Semaphore permits : "
                + semaphore.availablePermits());

        MyATMThread t1 = new MyATMThread("A", semaphore);
        t1.start();

        MyATMThread t2 = new MyATMThread("B", semaphore);
        t2.start();

        MyATMThread t3 = new MyATMThread("C", semaphore);
        t3.start();

        MyATMThread t4 = new MyATMThread("D", semaphore);
        t4.start();

        MyATMThread t5 = new MyATMThread("E", semaphore);
        t5.start();

        MyATMThread t6 = new MyATMThread("F", semaphore);
        t6.start();

    }
}

class MyATMThread extends Thread
{
    Semaphore semaphore;;
    String name = "";

    public MyATMThread(String name, Semaphore semaphore)
    {
        this.name = name;
        this.semaphore = semaphore;
    }

    @Override
    public void run()
    {

        try
        {
            System.out.println(name + ": acquiring lock......");
            System.out.println(name + " : available Semaphore permits now: "
                    + semaphore.availablePermits());

            semaphore.acquire();

            System.out.println(name + " : got the permit!");

            try
            {

                for (int i = 1; i <= 5; i++)
                {

                    System.out.println(name + " : is performing operation " + i
                            + ", available Semaphore permits : "
                            + semaphore.availablePermits());

                    // sleep 1 second
                    Thread.sleep(1000);

                }

            }
            finally
            {

                // calling release() after a successful acquire()
                System.out.println(name + " : releasing lock...");
                semaphore.release();
                System.out.println(name + " : available Semaphore permits now: "
                        + semaphore.availablePermits());

            }

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
