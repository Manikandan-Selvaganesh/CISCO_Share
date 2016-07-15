package com.deshaw.prj.client;

public class BankExample {

	public static void main(String[] args) {
		Account account = new Account(5000);
		TransactionThread t1 = new TransactionThread(account, TransactionType.CREDIT, "Karthik", 3000.00);
		TransactionThread t2 = new TransactionThread(account, TransactionType.CREDIT, "\tPriya", 2000.00);
		TransactionThread t3 = new TransactionThread(account, TransactionType.DEBIT, "\t\tRamesh", 2500.00);
		
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join(); t2.join(); t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Final Balance : " + account.getBalance());
	}

}
