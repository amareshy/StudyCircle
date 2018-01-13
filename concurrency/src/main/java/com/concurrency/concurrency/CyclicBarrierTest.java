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

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest
{
    public static void main(String[] args)
    {
        Runnable barrier1Action = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("BarrierAction 1 executed ");
            }
        };
        Runnable barrier2Action = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("BarrierAction 2 executed ");
            }
        };

        CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
        CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);

        CyclicBarrierRunnable1 barrierRunnable1 =
                new CyclicBarrierRunnable1(barrier1, barrier2);

        CyclicBarrierRunnable2 barrierRunnable2 =
                new CyclicBarrierRunnable2(barrier1, barrier2);

        new Thread(barrierRunnable1).start();
        new Thread(barrierRunnable2).start();
    }
}

class CyclicBarrierRunnable1 implements Runnable
{
    private CyclicBarrier barrier1 = null;
    private CyclicBarrier barrier2 = null;

    /**
     *
     */
    public CyclicBarrierRunnable1(CyclicBarrier barrier1, CyclicBarrier barrier2)
    {
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() +
                    " waiting at barrier 1");
            this.barrier1.await();

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +
                    " waiting at barrier 2");
            this.barrier2.await();

            System.out.println(Thread.currentThread().getName() +
                    " done!");

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (BrokenBarrierException e)
        {
            e.printStackTrace();
        }
    }
}

class CyclicBarrierRunnable2 implements Runnable
{
    private CyclicBarrier barrier1 = null;
    private CyclicBarrier barrier2 = null;

    /**
     *
     */
    public CyclicBarrierRunnable2(CyclicBarrier barrier1, CyclicBarrier barrier2)
    {
        this.barrier1 = barrier1;
        this.barrier2 = barrier2;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +
                    " waiting at barrier 1");
            this.barrier1.await();

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +
                    " waiting at barrier 2");
            this.barrier2.await();

            System.out.println(Thread.currentThread().getName() +
                    " done!");

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (BrokenBarrierException e)
        {
            e.printStackTrace();
        }
    }
}
