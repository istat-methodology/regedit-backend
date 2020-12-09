--
-- PostgreSQL database dump
-- Dumped from database version 11.5
-- Dumped by pg_dump version 11.2

DROP SCHEMA IF EXISTS regedit_gateway CASCADE;
CREATE SCHEMA regedit_gateway;

DO '
BEGIN
execute ''alter database ''||current_database()||'' set search_path to is2,public;'';
END;
';

SET search_path to regedit_gateway,public;
SET default_tablespace = '';
SET default_with_oids = false;

CREATE TABLE regedit_gateway.is2_user_roles (
    id integer NOT NULL,
    role character varying(50) DEFAULT NULL::character varying
);

CREATE TABLE regedit_gateway.is2_users (
    id integer NOT NULL,
    email character varying(255),
    name character varying(100),
    surname character varying(100),
    password character varying(500),
    role_id integer NOT NULL
);

CREATE TABLE regedit_gateway.is2_jwttoken (
    token character varying(200)
);