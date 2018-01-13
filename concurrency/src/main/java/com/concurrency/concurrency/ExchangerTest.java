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

import java.util.concurrent.Exchanger;

public class ExchangerTest
{
    public static void main(String[] args)
    {
        Exchanger<String> exchanger = new Exchanger<String>();
        ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "A");
        ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "B");

        Thread t1 = new Thread(exchangerRunnable1);
        Thread t2 = new Thread(exchangerRunnable2);

        t1.start();
        t2.start();
    }

}

class ExchangerRunnable implements Runnable
{
    Exchanger<String> exchanger;
    String exchangeObject;

    public ExchangerRunnable(Exchanger<String> exchanger, String exchangeObject)
    {
        this.exchanger = exchanger;
        this.exchangeObject = exchangeObject;
    }

    @Override
    public void run()
    {

        try
        {
            String previous = this.exchangeObject;
            exchangeObject = exchanger.exchange(this.exchangeObject);

            System.out.println(
                    Thread.currentThread().getName() +
                            " exchanged " + previous + " for " + exchangeObject);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }
}
