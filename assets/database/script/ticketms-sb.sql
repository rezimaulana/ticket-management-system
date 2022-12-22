--DDL
CREATE TABLE files(
id serial,
file_code text NOT NULL,
file_ext text NOT NULL,
	
created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE files ADD CONSTRAINT files_pk PRIMARY KEY(id);

CREATE TABLE roles(
id serial,
role_code varchar(10) NOT NULL,
role_name varchar(20) NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);

ALTER TABLE roles ADD CONSTRAINT roles_pk PRIMARY KEY(id);
ALTER TABLE roles ADD CONSTRAINT roles_bk UNIQUE(role_code);
ALTER TABLE roles ADD CONSTRAINT roles_ck UNIQUE(role_code, role_name);


CREATE TABLE companies(
id serial,
company_code varchar(10) NOT NULL,
company_name varchar(100) NOT NULL,
company_address text NOT NULL,
photo_id int,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);

ALTER TABLE companies ADD CONSTRAINT companies_pk PRIMARY KEY(id);
ALTER TABLE companies ADD CONSTRAINT companies_bk UNIQUE(company_code);
ALTER TABLE companies ADD CONSTRAINT companies_ck UNIQUE(company_code, company_name);
ALTER TABLE companies ADD CONSTRAINT files_companies_fk FOREIGN KEY(photo_id) REFERENCES files(id);

CREATE TABLE users(
id serial,
email varchar(200) NOT NULL,
password text NOT NULL,
fullname varchar(100) NOT NULL,
pic_id int,
company_id int,
role_id int NOT NULL,
photo_id int,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);

ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY KEY(id);
ALTER TABLE users ADD CONSTRAINT users_bk UNIQUE(email);
ALTER TABLE users ADD CONSTRAINT users_users_fk FOREIGN KEY(pic_id) REFERENCES users(id);
ALTER TABLE users ADD CONSTRAINT roles_users_fk FOREIGN KEY(role_id) REFERENCES roles(id);
ALTER TABLE users ADD CONSTRAINT files_users_fk FOREIGN KEY(photo_id) REFERENCES files(id);
ALTER TABLE users ADD CONSTRAINT companies_users_fk FOREIGN KEY(company_id) REFERENCES companies(id);

CREATE TABLE tickets_status(
id serial,
status_code varchar(10) NOT NULL,
status varchar(10) NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);

ALTER TABLE tickets_status ADD CONSTRAINT tickets_status_pk PRIMARY KEY(id);
ALTER TABLE tickets_status ADD CONSTRAINT tickets_status_bk UNIQUE(status_code);

CREATE TABLE tickets_priority(
id serial,
priority_code varchar(10) NOT NULL,
priority varchar(10) NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE tickets_priority ADD CONSTRAINT tickets_priority_pk PRIMARY KEY(id);
ALTER TABLE tickets_priority ADD CONSTRAINT tickets_priority_bk UNIQUE(priority_code);

CREATE TABLE products(
id serial,
product_code varchar(10) NOT NULL,
product_name varchar(100) NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);

ALTER TABLE products ADD CONSTRAINT products_pk PRIMARY KEY(id);
ALTER TABLE products ADD CONSTRAINT products_bk UNIQUE(product_code);

CREATE TABLE products_cust(
id serial,
product_id int NOT NULL,
customer_id INT NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);

ALTER TABLE products_cust ADD CONSTRAINT products_cust_pk PRIMARY KEY(id);
ALTER TABLE products_cust ADD CONSTRAINT products_products_cust_fk FOREIGN KEY(product_id) REFERENCES products(id);
ALTER TABLE products_cust ADD CONSTRAINT users_products_cust_fk FOREIGN KEY(customer_id) REFERENCES users(id);

CREATE TABLE tickets(
id serial,
code varchar(50) NOT NULL,
title varchar(100) NOT NULL,
content text NOT NULL,
ticket_status_id int NOT NULL,
ticket_priority_id int NOT NULL,
product_cust_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE tickets ADD CONSTRAINT tickets_pk PRIMARY KEY(id);
ALTER TABLE tickets ADD CONSTRAINT tickets_bk UNIQUE(code);
ALTER TABLE tickets ADD CONSTRAINT tickets_status_tickets_fk FOREIGN KEY(ticket_status_id) REFERENCES tickets_status(id);
ALTER TABLE tickets ADD CONSTRAINT tickets_priority_tickets_fk FOREIGN KEY(ticket_priority_id) REFERENCES tickets_priority(id);
ALTER TABLE tickets ADD CONSTRAINT products_cust_tickets_fk FOREIGN KEY(product_cust_id) REFERENCES products_cust(id);

CREATE TABLE comments(
id serial,
comments text NOT NULL,
comment_id int,
ticket_id int NOT NULL,
user_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE comments ADD CONSTRAINT comments_pk PRIMARY KEY(id);
ALTER TABLE comments ADD CONSTRAINT comments_comments_fk FOREIGN KEY(comment_id) REFERENCES comments(id);
ALTER TABLE comments ADD CONSTRAINT tickets_comments_fk FOREIGN KEY(ticket_id) REFERENCES tickets(id);

CREATE TABLE attachments_ticket(
id serial,
file_id int NOT NULL,
ticket_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE attachments_ticket ADD CONSTRAINT attachments_ticket_pk PRIMARY KEY(id);
ALTER TABLE attachments_ticket ADD CONSTRAINT files_attachments_ticket_fk FOREIGN KEY(file_id) REFERENCES files(id);
ALTER TABLE attachments_ticket ADD CONSTRAINT tickets_attachments_ticket_fk FOREIGN KEY(ticket_id) REFERENCES tickets(id);

CREATE TABLE attachments_comment(
id serial,
file_id int NOT NULL,
comment_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE attachments_comment ADD CONSTRAINT attachments_comment_pk PRIMARY KEY(id);
ALTER TABLE attachments_comment ADD CONSTRAINT files_attachments_comment_fk FOREIGN KEY(file_id) REFERENCES files(id);
ALTER TABLE attachments_comment ADD CONSTRAINT comments_attachments_comment_fk FOREIGN KEY(comment_id) REFERENCES comments(id);

--DML
INSERT INTO roles (role_code, role_name, created_by, created_at) VALUES
('SA1','Super Admin', 1, now()),
('PIC','PIC', 1, now()),
('CUS','Customer', 1, now()),
('SYS','System', 1, now());

INSERT INTO tickets_priority (priority_code, priority, created_by, created_at) VALUES
('P01', 'High', 1, now()),
('P02', 'Medium', 1, now()),
('P03', 'Low', 1, now());

INSERT INTO tickets_status (status_code, status, created_by, created_at) VALUES
('T01', 'Open', 1, now()),
('T02', 'Closed', 1, now()),
('T03', 'Re-open', 1, now());

INSERT INTO users (email, password, fullname, pic_id, company_id, role_id, created_by, created_at) VALUES
('system@email.com', '$2a$10$mQ77inhXemDEE0zlr9kwc.94nqJERo1uHIsaPjesr0upzK1Hm6cWa', 'System', NULL, NULL, 4, 1, now()),
('admin@email.com', '$2a$10$mQ77inhXemDEE0zlr9kwc.94nqJERo1uHIsaPjesr0upzK1Hm6cWa', 'Super Admin', NULL, NULL, 1, 1, now());