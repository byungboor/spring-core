CREATE TABLE IF NOT EXISTS NOTI_LOG (
  LOG_ID  INT AUTO_INCREMENT NOT NULL,
  NOTI_TYPE VARCHAR(45) NOT NULL,
  PHONE_NUMBER VARCHAR(100) NOT NULL,
  CREATE_AT DATETIME NOT NULL,

  PRIMARY KEY(LOG_ID)
);
