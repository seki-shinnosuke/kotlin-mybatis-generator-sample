USE sample;
SET CHARSET utf8mb4;

-- sample_test
CREATE TABLE sample_test
(
  sample_test_id INT NOT NULL AUTO_INCREMENT COMMENT 'サンプルテストID',
  person_name VARCHAR(128) NOT NULL COMMENT '名前',
  sample_status ENUM('YET', 'DONE') NOT NULL DEFAULT 'YET' COMMENT 'ステータス(未/完)',
  register_datetime DATETIME COMMENT '登録日時',
  update_datetime DATETIME COMMENT '更新日時',
  PRIMARY KEY(sample_test_id)
) COMMENT='サンプルテスト';