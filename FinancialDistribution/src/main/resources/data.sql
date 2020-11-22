insert into CATEGORIES (id, `name`,BALANCE, PERCENT, PURPOSEAMOUNT, COMMENT, ACTIVE)
values (1, 'Financial cushion', 50000.00, 10.00,800000.00,'For my financial cushion', 1);
insert into CATEGORIES (id, `name`,BALANCE, PERCENT, PURPOSEAMOUNT, COMMENT, ACTIVE)
values (3, 'OTUS', 0.00, 5.00,800000.00,'OTUS', 1);

insert into EXPENSE (ID, ID_CATEGORY, AMOUNT, `DATE`)
values (1, 1, 10.00, CURRENT_DATE);

insert into INCOME (ID, ID_CATEGORY, AMOUNT, `DATE`)
values (2, 1, 8.00, CURRENT_DATE);
insert into INCOME (ID, ID_CATEGORY, AMOUNT, `DATE`)
values (3, 1, 8.00, CURRENT_DATE);
insert into INCOME (ID, ID_CATEGORY, AMOUNT, `DATE`)
values (4, 1, 8.00, CURRENT_DATE);
insert into INCOME (ID, ID_CATEGORY, AMOUNT, `DATE`)
values (5, 3, 8.00, CURRENT_DATE);
insert into INCOME (ID, ID_CATEGORY, AMOUNT, `DATE`)
values (6, 3, 8.00, CURRENT_DATE);
insert into INCOME (ID, ID_CATEGORY, AMOUNT, `DATE`)
values (7, 3, 8.00, CURRENT_DATE);

insert into EXCHANGE_RATE (ID, `NAME`, PRICE, `DATE`)
values (1, 'USD', 71.85, CURRENT_DATE);
insert into EXCHANGE_RATE (ID, `NAME`, PRICE, `DATE`)
values (2, 'EUR', 90.85, CURRENT_DATE);

insert into BALANCES (ID, ID_CATEGORY, VALUTE, BALANCE, `DATE`)
values (1, 1, 'USD', 647.00, CURRENT_DATE);
insert into BALANCES (ID, ID_CATEGORY, VALUTE, BALANCE, `DATE`)
values (2, 1, 'EUR', 549.45, CURRENT_DATE);
insert into BALANCES (ID, ID_CATEGORY, VALUTE, BALANCE, `DATE`)
values (3, 3, 'USD', 700.00, CURRENT_DATE);
insert into BALANCES (ID, ID_CATEGORY, VALUTE, BALANCE, `DATE`)
values (4, 3, 'EUR', 800.45, CURRENT_DATE);

--USER
insert into `USER` (ID, USERNAME, PASSWORD)
values (1, 'BOB', '123');

insert into `USER` (ID, USERNAME, PASSWORD)
values (2, 'SVETA', '123');

insert into `USER` (ID, USERNAME, PASSWORD)
values (3, 'PETR', '123');

--ROLES
insert into `ROLE` (ID, `NAME`, ID_USER)
values (1, 'ROLE_USER', 1);

insert into `ROLE` (ID, `NAME`,ID_USER)
values (2, 'ROLE_ADMIN', 1);

insert into `ROLE` (ID, `NAME`,ID_USER)
values (3, 'ROLE_MANAGER', 2);

insert into `ROLE` (ID, `NAME`, ID_USER)
values (4, 'ROLE_USER', 3);

