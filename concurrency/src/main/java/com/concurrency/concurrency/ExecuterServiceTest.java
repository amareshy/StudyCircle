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
