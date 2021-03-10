CREATE TABLE public.book
(
    bookid bigserial NOT NULL,
    bookname character varying(12) NOT NULL,
    bookauthor character varying(12) NOT NULL,
    bookprice numeric(6, 2) NOT NULL,
    PRIMARY KEY (bookid)
);

ALTER TABLE public.book
    OWNER to postgres;