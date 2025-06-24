package org.example.exo2_cine.exception;

public class NotFoundException extends RuntimeException {
  public NotFoundException() {
  }

  public NotFoundException(String message) {
        super(message);
    }
}
