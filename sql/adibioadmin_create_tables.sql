DROP TABLE IF EXISTS managers CASCADE ;
CREATE TABLE managers(
  row_id SERIAL,
  manager_id VARCHAR(255) NOT NULL ,
  manager_level INT NOT NULL ,
  username VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  register_time TIMESTAMP,
  real_name VARCHAR(255),
  id_number VARCHAR(255),
  telphone VARCHAR(255),
  email VARCHAR(255),
  head_image VARCHAR(255),
  CONSTRAINT managers_rowid_pk PRIMARY KEY(row_id),
  CONSTRAINT managers_managerid_unique UNIQUE (manager_id),
  CONSTRAINT managers_username_unique UNIQUE (username)
);