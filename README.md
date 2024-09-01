# Library Management System

## Objective
This project is a simple Library Management System that allows users to perform basic operations such as adding books, borrowing books, returning books, and viewing available books.

## Features
#### Add Books:
  1. Users can add new books to the library.
  2. Each book has a unique identifier (ISBN), title, author, and publication year.

#### Borrow Books:
  1. Users can borrow a book from the library if it is available.
  2. The system ensures that the book is available before allowing it to be borrowed.
  3. If the book is not available, the system raises an appropriate error.

#### Return Books:
  1. Users can return a borrowed book.
  2. The system updates the availability of the book accordingly.

#### View Available Books:
  1. Users can view a list of all available books in the library.

## Development Approach
This project was developed using Test-Driven Development (TDD) principles:

1. Write a failing test: Each feature is implemented by first writing a test case that defines the desired behavior.
2. Write the minimum code to pass the test: Once the test fails, the minimum code necessary to pass the test is written.
3. Refactor: The code is then refactored to improve structure and maintainability while ensuring that all tests continue to pass.
