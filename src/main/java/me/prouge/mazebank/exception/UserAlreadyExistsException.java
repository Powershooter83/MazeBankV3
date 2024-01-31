package me.prouge.mazebank.exception;

public class UserAlreadyExistsException extends Exception {

   public UserAlreadyExistsException() {
      super("User with this email already exists.");
   }

}
