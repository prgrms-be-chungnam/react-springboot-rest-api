select * from `show`;
select * from show_seq;

delete from `show`;

SET @@auto_increment_increment=1;

ALTER TABLE `show` AUTO_INCREMENT=1;
SET @COUNT = 0;
UPDATE `show` SET `show_id` = @COUNT:=@COUNT+1;

ALTER TABLE `show_seq` AUTO_INCREMENT=1;
UPDATE show_seq SET next_val = @COUNT:=@COUNT+1;


