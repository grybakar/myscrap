package com.devbridge.sourcery.myscrap.exception;

public class MyScrapException extends RuntimeException {

  public MyScrapException(String message) {
    super(message);


  }

  public MyScrapException(String message, Throwable cause) {
    super(message, cause);
  }
}
