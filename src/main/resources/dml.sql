--TRUNCATE books CASCADE;
--TRUNCATE users CASCADE;
--TRUNCATE orders CASCADE;
--TRUNCATE order_items CASCADE;

INSERT INTO books (isbn, title, author, pages, cover, price)
VALUES
    ('1234-4435', 'To Kill a Mockingbird', 'Harper Lee', 340, 0, 27.50),
    ('1234-5678', '1984', 'George Orwell', 310, 0, 35.90),
    ('1234-7654', 'Harry Potter', 'J.K. Rowling', 250, 0, 18.75),
    ('1234-6788', 'The Great Gatsby', 'F. Scott Fitzgerald', 280, 0, 15.70),
    ('1234-6789', 'Airport', 'Artur Hailey', 350, 0, 15.70),
    ('1234-6768', 'Hotel', 'Artur Hailey', 330, 0, 12.70),
    ('1234-7767', 'Financier', 'Teodor Drayzer', 430, 0, 23.50),
    ('1234-7768', 'Titan', 'Teodor Drayzer', 430, 0, 23.50),
    ('1234-7769', 'Stoic', 'Teodor Drayzer', 440, 0, 21.80),
    ('1234-5697', 'The Silence of the Lambs', 'Thomas Harris', 240, 0, 16.80),
    ('1234-1298', 'The Godfather', 'Mario Puzo', 270, 1, 14.40),
    ('1234-8734', 'On the Road', 'Jack Kerouac', 240, 1, 14.90),
    ('1234-0989', 'Fahrenheit 451', 'Ray Bradbury', 320, 1, 22.70),
    ('1234-3476', 'Invisible Man', 'Ralph Ellison', 345, 1, 25.70),
    ('1234-1249', 'The Day of the Triffids', 'John Wyndha', 320, 1, 24.70),
    ('1234-1254', 'East of Eden', 'John Steinbeck', 320, 1, 16.50),
    ('1234-1267', 'The Naked and the Dead', 'Norman Mailer', 250, 1, 12.30),
    ('1234-1275', 'Black Boy', 'Richard Wright', 240, 1, 12.50),
    ('1234-1456', 'The Grapes of Wrath', 'John Steinbeck', 230, 1, 21.80),
    ('1234-1549', 'Tobacco Road', 'Erskine Caldwell', 270, 1, 26.50);

INSERT INTO users (last_name, email, password, role)
VALUES
    ('Smith', 'smith@mail.com', '96bcf8c98f94b6ace4a4b716cf0e3b32743a08b1', 1),
    ('Petrov', 'petrov@mail.com', 'c82612d9fbce56f3250c04be08d82895269ea3d5', 1),
    ('Sidorov', 'sidorov@mail.com', 'e280f83395343e0121e3251f1970ce6d6561fe66', 2),
    ('Depp', 'depp@mail.com', '8bee3c50aefc29f6c05b799c42eba5a410c22184', 2),
    ('Carry', 'carry@mail.com', '9fb4116e8c2c9a141c01ad84ef4374b890782f1e', 2),
    ('Pit', 'pit@mail.com', '9fb4116e8c2c9a141c01ad84ef4374b890782f1e', 2),
    ('Chan', 'chan@mail.com', '9fb4116e8c2c9a141c01ad84ef4374b890782f1e', 2),
    ('Connor', 'connor@mail.com', '9fb4116e8c2c9a141c01ad84ef4374b890782f1e', 2),
    ('Sandy', 'sandy@mail.com', 'eb3a293ae28a032ae4024790334d2861191acb62', 2),
    ('Korzun', 'korzun@mail.com', 'eb3a293ae28a032ae4024790334d2861191acb62', 0);

INSERT INTO orders (user_id, total_cost, status)
VALUES
    ((SELECT id FROM users WHERE users.id = 1), 34.6, 0),
    ((SELECT id FROM users WHERE users.id = 2), 23.4, 0),
    ((SELECT id FROM users WHERE users.id = 2), 100.0, 1),
    ((SELECT id FROM users WHERE users.id = 3), 20.4, 2),
    ((SELECT id FROM users WHERE users.id = 4), 45.8, 1),
    ((SELECT id FROM users WHERE users.id = 5), 15.7, 0),
    ((SELECT id FROM users WHERE users.id = 6), 20.4, 1);

INSERT INTO order_items (order_id, book_id, quantity, price)
VALUES
    ((SELECT id FROM orders WHERE orders.id = 1), (SELECT id FROM books WHERE books.title = 'To Kill a Mockingbird'), 1, (SELECT price FROM books WHERE books.title = 'To Kill a Mockingbird')),
    ((SELECT id FROM orders WHERE orders.id = 1), (SELECT id FROM books WHERE books.title = '1984'), 1, (SELECT price FROM books WHERE books.title = '1984')),
    ((SELECT id FROM orders WHERE orders.id = 1), (SELECT id FROM books WHERE books.title = 'Harry Potter'), 1, (SELECT price FROM books WHERE books.title = 'Harry Potter')),
    ((SELECT id FROM orders WHERE orders.id = 2), (SELECT id FROM books WHERE books.title = 'The Great Gatsby'), 1, (SELECT price FROM books WHERE books.title = 'The Great Gatsby')),
    ((SELECT id FROM orders WHERE orders.id = 3), (SELECT id FROM books WHERE books.title = 'Airport'), 1, (SELECT price FROM books WHERE books.title = 'Airport')),
    ((SELECT id FROM orders WHERE orders.id = 3), (SELECT id FROM books WHERE books.title = 'Hotel'), 1, (SELECT price FROM books WHERE books.title = 'Hotel')),
    ((SELECT id FROM orders WHERE orders.id = 4), (SELECT id FROM books WHERE books.title = 'Financier'), 1, (SELECT price FROM books WHERE books.title = 'Financier')),
    ((SELECT id FROM orders WHERE orders.id = 5), (SELECT id FROM books WHERE books.title = 'Titan'), 1, (SELECT price FROM books WHERE books.title = 'Titan')),
    ((SELECT id FROM orders WHERE orders.id = 5), (SELECT id FROM books WHERE books.title = 'Stoic'), 1, (SELECT price FROM books WHERE books.title = 'Stoic')),
    ((SELECT id FROM orders WHERE orders.id = 6), (SELECT id FROM books WHERE books.title = 'The Silence of the Lambs'), 1, (SELECT price FROM books WHERE books.title = 'The Silence of the Lambs')),
    ((SELECT id FROM orders WHERE orders.id = 7), (SELECT id FROM books WHERE books.title = 'The Godfather'), 1, (SELECT price FROM books WHERE books.title = 'The Godfather'));