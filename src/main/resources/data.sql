-- insert into products (product_id, productname ,productdescription, productcategory, productprice, productquantity)
insert into products (product_id, productname ,productdescription, productURL, productcategory, productprice, availablequantity, ISACTIVATED)
values (0, 'coca-cola', 'Carbonated drink', 'www.cocacolapicture', 'Beverages', '2.99', '100', true);
insert into products (product_id, productname ,productdescription, productURL, productcategory, productprice, availablequantity, ISACTIVATED)
values (1, 'Hamburgher', 'Meat between bread bun', 'www.hamburgher.com', 'Meal', '10.99', '20', true);
insert into users (user_id, username,password)
values (0, 'admin', 'password');
insert into users (user_id, username,password)
values (1, 'mdt', 'password');
insert into cart_Sessions (cart_Session_id, user_id)
values (0, 1);
insert into cart_Sessions (cart_Session_id, user_id)
values (1, 1);
insert into carts (cart_id, productquantity,producttotal, product_id, cart_Session_id)
values (0, 100, 300, 0, 0);
insert into carts (cart_id, productquantity,producttotal, product_id, cart_Session_id)
values (1, 10.99,10.99, 0, 0);
insert into carts (cart_id, productquantity,producttotal, product_id, cart_Session_id)
values (2, 100, 300, 0, 1);
insert into carts (cart_id, productquantity,producttotal, product_id, cart_Session_id)
values (3, 10.99,10.99, 0, 1);




-- insert into users (user_id, username,password)
-- values (2, 'dave', 'password');

-- insert into users (user_id, username,password)
-- values (3, 'mary', 'password');
