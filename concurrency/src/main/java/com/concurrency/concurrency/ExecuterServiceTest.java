package com.concurrency.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterServiceTest
{
    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("Asynchronous task " + " Thread Name : " + Thread.currentThread().getName());
            }
        });

        executorService.shutdown();
    }
}
