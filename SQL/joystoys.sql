--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categories (
    category_id integer NOT NULL,
    category_name character varying(255)
);


ALTER TABLE public.categories OWNER TO postgres;

--
-- Name: categories_category_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categories_category_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categories_category_id_seq OWNER TO postgres;

--
-- Name: categories_category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categories_category_id_seq OWNED BY public.categories.category_id;


--
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    customer_id integer NOT NULL,
    name character varying(255) NOT NULL,
    email character varying(255),
    address character varying(255),
    phonenumber character varying(255),
    username character varying(25),
    password bytea
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- Name: customer_customer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customer_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_customer_id_seq OWNER TO postgres;

--
-- Name: customer_customer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customer_customer_id_seq OWNED BY public.customer.customer_id;


--
-- Name: customer_order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer_order (
    customer_order_id integer NOT NULL,
    customer_order_date timestamp with time zone NOT NULL,
    customer_id integer
);


ALTER TABLE public.customer_order OWNER TO postgres;

--
-- Name: customer_order_customer_order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customer_order_customer_order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_order_customer_order_id_seq OWNER TO postgres;

--
-- Name: customer_order_customer_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customer_order_customer_order_id_seq OWNED BY public.customer_order.customer_order_id;


--
-- Name: customer_order_product_association; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer_order_product_association (
    customer_order_product_association_id integer NOT NULL,
    customer_order_id integer,
    product_id integer,
    quantity integer
);


ALTER TABLE public.customer_order_product_association OWNER TO postgres;

--
-- Name: customer_order_product_associ_customer_order_product_associ_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customer_order_product_associ_customer_order_product_associ_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_order_product_associ_customer_order_product_associ_seq OWNER TO postgres;

--
-- Name: customer_order_product_associ_customer_order_product_associ_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customer_order_product_associ_customer_order_product_associ_seq OWNED BY public.customer_order_product_association.customer_order_product_association_id;


--
-- Name: customer_transactions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer_transactions (
    customer_transaction_id integer NOT NULL,
    amount_paid numeric,
    customer_order_id integer,
    payment_information_id integer
);


ALTER TABLE public.customer_transactions OWNER TO postgres;

--
-- Name: customer_transactions_customer_transaction_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customer_transactions_customer_transaction_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_transactions_customer_transaction_id_seq OWNER TO postgres;

--
-- Name: customer_transactions_customer_transaction_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customer_transactions_customer_transaction_id_seq OWNED BY public.customer_transactions.customer_transaction_id;


--
-- Name: delivery; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.delivery (
    delivery_id integer NOT NULL,
    expected_delivery_date timestamp with time zone NOT NULL,
    arrival_date timestamp with time zone NOT NULL,
    inventory_order_id integer,
    supplier_id integer
);


ALTER TABLE public.delivery OWNER TO postgres;

--
-- Name: delivery_delivery_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.delivery_delivery_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.delivery_delivery_id_seq OWNER TO postgres;

--
-- Name: delivery_delivery_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.delivery_delivery_id_seq OWNED BY public.delivery.delivery_id;


--
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    employee_id integer NOT NULL,
    name character varying(255),
    email character varying(255),
    address character varying(255),
    phonenumber character varying(255),
    bank_account_number integer,
    hours_worked integer,
    job_id integer
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- Name: employee_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.employee_employee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_employee_id_seq OWNER TO postgres;

--
-- Name: employee_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.employee_employee_id_seq OWNED BY public.employee.employee_id;


--
-- Name: inventory_order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inventory_order (
    inventory_order_id integer NOT NULL,
    inventory_order_date timestamp with time zone NOT NULL,
    purchasingpriceperunit numeric,
    product_id integer,
    supplier_id integer
);


ALTER TABLE public.inventory_order OWNER TO postgres;

--
-- Name: inventory_order_inventory_order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.inventory_order_inventory_order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.inventory_order_inventory_order_id_seq OWNER TO postgres;

--
-- Name: inventory_order_inventory_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.inventory_order_inventory_order_id_seq OWNED BY public.inventory_order.inventory_order_id;


--
-- Name: inventory_transactions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inventory_transactions (
    transaction_id integer NOT NULL,
    amount_paid numeric,
    inventory_order_id integer
);


ALTER TABLE public.inventory_transactions OWNER TO postgres;

--
-- Name: inventory_transactions_transaction_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.inventory_transactions_transaction_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.inventory_transactions_transaction_id_seq OWNER TO postgres;

--
-- Name: inventory_transactions_transaction_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.inventory_transactions_transaction_id_seq OWNED BY public.inventory_transactions.transaction_id;


--
-- Name: job_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.job_role (
    job_id integer NOT NULL,
    hourly_rate numeric,
    job_title character varying(255)
);


ALTER TABLE public.job_role OWNER TO postgres;

--
-- Name: job_role_job_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.job_role_job_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.job_role_job_id_seq OWNER TO postgres;

--
-- Name: job_role_job_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.job_role_job_id_seq OWNED BY public.job_role.job_id;


--
-- Name: payment_information; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.payment_information (
    payment_information_id integer NOT NULL,
    credit_card_number character varying(255),
    kind integer,
    customer_id integer
);


ALTER TABLE public.payment_information OWNER TO postgres;

--
-- Name: payment_information_payment_information_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.payment_information_payment_information_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.payment_information_payment_information_id_seq OWNER TO postgres;

--
-- Name: payment_information_payment_information_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.payment_information_payment_information_id_seq OWNED BY public.payment_information.payment_information_id;


--
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    product_id integer NOT NULL,
    product_name character varying(255),
    price numeric,
    product_stock integer,
    imageurl character varying(255),
    category integer
);


ALTER TABLE public.products OWNER TO postgres;

--
-- Name: products_product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.products_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_product_id_seq OWNER TO postgres;

--
-- Name: products_product_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.products_product_id_seq OWNED BY public.products.product_id;


--
-- Name: restocking_logistics; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.restocking_logistics (
    restocking_logistics_id integer NOT NULL,
    product_id integer,
    inventory_order_id integer,
    quantity integer
);


ALTER TABLE public.restocking_logistics OWNER TO postgres;

--
-- Name: restocking_logistics_restocking_logistics_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.restocking_logistics_restocking_logistics_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.restocking_logistics_restocking_logistics_id_seq OWNER TO postgres;

--
-- Name: restocking_logistics_restocking_logistics_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.restocking_logistics_restocking_logistics_id_seq OWNED BY public.restocking_logistics.restocking_logistics_id;


--
-- Name: suppliers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.suppliers (
    supplier_id integer NOT NULL,
    name character varying(255),
    address character varying(255),
    phonenumber character varying(255),
    email character varying(255)
);


ALTER TABLE public.suppliers OWNER TO postgres;

--
-- Name: suppliers_supplier_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.suppliers_supplier_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.suppliers_supplier_id_seq OWNER TO postgres;

--
-- Name: suppliers_supplier_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.suppliers_supplier_id_seq OWNED BY public.suppliers.supplier_id;


--
-- Name: categories category_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories ALTER COLUMN category_id SET DEFAULT nextval('public.categories_category_id_seq'::regclass);


--
-- Name: customer customer_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer ALTER COLUMN customer_id SET DEFAULT nextval('public.customer_customer_id_seq'::regclass);


--
-- Name: customer_order customer_order_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer_order ALTER COLUMN customer_order_id SET DEFAULT nextval('public.customer_order_customer_order_id_seq'::regclass);


--
-- Name: customer_order_product_association customer_order_product_association_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer_order_product_association ALTER COLUMN customer_order_product_association_id SET DEFAULT nextval('public.customer_order_product_associ_customer_order_product_associ_seq'::regclass);


--
-- Name: customer_transactions customer_transaction_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer_transactions ALTER COLUMN customer_transaction_id SET DEFAULT nextval('public.customer_transactions_customer_transaction_id_seq'::regclass);


--
-- Name: delivery delivery_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.delivery ALTER COLUMN delivery_id SET DEFAULT nextval('public.delivery_delivery_id_seq'::regclass);


--
-- Name: employee employee_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee ALTER COLUMN employee_id SET DEFAULT nextval('public.employee_employee_id_seq'::regclass);


--
-- Name: inventory_order inventory_order_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory_order ALTER COLUMN inventory_order_id SET DEFAULT nextval('public.inventory_order_inventory_order_id_seq'::regclass);


--
-- Name: inventory_transactions transaction_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory_transactions ALTER COLUMN transaction_id SET DEFAULT nextval('public.inventory_transactions_transaction_id_seq'::regclass);


--
-- Name: job_role job_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_role ALTER COLUMN job_id SET DEFAULT nextval('public.job_role_job_id_seq'::regclass);


--
-- Name: payment_information payment_information_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment_information ALTER COLUMN payment_information_id SET DEFAULT nextval('public.payment_information_payment_information_id_seq'::regclass);


--
-- Name: products product_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products ALTER COLUMN product_id SET DEFAULT nextval('public.products_product_id_seq'::regclass);


--
-- Name: restocking_logistics restocking_logistics_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restocking_logistics ALTER COLUMN restocking_logistics_id SET DEFAULT nextval('public.restocking_logistics_restocking_logistics_id_seq'::regclass);


--
-- Name: suppliers supplier_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suppliers ALTER COLUMN supplier_id SET DEFAULT nextval('public.suppliers_supplier_id_seq'::regclass);


--
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categories (category_id, category_name) FROM stdin;
1	Action_Figures
2	Barbie_Dolls
3	Baby_Dolls
4	Toy_Guns
5	Toy_Cars
6	Sports
7	Arts_Crafts
\.


--
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (customer_id, name, email, address, phonenumber, username, password) FROM stdin;
1	Sam	none@none.com	123 nowhere st	-2119	SamIAm	\\x243261243130246558617174424e6f70355a4b7252466753556768424f427847736b4f4d786631516734337047325047507950596a424a6d54326665
4	Kathleen	katLady@none.com	234 onfire ln	919-345-1010	creepyKat	\\x6d656f773432303639
5	Ben	user@none.com	234 yourname drive	919-345-2334	BenRules	\\x6869746c65727375636b733233
7	Janet	user@bs.com	234 yourname drive	919-345-2334	JanetPasty	\N
9	Mark	user@bs.com	234 yourname drive	919-345-2334	MarktheMan	\\x2432612431302436727165436d705935434d7972384c776c6b34336c4f784c747950514d6d644b36556e7147753547335033385368417a3377477232
\.


--
-- Data for Name: customer_order; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer_order (customer_order_id, customer_order_date, customer_id) FROM stdin;
1	2023-04-23 16:15:17.268382-04	1
5	2023-04-23 17:58:26.18-04	1
6	2023-04-23 17:59:35.948-04	1
7	2023-04-23 18:03:21.292-04	1
8	2023-04-23 18:08:27.657-04	1
9	2023-04-23 18:12:04.721-04	1
11	2023-05-06 15:08:24.119-04	1
14	2023-05-06 19:35:41.568-04	1
15	2023-05-06 19:37:08.703-04	1
16	2023-05-06 19:40:44.795-04	1
17	2023-05-06 19:43:26.923-04	1
18	2023-05-06 19:45:39.642-04	1
19	2023-05-06 20:48:19.784-04	1
\.


--
-- Data for Name: customer_order_product_association; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer_order_product_association (customer_order_product_association_id, customer_order_id, product_id, quantity) FROM stdin;
1	1	1	2
2	1	2	4
3	\N	3	5
6	5	1	6
7	6	1	6
8	7	1	6
9	8	1	6
10	9	1	6
11	11	5	2
12	11	12	3
15	14	5	2
16	14	12	3
17	15	12	3
18	15	5	2
19	16	12	3
20	16	5	2
21	17	11	3
22	17	6	2
23	18	6	2
24	18	11	3
25	19	6	2
26	19	11	3
\.


--
-- Data for Name: customer_transactions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer_transactions (customer_transaction_id, amount_paid, customer_order_id, payment_information_id) FROM stdin;
4	347.00	\N	1
5	149.00	\N	1
6	149.00	18	1
7	149.00	19	1
\.


--
-- Data for Name: delivery; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.delivery (delivery_id, expected_delivery_date, arrival_date, inventory_order_id, supplier_id) FROM stdin;
\.


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (employee_id, name, email, address, phonenumber, bank_account_number, hours_worked, job_id) FROM stdin;
\.


--
-- Data for Name: inventory_order; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inventory_order (inventory_order_id, inventory_order_date, purchasingpriceperunit, product_id, supplier_id) FROM stdin;
1	2023-04-09 16:44:15.766009-04	100	1	1
\.


--
-- Data for Name: inventory_transactions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inventory_transactions (transaction_id, amount_paid, inventory_order_id) FROM stdin;
\.


--
-- Data for Name: job_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.job_role (job_id, hourly_rate, job_title) FROM stdin;
\.


--
-- Data for Name: payment_information; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.payment_information (payment_information_id, credit_card_number, kind, customer_id) FROM stdin;
1	1234-3434-7676-8899	1	9
\.


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.products (product_id, product_name, price, product_stock, imageurl, category) FROM stdin;
3	Neoson 24 Pack Pokeballs	30.00	25	http://localhost:80/JoysToysImages/ActionFigures/neoson24pcspokeballs.jpg	1
4	Spider-man Titan Series	7.50	35	http://localhost:80/JoysToysImages/ActionFigures/titanSpiderman.jpg	1
1	Midfight Goku	9.00	30	http://localhost:80/JoysToysImages/ActionFigures/gokuActionFigure.jpg	1
2	Monkey D Luffe	9.00	30	http://localhost:80/JoysToysImages/ActionFigures/monkeydluffeactionfigure.jpg	1
5	Barbie Fantasy Hair Doll	16.00	30	http://localhost/JoysToysImages/BarbieDolls/barbiefantasyhairdoll.jpg	2
6	Barbie Stroller Pups	7.00	30	http://localhost/JoysToysImages/BarbieDolls/barbiestrollerpups.jpg	2
7	Sparkling Pink Barbie Doll	3.00	30	http://localhost/JoysToysImages/BarbieDolls/sparklingpinkbarbie.jpg	2
8	Adora Soft Baby Doll - machine washable	15.00	30	http://localhost/JoysToysImages/BabyDolls/adorasoftbabydoll-machinewashable.jpg	3
9	Twin Baby Doll set	24.00	30	http://localhost/JoysToysImages/BabyDolls/twinbabydolls.jpg	3
10	Bushmaster BMPX-Full Auto BB gun	65.00	30	http://localhost/JoysToysImages/BBGuns/bushmasterbmpwxfullauto.jpg	4
11	Crosman MK45 BB gun	45.00	30	http://localhost/JoysToysImages/BBGuns/crosmanmk45.jpg	4
12	DPMS Full Auto BB gun	105.00	30	http://localhost/JoysToysImages/BBGuns/dpmsfullautobbgun.jpg	4
13	Glock Gen 3 BB gun	35.00	30	http://localhost/JoysToysImages/BBGuns/glockgen3bbgun.jpg	4
14	Umarex DX17 BB gun	60.00	30	http://localhost/JoysToysImages/BBGuns/umarexdx17bbgun.jpg	4
15	NERF Fortnite BASR-L	45.00	30	http://localhost/JoysToysImages/NerfGuns/nerffortniteBASR-L.jpg	4
16	NERF Micro Shots - 6 blaster bundle	75.00	30	http://localhost/JoysToysImages/NerfGuns/nerfmicroshots-6blasterbundle.jpg	4
17	NERF Rival Nemesis	105.00	30	http://localhost/JoysToysImages/NerfGuns/nerfrivalnemesis.jpg	4
18	Seymour Toy Guns - Automatic Sniper Rifle	40.00	30	http://localhost/JoysToysImages/NerfGuns/semourtoyguns-automaticsniperrifle.jpg	4
19	Hot Wheels 50 car pack	25.00	30	http://localhost/JoysToysImages/HotWheels/hotwheels50carpack.jpg	5
20	Hot Wheels Massive Loop Launcher	34.00	30	http://localhost/JoysToysImages/HotWheels/hotwheelsmassivelooplauncher.jpg	5
21	Hot Wheels 4 Way Intersection Crash track	15.00	30	http://localhost/JoysToysImages/HotWheels/hotwheelstrack4wayintersection.jpg	5
22	Aluminum Baseball Bat	15.00	30	http://localhost/JoysToysImages/Sports/aluminumbat.jpg	6
23	Beechwood Baseball Bat	29.00	30	http://localhost/JoysToysImages/Sports/beechwoodbat.jpg	6
24	Franklin Junior Football	9.00	30	http://localhost/JoysToysImages/Sports/Franklin-JuniorFootball.jpg	6
25	Hit Run Steal Bucket of Baseballs	40.00	30	http://localhost/JoysToysImages/Sports/hitrunstealbucketofbaseballs.jpg	6
26	Pecogo Volleyball	5.00	30	http://localhost/JoysToysImages/Sports/pecogo-volleyball.jpg	6
27	Rawlings Baseball Gloves	11.00	30	http://localhost/JoysToysImages/Sports/rawlings-baseballglove.jpg	6
28	Tachikara Volleyball	5.00	30	http://localhost/JoysToysImages/Sports/tachikara-volleyball.jpg	6
29	Wilson Evolution Basketball	25.00	30	http://localhost/JoysToysImages/Sports/wilson-evolutionbasketball.jpg	6
30	Wilson NCAA Indoor/Outdoor Basketball	20.00	30	http://localhost/JoysToysImages/Sports/wilson-ncaaindooroutdoorbasketball.jpg	6
31	Wilson NFL Football	9.00	30	http://localhost/JoysToysImages/Sports/wilsonnflfootball.jpg	6
32	Air Dry Clay 36 colors	20.00	30	http://localhost/JoysToysImages/Arts_Crafts/airdryclay-36colors.jpg	7
33	Coloring & Tracing Animals	6.00	30	http://localhost/JoysToysImages/Arts_Crafts/animals-coloringandtracing.jpg	7
34	Big Letter Tracing Book forToddlers	7.00	30	http://localhost/JoysToysImages/Arts_Crafts/biglettertracingbookfortoddlers.jpg	7
35	Gem Art 50Gems	3.00	30	http://localhost/JoysToysImages/Arts_Crafts/gemart-5dgems.jpg	7
36	Glow In The Dark Rock Painting	15.00	30	http://localhost/JoysToysImages/Arts_Crafts/glowinthedarkrockpainting.jpg	7
37	Halloween Trace & Color	5.00	30	http://localhost/JoysToysImages/Arts_Crafts/halloween-traceandcolor.jpg	7
38	How to draw Anime	5.00	30	http://localhost/JoysToysImages/Arts_Crafts/howtodrawanime.jpg	7
39	How to Draw Superheroes	5.00	30	http://localhost/JoysToysImages/Arts_Crafts/howtodrawsuperheroes.jpg	7
40	iBayam 50 pack wooden art set	25.00	30	http://localhost/JoysToysImages/Arts_Crafts/ibayam-150packwoodenartset.jpg	7
41	Trace and escape - tracing book	5.00	30	http://localhost/JoysToysImages/Arts_Crafts/traceandescape.jpg	7
42	Tracing Lines, Shapes, and Words - Preschool	4.00	30	http://localhost/JoysToysImages/Arts_Crafts/tracinglinesshapesandwords-preschool.jpg	7
43	Tracing Paper	2.00	30	http://localhost/JoysToysImages/Arts_Crafts/tracingpaper.jpg	7
\.


--
-- Data for Name: restocking_logistics; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.restocking_logistics (restocking_logistics_id, product_id, inventory_order_id, quantity) FROM stdin;
1	1	1	10
\.


--
-- Data for Name: suppliers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.suppliers (supplier_id, name, address, phonenumber, email) FROM stdin;
1	Hasbro	555 plastic road, Buena Vista, CA	315-555-0044	none@hasbro.com
\.


--
-- Name: categories_category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categories_category_id_seq', 7, true);


--
-- Name: customer_customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_customer_id_seq', 9, true);


--
-- Name: customer_order_customer_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_order_customer_order_id_seq', 19, true);


--
-- Name: customer_order_product_associ_customer_order_product_associ_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_order_product_associ_customer_order_product_associ_seq', 26, true);


--
-- Name: customer_transactions_customer_transaction_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customer_transactions_customer_transaction_id_seq', 7, true);


--
-- Name: delivery_delivery_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.delivery_delivery_id_seq', 1, false);


--
-- Name: employee_employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.employee_employee_id_seq', 1, false);


--
-- Name: inventory_order_inventory_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.inventory_order_inventory_order_id_seq', 1, true);


--
-- Name: inventory_transactions_transaction_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.inventory_transactions_transaction_id_seq', 1, false);


--
-- Name: job_role_job_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.job_role_job_id_seq', 1, false);


--
-- Name: payment_information_payment_information_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.payment_information_payment_information_id_seq', 1, true);


--
-- Name: products_product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_product_id_seq', 43, true);


--
-- Name: restocking_logistics_restocking_logistics_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.restocking_logistics_restocking_logistics_id_seq', 1, true);


--
-- Name: suppliers_supplier_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.suppliers_supplier_id_seq', 1, true);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (category_id);


--
-- Name: customer_order customer_order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer_order
    ADD CONSTRAINT customer_order_pkey PRIMARY KEY (customer_order_id);


--
-- Name: customer_order_product_association customer_order_product_associa_customer_order_id_product_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer_order_product_association
    ADD CONSTRAINT customer_order_product_associa_customer_order_id_product_id_key UNIQUE (customer_order_id, product_id);


--
-- Name: customer_order_product_association customer_order_product_association_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer_order_product_association
    ADD CONSTRAINT customer_order_product_association_pkey PRIMARY KEY (customer_order_product_association_id);


--
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customer_id);


--
-- Name: customer_transactions customer_transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer_transactions
    ADD CONSTRAINT customer_transactions_pkey PRIMARY KEY (customer_transaction_id);


--
-- Name: delivery delivery_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.delivery
    ADD CONSTRAINT delivery_pkey PRIMARY KEY (delivery_id);


--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (employee_id);


--
-- Name: inventory_order inventory_order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory_order
    ADD CONSTRAINT inventory_order_pkey PRIMARY KEY (inventory_order_id);


--
-- Name: inventory_transactions inventory_transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory_transactions
    ADD CONSTRAINT inventory_transactions_pkey PRIMARY KEY (transaction_id);


--
-- Name: job_role job_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.job_role
    ADD CONSTRAINT job_role_pkey PRIMARY KEY (job_id);


--
-- Name: payment_information payment_information_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment_information
    ADD CONSTRAINT payment_information_pkey PRIMARY KEY (payment_information_id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (product_id);


--
-- Name: restocking_logistics restocking_logistics_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restocking_logistics
    ADD CONSTRAINT restocking_logistics_pkey PRIMARY KEY (restocking_logistics_id);


--
-- Name: restocking_logistics restocking_logistics_product_id_inventory_order_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restocking_logistics
    ADD CONSTRAINT restocking_logistics_product_id_inventory_order_id_key UNIQUE (product_id, inventory_order_id);


--
-- Name: suppliers suppliers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.suppliers
    ADD CONSTRAINT suppliers_pkey PRIMARY KEY (supplier_id);


--
-- Name: customer_order customer_order_customer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer_order
    ADD CONSTRAINT customer_order_customer_id_fkey FOREIGN KEY (customer_id) REFERENCES public.customer(customer_id);


--
-- Name: customer_order_product_association customer_order_product_association_customer_order_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer_order_product_association
    ADD CONSTRAINT customer_order_product_association_customer_order_id_fkey FOREIGN KEY (customer_order_id) REFERENCES public.customer_order(customer_order_id);


--
-- Name: customer_order_product_association customer_order_product_association_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer_order_product_association
    ADD CONSTRAINT customer_order_product_association_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.products(product_id);


--
-- Name: customer_transactions customer_transactions_customer_order_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer_transactions
    ADD CONSTRAINT customer_transactions_customer_order_id_fkey FOREIGN KEY (customer_order_id) REFERENCES public.customer_order(customer_order_id);


--
-- Name: customer_transactions customer_transactions_payment_information_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer_transactions
    ADD CONSTRAINT customer_transactions_payment_information_id_fkey FOREIGN KEY (payment_information_id) REFERENCES public.payment_information(payment_information_id);


--
-- Name: delivery delivery_inventory_order_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.delivery
    ADD CONSTRAINT delivery_inventory_order_id_fkey FOREIGN KEY (inventory_order_id) REFERENCES public.inventory_order(inventory_order_id);


--
-- Name: delivery delivery_supplier_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.delivery
    ADD CONSTRAINT delivery_supplier_id_fkey FOREIGN KEY (supplier_id) REFERENCES public.suppliers(supplier_id);


--
-- Name: employee employee_job_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_job_id_fkey FOREIGN KEY (job_id) REFERENCES public.job_role(job_id);


--
-- Name: inventory_order inventory_order_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory_order
    ADD CONSTRAINT inventory_order_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.products(product_id);


--
-- Name: inventory_order inventory_order_supplier_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory_order
    ADD CONSTRAINT inventory_order_supplier_id_fkey FOREIGN KEY (supplier_id) REFERENCES public.suppliers(supplier_id);


--
-- Name: inventory_transactions inventory_transactions_inventory_order_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventory_transactions
    ADD CONSTRAINT inventory_transactions_inventory_order_id_fkey FOREIGN KEY (inventory_order_id) REFERENCES public.inventory_order(inventory_order_id);


--
-- Name: payment_information payment_information_customer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment_information
    ADD CONSTRAINT payment_information_customer_id_fkey FOREIGN KEY (customer_id) REFERENCES public.customer(customer_id);


--
-- Name: products products_category_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_category_fkey FOREIGN KEY (category) REFERENCES public.categories(category_id);


--
-- Name: restocking_logistics restocking_logistics_inventory_order_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restocking_logistics
    ADD CONSTRAINT restocking_logistics_inventory_order_id_fkey FOREIGN KEY (inventory_order_id) REFERENCES public.inventory_order(inventory_order_id);


--
-- Name: restocking_logistics restocking_logistics_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restocking_logistics
    ADD CONSTRAINT restocking_logistics_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.products(product_id);


--
-- PostgreSQL database dump complete
--

