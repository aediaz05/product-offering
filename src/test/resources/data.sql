INSERT INTO PRICES(BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR)
SELECT BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, CAST(PRICE AS decimal(13, 4)), CURR
FROM CSVREAD('classpath:test.csv', NULL, 'charset=UTF-8');