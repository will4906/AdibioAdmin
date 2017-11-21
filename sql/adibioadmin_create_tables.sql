-- 描述管理用户的表格
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

-- 描述用户检测结果的表格
DROP TABLE IF EXISTS analysis CASCADE ;
CREATE TABLE analysis (
  row_id SERIAL,
  analysis_id VARCHAR(255) NOT NULL ,
  order_infoid VARCHAR(255) NOT NULL ,
  result VARCHAR(255) ,
  collection_date TIMESTAMP,
  analysis_date TIMESTAMP,
  CONSTRAINT analysis_rowid PRIMARY KEY (row_id),
  CONSTRAINT analysis_analysis_id UNIQUE (analysis_id),
  CONSTRAINT analysis_order_infoid UNIQUE (order_infoid)
);

-- 描述快递信息的表格
DROP TABLE IF EXISTS expressages CASCADE ;
CREATE TABLE expressages (
  row_id SERIAL,
  expressage_id VARCHAR(255) NOT NULL ,
  order_infoid VARCHAR(255) NOT NULL ,
  company VARCHAR(255) NOT NULL ,
  expressage_number VARCHAR(255) NOT NULL ,
  CONSTRAINT expressages_rowid PRIMARY KEY (row_id),
  CONSTRAINT expressages_expressage_id UNIQUE (expressage_id),
  CONSTRAINT expressages_order_infoid UNIQUE (order_infoid)
);