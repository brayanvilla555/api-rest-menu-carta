-- PostgreSQL database dump

-- Name: carta-menu; Type: DATABASE; Owner: postgres
CREATE DATABASE "carta-menu"
    WITH TEMPLATE = template0
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = libc
    LOCALE = 'es_PE.UTF-8';

ALTER DATABASE "carta-menu" OWNER TO postgres;

\connect "carta-menu"

-- Table: public.categoria
CREATE TABLE public.categoria (
                                  id SERIAL PRIMARY KEY,
                                  nombre VARCHAR(100) NOT NULL UNIQUE,
                                  descripcion VARCHAR(500) NOT NULL
);

-- Table: public.detalle
CREATE TABLE public.detalle (
                                id SERIAL PRIMARY KEY,
                                descuento REAL,
                                detalle_completo VARCHAR(1000),
                                procedencia VARCHAR(255),
                                video VARCHAR(255)
);

-- Table: public.file
CREATE TABLE public.file (
                             id SERIAL PRIMARY KEY,
                             extencion VARCHAR(255),
                             nombre VARCHAR(255),
                             path VARCHAR(255)
);

-- Table: public.producto
CREATE TABLE public.producto (
                                 id SERIAL PRIMARY KEY,
                                 nombre VARCHAR(255) NOT NULL,
                                 descripcion VARCHAR(500),
                                 precio REAL,
                                 calificacion REAL,
                                 id_categoria INTEGER NOT NULL,
                                 id_detalle INTEGER UNIQUE,
                                 id_file INTEGER UNIQUE,
                                 CONSTRAINT fk_categoria FOREIGN KEY (id_categoria) REFERENCES public.categoria (id),
                                 CONSTRAINT fk_detalle FOREIGN KEY (id_detalle) REFERENCES public.detalle (id),
                                 CONSTRAINT fk_file FOREIGN KEY (id_file) REFERENCES public.file (id)
);
