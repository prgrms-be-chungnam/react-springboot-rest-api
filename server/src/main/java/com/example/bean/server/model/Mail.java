package com.example.bean.server.model;

import java.util.Objects;
import java.util.regex.Pattern;
import lombok.Getter;
import org.springframework.util.Assert;

/**
 * The {@code Mail} class represents an email address that adheres to the RFC 5322 standards. It
 * provides methods to validate and store a valid email address.
 *
 * @version 1.0
 * @since 2023-08-04
 */
@Getter
public class Mail {

  private final String address;

  /**
   * Constructs a new {@code Mail} object with the specified email address.
   *
   * @param address The email address to be validated and stored.
   * @throws IllegalArgumentException if the input address is null or not valid per RFC 5322.
   */
  public Mail(String address) {
    Assert.notNull(address, "Address should not be null");
    Assert.isTrue(isValidAddress(address), "Invalid email address");
    this.address = address;
  }

  /**
   * Checks if the given address is valid according to the RFC 5322 standards.
   *
   * @param address The email address to be validated.
   * @return {@code true} if the address is valid, {@code false} otherwise.
   */
  private static boolean isValidAddress(String address) {
    return Pattern.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", address);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    return Objects.equals(address, ((Mail) obj).address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address);
  }
}
