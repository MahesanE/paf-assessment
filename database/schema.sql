CREATE DATABASE bgg;

USE bgg;


CREATE TABLE user (
  user_id VARCHAR(8) NOT NULL,
  username VARCHAR(150) NOT NULL,
  name VARCHAR(150) NOT NULL,
  PRIMARY KEY (user_id)
);

-- create task table 
CREATE TABLE task (
  task_id INT NOT NULL AUTO_INCREMENT,
  description text NOT NULL,
  priority INT CHECK (priority BETWEEN 1 AND 3),
  due_date DATE,
  user_id VARCHAR(8) NOT NULL,
  PRIMARY KEY (task_id),
  FOREIGN KEY (user_id) REFERENCES user(user_id)
);