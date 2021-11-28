CREATE SEQUENCE public.product_id_seq;

CREATE TABLE product (
                product_id INTEGER NOT NULL DEFAULT nextval('public.product_id_seq'),
                name VARCHAR NOT NULL,
                CONSTRAINT product_pk PRIMARY KEY (product_id)
);

CREATE SEQUENCE public.order_id_seq;


CREATE TABLE order_1 (
                order_id INTEGER NOT NULL DEFAULT nextval('public.order_id_seq'),
                date DATE NOT NULL,
                customer_name VARCHAR NOT NULL,
                CONSTRAINT order_1_pk PRIMARY KEY (order_id)
);



CREATE TABLE order_detail (
                product_id INTEGER NOT NULL,
                order_id INTEGER NOT NULL,
                CONSTRAINT order_detail_pk PRIMARY KEY (product_id, order_id)
);


CREATE SEQUENCE public.customer_id_seq;

CREATE TABLE customer (
		customer_id INTEGER NOT NULL DEFAULT nextval('public.customer_id_seq'),
                name VARCHAR NOT NULL,
                address VARCHAR NOT NULL,
                CONSTRAINT customer_pk PRIMARY KEY (customer_id)
);

CREATE SEQUENCE public.professor_id_seq;

CREATE TABLE professor (
                professor_id INTEGER NOT NULL DEFAULT nextval('public.professor_id_seq'),
                office_number VARCHAR NOT NULL,
                research_area VARCHAR NOT NULL,
                customer_id INTEGER NOT NULL,
                CONSTRAINT professor_pk PRIMARY KEY (professor_id)
);


ALTER TABLE order_detail ADD CONSTRAINT product_order_detail_fk
FOREIGN KEY (product_id)
REFERENCES product (product_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE order_detail ADD CONSTRAINT order_order_detail_fk
FOREIGN KEY (order_id)
REFERENCES order_1 (order_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE professor ADD CONSTRAINT customer_professor_fk
FOREIGN KEY (customer_id)
REFERENCES customer (customer_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
