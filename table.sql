CREATE TABLE mentalHealthDatabase (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Age INT,
    Gender VARCHAR(50),
    Occupation VARCHAR(100),
    Anxiety INT,
    Ocd INT,
    Schiz INT,
    Bipolar INT,
    Depression INT,
    ContactNo INT,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);