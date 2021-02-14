package com.cg.bill.exception;

public class BillException extends Exception{
	public BillException(String message) {
		super(message);
		}
		
		public BillException(Throwable cause) {
			super(cause);
			}
		 public BillException(String message,Throwable cause)
		  {
			  super(message,cause);
		  }

			public BillException() {
				super();
				// TODO Auto-generated constructor stub
			}

}
