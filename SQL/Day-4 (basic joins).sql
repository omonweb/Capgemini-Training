

use library;

-- query to retrieve title of book, author's name from book and author's table

SELECT b.title, a.author_name FROM books b JOIN authors a ON b.author_id = a.author_id;

-- filter titles, genres from science fiction

SELECT b.title , g.genre_name FROM books b JOIN genres g ON b.genre_id = g.Genre_id
	WHERE g.Genre_name = "Science fiction";
    
-- all users deets who have borrowed the book with title It

SELECT u.* FROM users u JOIN loans l ON l.user_id = u.User_id
	WHERE l.book_id IN (SELECT book_id FROM books WHERE title = "It");
    
-- user deets borrowed maxm books

SELECT u.*, COUNT(DISTINCT l.book_id) AS uniq_books
FROM users u
JOIN loans l ON u.user_id = l.user_id
GROUP BY u.user_id
ORDER BY uniq_books DESC
LIMIT 1;

-- most borrowed book title

SELECT b.title , COUNT(l.book_id) AS most_borrowed_books
FROM books b
JOIN loans l ON b.Book_id = l.Book_id
GROUP BY b.title
ORDER BY most_borrowed_books DESC;

-- list authors whose book have never been borrowed

SELECT a.author_name FROM authors a JOIN books b ON a.author_id = b.author_id 
	LEFT JOIN loans l ON b.Book_id = l.Book_id 
    WHERE l.loan_id IS NULL
    
    