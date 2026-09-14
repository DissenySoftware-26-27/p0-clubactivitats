package model;

import model.exceptions.InsufficientCreditException;
import model.exceptions.TopUpLimitReachedException;

public class VirtualCard {
  public final static double MAX_BALANCE = 3000.0;

  private String username;
  private double balance;

  public VirtualCard(String username, double openingBalance) {
    this.username = username;
    this.balance = openingBalance;
  }


  public void topUp(double amount) throws TopUpLimitReachedException {
    if (balance + amount > MAX_BALANCE)
      throw new TopUpLimitReachedException();

    balance += amount;
  }

  public void withdraw(double amount) throws InsufficientCreditException {
    if (balance - amount < 0.0)
      throw new InsufficientCreditException();

    balance -= amount;
  }
}
