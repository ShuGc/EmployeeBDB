CREATE TABLE public.employee
(
    id_emp bigint NOT NULL,
    fullname character varying(255) COLLATE pg_catalog."default" NOT NULL,
    function character varying(255) COLLATE pg_catalog."default" NOT NULL,
    id_boss bigint NOT NULL,
    CONSTRAINT employee_pkey PRIMARY KEY (id_emp)
)
