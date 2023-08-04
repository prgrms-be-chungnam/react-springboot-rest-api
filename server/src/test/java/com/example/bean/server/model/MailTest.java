package com.example.bean.server.model;

import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Mail Test")
public class MailTest {

  @Test
  @DisplayName("Valid Email Address")
  public void testValidEmailAddress() {
    String validEmail = "john.doe@example.com";
    Mail mail = new Mail(validEmail);
    Assertions.assertEquals(validEmail, mail.getAddress());
  }

  @Test
  @DisplayName("Invalid Email Address")
  public void testInvalidEmailAddress() {
    String invalidEmail = "invalid-email";
    Assertions.assertThrows(IllegalArgumentException.class, () -> new Mail(invalidEmail));
  }

  @Test
  @DisplayName("Random Email Address Generation")
  public void testRandomEmailAddressGeneration() {
    for (int i = 0; i < 100; i++) {
      String randomEmail = generateRandomEmailAddress();
      Mail mail = new Mail(randomEmail);
      Assertions.assertEquals(randomEmail, mail.getAddress());
    }
  }

  private String generateRandomEmailAddress() {
    String uuid = UUID.randomUUID().toString();
    return "user" + uuid.substring(0, 8) + "@example.com";
  }
}
