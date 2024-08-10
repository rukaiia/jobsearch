
CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100),
                       phone VARCHAR(20),
                       email VARCHAR(100) UNIQUE,
                       user_type ENUM('APPLICANT', 'EMPLOYER')
);

CREATE TABLE resumes (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         applicant_id INT,
                         name VARCHAR(100),
                         category_id INT,
                         salary DOUBLE,
                         is_active BOOLEAN,
                         created_date TIMESTAMP,
                         update_time TIMESTAMP,
                         FOREIGN KEY (applicant_id) REFERENCES users(id)
);

CREATE TABLE vacancies (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           employer_id INT,
                           title VARCHAR(100),
                           category_id INT,
                           salary DOUBLE,
                           description TEXT,
                           is_active BOOLEAN,
                           created_date TIMESTAMP,
                           FOREIGN KEY (employer_id) REFERENCES users(id)
);

CREATE TABLE applications (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              resume_id INT,
                              vacancy_id INT,
                              application_date TIMESTAMP,
                              FOREIGN KEY (resume_id) REFERENCES resumes(id),
                              FOREIGN KEY (vacancy_id) REFERENCES vacancies(id)
);


INSERT INTO users (name, phone, email, user_type) VALUES
                                                      ('John Doe', '123-456-7890', 'john.doe@example.com', 'APPLICANT'),
                                                      ('Jane Smith', '987-654-3210', 'jane.smith@example.com', 'EMPLOYER');

INSERT INTO resumes (applicant_id, name, category_id, salary, is_active, created_date) VALUES
                                                                                           (1, 'Software Developer', 1, 70000, TRUE, CURRENT_TIMESTAMP),
                                                                                           (1, 'Senior Software Engineer', 2, 90000, TRUE, CURRENT_TIMESTAMP);

INSERT INTO vacancies (employer_id, title, category_id, salary, description, is_active, created_date) VALUES
                                                                                                          (2, 'Junior Developer', 1, 60000, 'Looking for a junior developer with experience in Java.', TRUE, CURRENT_TIMESTAMP),
                                                                                                          (2, 'Lead Developer', 2, 100000, 'Looking for a lead developer with experience in large projects.', TRUE, CURRENT_TIMESTAMP);

INSERT INTO applications (resume_id, vacancy_id, application_date) VALUES
                                                                       (1, 1, CURRENT_TIMESTAMP),
                                                                       (2, 2, CURRENT_TIMESTAMP);
