package com.example.bean.server;

import java.nio.ByteBuffer;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * The {@code JDBCUtils} class provides utility methods for converting between Java types and
 * database-specific types used in JDBC operations. It offers methods to convert between
 * {@link Timestamp} and {@link LocalDateTime}, as well as methods to convert byte arrays to
 * {@link UUID}.
 *
 * @version 1.0
 * @since 2023-08-04
 */
public class JDBCUtils {

  /**
   * Converts a {@link Timestamp} to a {@link LocalDateTime}.
   *
   * @param timestamp The {@link Timestamp} to be converted.
   * @return The equivalent {@link LocalDateTime}, or {@code null} if the input timestamp is
   * {@code null}.
   */
  public static LocalDateTime toLocalDateTime(Timestamp timestamp) {
    return timestamp != null ? timestamp.toLocalDateTime() : null;
  }

  /**
   * Converts a byte array to a {@link UUID}.
   *
   * @param bytes The byte array representing the UUID.
   * @return The corresponding {@link UUID}.
   */
  public static UUID toUUID(byte[] bytes) {
    ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
    return new UUID(byteBuffer.getLong(), byteBuffer.getLong());
  }
}