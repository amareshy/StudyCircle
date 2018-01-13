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

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo
{

    public static void main(String[] args)
    {
        CountDownLatch latch = new CountDownLatch(4);

        Worker worker1 = new Worker(1000, latch, "Worker-1");
        Worker worker2 = new Worker(2000, latch, "Worker-2");
        Worker worker3 = new Worker(3000, latch, "Worker-3");
        Worker worker4 = new Worker(4000, latch, "Worker-4");

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        // The main task waits for four threads
        try
        {
            latch.await();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        // Main thread has started
        System.out.println(Thread.currentThread().getName() +
                " has finished");
    }
}

//A class to represent threads for which the main thread
//waits.
class Worker extends Thread
{
    private final int delay;
    private final CountDownLatch latch;

    public Worker(int delay, CountDownLatch latch,
                  String name)
    {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName()
                    + " finished");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
