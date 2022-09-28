package com.example.gccoffee;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.UUID;

public class JdbcUtils {
    public static LocalDateTime toLocalDateTime(java.sql.Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }

    public static UUID toUUID(byte[] bytes){
        var byteBuffer = ByteBuffer.wrap(bytes);
        return new UUID(byteBuffer.getLong(), byteBuffer.getLong());

    }
}
