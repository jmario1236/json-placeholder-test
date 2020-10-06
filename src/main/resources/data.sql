DROP TABLE IF EXISTS permission;

CREATE TABLE permission (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  id_user INT NOT NULL,
  id_album INT NOT NULL,
  read BOOLEAN,
  write BOOLEAN,
  last_update TIMESTAMP NOT NULL
);

