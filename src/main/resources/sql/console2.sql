select * from user;

delete from user;

SET @@auto_increment_increment=1;
ALTER TABLE user AUTO_INCREMENT=1;
SET @COUNT = 0;
UPDATE user SET user_num = @COUNT:=@COUNT+1;

ALTER TABLE user_seq AUTO_INCREMENT=1;
UPDATE user_seq SET next_val = @COUNT:=@COUNT+1;