select * from users;
select * from categories;
select * from products;

category_id

SELECT * FROM (SELECT product_id, category_id, p.name p_name, price, c.name c_name, description FROM categories c JOIN products p ON c.id = p.category_id) a;
	

