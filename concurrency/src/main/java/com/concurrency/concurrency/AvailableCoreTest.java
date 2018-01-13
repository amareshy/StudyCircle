package com.concurrency.concurrency;

/**
 * Hello world!
 *
 */
public class AvailableCoreTest
{
    public static void main(String[] args)
    {

        System.out.println("Available processors : " + Runtime.getRuntime().availableProcessors());

        MyThread t1 = new MyThread("A");
        MyThread t2 = new MyThread("B");
        MyThread t3 = new MyThread("C");
        MyThread t4 = new MyThread("D");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println("End program");
    }
}

class MyThread extends Thread
{
    public MyThread(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                System.out.println("Thread name : " + super.getName() + " ->  Available Cores : " + Runtime.getRuntime().availableProcessors());
                Thread.sleep(3000);
            }

        }
        catch (InterruptedException theE)
        {
            theE.printStackTrace();
        }
    }
}
