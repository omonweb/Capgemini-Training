CREATE database library;

-- Disable foreign key checks to allow dropping tables in any order
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS Loans;
DROP TABLE IF EXISTS Books;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Genres;
DROP TABLE IF EXISTS Authors;

-- Enable foreign key checks again
SET FOREIGN_KEY_CHECKS = 1;

-- 1. Authors Table
CREATE TABLE Authors (
    author_id INT PRIMARY KEY AUTO_INCREMENT,
    author_name VARCHAR(255) NOT NULL,
    State VARCHAR(100)
);

-- 2. Genres Table
CREATE TABLE Genres (
    Genre_id INT PRIMARY KEY AUTO_INCREMENT,
    Genre_name VARCHAR(100) NOT NULL
);

-- 3. Users Table
CREATE TABLE Users (
    User_id INT PRIMARY KEY AUTO_INCREMENT,
    User_name VARCHAR(255) NOT NULL,
    Phno VARCHAR(20),
    Email VARCHAR(255)
);

-- 4. Books Table (Depends on Authors and Genres)
CREATE TABLE Books (
    Book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author_id INT,
    genre_id INT,
    CONSTRAINT fk_book_author FOREIGN KEY (author_id) REFERENCES Authors(author_id),
    CONSTRAINT fk_book_genre FOREIGN KEY (genre_id) REFERENCES Genres(Genre_id)
);

-- 5. Loans Table (Depends on Users and Books)
CREATE TABLE Loans (
    Loan_id INT PRIMARY KEY AUTO_INCREMENT,
    User_id INT,
    Book_id INT,
    Borrowed_date DATE,
    Return_date DATE,
    CONSTRAINT fk_loan_user FOREIGN KEY (User_id) REFERENCES Users(User_id),
    CONSTRAINT fk_loan_book FOREIGN KEY (Book_id) REFERENCES Books(Book_id)
);


-- ```````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
use library;
-- 1. Authors (Realistic mix, including one with no books listed)
INSERT INTO Authors (author_name, State) VALUES
('Stephen King', 'Maine'),
('J.K. Rowling', 'Gloucestershire'),
('George R.R. Martin', 'New Jersey'),
('Ernest Hemingway', 'Illinois'),
('Agatha Christie', 'Devon'),
('Toni Morrison', 'Ohio'),
('Haruki Murakami', 'Kyoto'),
('Margaret Atwood', 'Ottawa'),
('Gabriel García Márquez', 'Aracataca'),
('Neil Gaiman', 'Portchester'); -- Author with no books in this dataset

-- 2. Genres
INSERT INTO Genres (Genre_name) VALUES
('Horror'), ('Fantasy'), ('Mystery'), ('Literary Fiction'), ('Science Fiction'),
('Thriller'), ('Historical Fiction'), ('Romance'), ('Biography'), ('Poetry');

-- 3. Users (Including a few who haven't borrowed yet)
INSERT INTO Users (User_name, Phno, Email) VALUES
('Alice Johnson', '555-0101', 'alice.j@email.com'),
('Bob Smith', '555-0102', 'bob.smith@email.com'),
('Charlie Davis', '555-0103', 'charlie.d@email.com'),
('Diana Prince', '555-0104', 'diana.p@email.com'),
('Edward Norton', '555-0105', 'ed.norton@email.com'),
('Fiona Gallagher', '555-0106', 'fiona.g@email.com'),
('George Miller', '555-0107', 'g.miller@email.com'),
('Hannah Abbott', '555-0108', 'hannah.a@email.com'), -- User with no loans
('Ian Wright', '555-0109', 'ian.w@email.com'),     -- User with no loans
('Jenny Slate', '555-0110', 'j.slate@email.com');   -- User with no loans

-- 4. Books (Mapped to Authors and Genres)
INSERT INTO Books (title, author_id, genre_id) VALUES
('The Shining', 1, 1),
('It', 1, 1),
('Harry Potter and the Sorcerer\'s Stone', 2, 2),
('A Game of Thrones', 3, 2),
('The Old Man and the Sea', 4, 4),
('Murder on the Orient Express', 5, 3),
('Beloved', 6, 4),
('Norwegian Wood', 7, 4),
('The Handmaid\'s Tale', 8, 5),
('One Hundred Years of Solitude', 9, 4);

-- 5. Loans (Recorded dates for the first 7 users)
INSERT INTO Loans (User_id, Book_id, Borrowed_date, Return_date) VALUES
(1, 1, '2024-01-10', '2024-01-24'),
(2, 3, '2024-01-12', '2024-01-26'),
(3, 4, '2024-02-01', '2024-02-15'),
(4, 6, '2024-02-05', '2024-02-19'),
(5, 9, '2024-02-10', '2024-02-24'),
(6, 2, '2024-03-01', '2024-03-15'),
(7, 5, '2024-03-05', '2024-03-19'),
(1, 10, '2024-03-10', NULL), -- Currently borrowed (no return date)
(2, 7, '2024-03-12', NULL); -- Currently borrowed
-- (3, 8, '2024-03-15', '2024-03-29');

DELETE FROM Loans 
	WHERE book_id = 8;

select * from authors;



 





















