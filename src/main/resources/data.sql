INSERT INTO Departments (department_id, department_name, manager_id)
VALUES
    (1, 'Phòng Kỹ Thuật', 101),
    (2, 'Phòng Kinh Doanh', 102),
    (3, 'Phòng Nhân Sự', 103),
    (4, 'Phòng Tài Chính', 104),
    (5, 'Phòng Marketing', 105),
    (6, 'Phòng Chăm Sóc Khách Hàng', 106),
    (7, 'Phòng Nghiên Cứu & Phát Triển', 107),
    (8, 'Phòng Hành Chính', 108),
    (9, 'Phòng Đào Tạo', 109),
    (10, 'Phòng Bảo Vệ', 110),
    (11, 'Phòng Kế Hoạch', 111);


INSERT INTO Positions (position_name, level, department_id)
VALUES
    ('Junior Developer', 'Junior', 1),
    ('Mid Developer', 'Mid', 1),
    ('Senior Developer', 'Senior', 1),
    ('Team Lead', 'Lead', 1),
    ('Project Manager', 'Manager', 1),
    ('Technical Director', 'Director', 1),
    ('Junior QA', 'Junior', 2),
    ('Senior QA', 'Senior', 2),
    ('QA Lead', 'Lead', 2),
    ('QA Manager', 'Manager', 2);

INSERT INTO user (full_name, email, gender, phone, department_id, position_id, skill, password, created_at, updated_at)
VALUES
    ('Nguyễn Văn A', 'nguyenvana@example.com', 'Male', '0901234567', 1, 1, 'Java, Spring Boot', 'password123', NOW(), NOW()),
    ('Trần Thị B', 'tranthib@example.com', 'Female', '0902345678', 2, 2, 'Sales, Communication', 'password123', NOW(), NOW()),
    ('Lê Minh C', 'leminhc@example.com', 'Male', '0903456789', 3, 3, 'Recruitment, Payroll', 'password123', NOW(), NOW()),
    ('Phạm Thanh D', 'phamthanhd@example.com', 'Male', '0904567890', 4, 4, 'Accounting, Excel', 'password123', NOW(), NOW()),
    ('Đỗ Thị E', 'dothie@example.com', 'Female', '0905678901', 5, 5, 'SEO, Content', 'password123', NOW(), NOW()),
    ('Vũ Minh F', 'vuminhf@example.com', 'Male', '0906789012', 6, 6, 'Problem Solving, Communication', 'password123', NOW(), NOW()),
    ('Hoàng Văn G', 'hoangvang@example.com', 'Male', '0907890123', 7, 7, 'Innovation, Research', 'password123', NOW(), NOW()),
    ('Nguyễn Thị H', 'nguyenhi@example.com', 'Female', '0908901234', 8, 8, 'Organizational Skills, Office Management', 'password123', NOW(), NOW()),
    ('Lê Minh I', 'leminhi@example.com', 'Male', '0909012345', 9, 9, 'Teaching, Leadership', 'password123', NOW(), NOW()),
    ('Trần Thị J', 'tranthij@example.com', 'Female', '0900123456', 10, 10, 'Surveillance, Security', 'password123', NOW(), NOW());

INSERT INTO employee_profiles (user_id, department_id, job_title, status, hire_date)
VALUES
    (1, 1, 'Junior Developer', 'Approved', '2022-01-15'),
    (2, 2, 'Sales Representative', 'Approved', '2022-02-10'),
    (3, 3, 'HR Specialist', 'Pending', '2023-03-01'),
    (4, 4, 'Financial Analyst', 'Approved', '2021-11-20'),
    (5, 5, 'SEO Specialist', 'Approved', '2022-06-05'),
    (6, 6, 'Customer Service Representative', 'Approved', '2023-01-10'),
    (7, 7, 'Research Scientist', 'Pending', '2023-08-15'),
    (8, 8, 'Office Manager', 'Approved', '2021-10-30'),
    (9, 9, 'Training Specialist', 'Approved', '2022-05-22'),
    (10, 10, 'Security Officer', 'Pending', '2023-09-18');

INSERT INTO work_schedules (user_id, work_date, work_hours, status, created_at)
VALUES
    (1, '2024-11-01', 8, 'COMPLETED', NOW()),
    (2, '2024-11-01', 7, 'APPROVED', NOW()),
    (3, '2024-11-01', 6, 'PENDING', NOW()),
    (4, '2024-11-02', 8, 'COMPLETED', NOW()),
    (5, '2024-11-02', 7, 'APPROVED', NOW()),
    (6, '2024-11-02', 8, 'PENDING', NOW()),
    (7, '2024-11-03', 8, 'COMPLETED', NOW()),
    (8, '2024-11-03', 7, 'APPROVED', NOW()),
    (9, '2024-11-03', 6, 'PENDING', NOW()),
    (10, '2024-11-04', 8, 'COMPLETED', NOW());

INSERT INTO employee_work_records (user_id, task_name, task_description, start_time, end_time, duration_in_hours, status, performance_rating, created_at, updated_at)
VALUES
    (1, 'Task 1', 'Description of task 1', '2024-11-01 09:00:00', '2024-11-01 12:00:00', 3.0, 'COMPLETED', 'GOOD', NOW(), NOW()),
    (2, 'Task 2', 'Description of task 2', '2024-11-02 10:00:00', '2024-11-02 13:00:00', 3.0, 'IN_PROGRESS', 'AVERAGE', NOW(), NOW()),
    (3, 'Task 3', 'Description of task 3', '2024-11-03 08:00:00', '2024-11-03 11:00:00', 3.0, 'NOT_STARTED', 'POOR', NOW(), NOW()),
    (4, 'Task 4', 'Description of task 4', '2024-11-04 14:00:00', '2024-11-04 18:00:00', 4.0, 'COMPLETED', 'EXCELLENT', NOW(), NOW()),
    (5, 'Task 5', 'Description of task 5', '2024-11-05 09:00:00', '2024-11-05 12:00:00', 3.0, 'COMPLETED', 'GOOD', NOW(), NOW()),
    (6, 'Task 6', 'Description of task 6', '2024-11-06 10:00:00', '2024-11-06 13:00:00', 3.0, 'IN_PROGRESS', 'AVERAGE', NOW(), NOW()),
    (7, 'Task 7', 'Description of task 7', '2024-11-07 08:00:00', '2024-11-07 11:00:00', 3.0, 'NOT_STARTED', 'POOR', NOW(), NOW()),
    (8, 'Task 8', 'Description of task 8', '2024-11-08 14:00:00', '2024-11-08 18:00:00', 4.0, 'COMPLETED', 'EXCELLENT', NOW(), NOW()),
    (9, 'Task 9', 'Description of task 9', '2024-11-09 09:00:00', '2024-11-09 12:00:00', 3.0, 'COMPLETED', 'GOOD', NOW(), NOW()),
    (10, 'Task 10', 'Description of task 10', '2024-11-10 10:00:00', '2024-11-10 13:00:00', 3.0, 'IN_PROGRESS', 'AVERAGE', NOW(), NOW());

INSERT INTO work_reports (user_id, report_title, report_content, report_date, status)
VALUES
    (1, 'Weekly Report 1', 'Content for weekly report 1', '2024-11-19', 'PENDING'),
    (2, 'Weekly Report 2', 'Content for weekly report 2', '2024-11-19', 'APPROVED'),
    (3, 'Weekly Report 3', 'Content for weekly report 3', '2024-11-19', 'PENDING'),
    (4, 'Weekly Report 4', 'Content for weekly report 4', '2024-11-19', 'APPROVED'),
    (5, 'Weekly Report 5', 'Content for weekly report 5', '2024-11-19', 'PENDING'),
    (6, 'Weekly Report 6', 'Content for weekly report 6', '2024-11-19', 'APPROVED'),
    (7, 'Weekly Report 7', 'Content for weekly report 7', '2024-11-19', 'PENDING'),
    (8, 'Weekly Report 8', 'Content for weekly report 8', '2024-11-19', 'APPROVED'),
    (9, 'Weekly Report 9', 'Content for weekly report 9', '2024-11-19', 'PENDING'),
    (10, 'Weekly Report 10', 'Content for weekly report 10', '2024-11-19', 'APPROVED');

-- Insert sample data for the Requests table

INSERT INTO request (user_id, request_type, request_detail, status, created_at, updated_at, approved_by_manager, approved_by_admin)
VALUES
    (1, 'Leave Request', 'Request for leave on 2024-12-01', 'PENDING', NOW(), NOW(), FALSE, FALSE),
    (2, 'Expense Reimbursement', 'Request for reimbursement of expenses for project X', 'MANAGER_APPROVED', NOW(), NOW(), TRUE, FALSE),
    (3, 'Training Request', 'Request to attend Java programming course', 'ADMIN_APPROVED', NOW(), NOW(), TRUE, TRUE),
    (4, 'Leave Request', 'Request for leave on 2024-12-10', 'REJECTED', NOW(), NOW(), FALSE, FALSE),
    (5, 'Expense Reimbursement', 'Request for reimbursement for conference travel', 'PENDING', NOW(), NOW(), FALSE, FALSE),
    (6, 'Training Request', 'Request to attend UX/UI design workshop', 'PENDING', NOW(), NOW(), FALSE, FALSE),
    (7, 'Leave Request', 'Request for leave from 2024-11-20 to 2024-11-23', 'MANAGER_APPROVED', NOW(), NOW(), TRUE, FALSE),
    (8, 'Expense Reimbursement', 'Request for reimbursement of office supplies', 'ADMIN_APPROVED', NOW(), NOW(), TRUE, TRUE),
    (9, 'Training Request', 'Request to attend data science seminar', 'PENDING', NOW(), NOW(), FALSE, FALSE),
    (10, 'Leave Request', 'Request for leave on 2024-12-05', 'REJECTED', NOW(), NOW(), FALSE, FALSE);

-- Insert data into HR_EmployeeManagement table
INSERT INTO hr_employee_management (user_id, department_id, hire_date, evaluation) VALUES
                                                                                      (1, 1, '2020-01-15', 'Excellent performance in employee management and recruitment.'),
                                                                                      (2, 2, '2021-06-10', 'Strong technical skills in software development, but needs improvement in communication.'),
                                                                                      (3, 3, '2019-03-22', 'Highly skilled in financial analysis and budgeting, great attention to detail.'),
                                                                                      (4, 4, '2022-08-05', 'Creative marketer, consistently contributes to successful campaigns and brand building.'),
                                                                                      (5, 5, '2021-11-12', 'Consistently exceeds sales targets and builds strong customer relationships.'),
                                                                                      (6, 1, '2022-01-20', 'Good assistant to HR manager, manages payroll effectively and is reliable.'),
                                                                                      (7, 2, '2020-07-30', 'Strong coding skills and ability to deliver projects within deadlines.'),
                                                                                      (8, 3, '2018-12-10', 'Detailed-oriented and accurate in preparing financial statements and reports.'),
                                                                                      (9, 4, '2021-05-15', 'Effectively manages marketing strategies and campaigns, excellent communication skills.'),
                                                                                      (10, 5, '2020-09-25', 'Proven track record in driving sales growth, excellent negotiation skills.');

INSERT INTO hr_training_programs (training_name, description, start_date, end_date, status)
VALUES
    ('Java Programming Basics', 'A beginner-level training program to learn the basics of Java programming.', '2024-12-01', '2024-12-15', 'Scheduled'),
    ('Advanced Java Development', 'An advanced course for developers to deepen their knowledge of Java and related technologies.', '2024-12-10', '2024-12-30', 'Scheduled'),
    ('Spring Framework Fundamentals', 'Introduction to the Spring Framework for building enterprise applications.', '2024-12-05', '2024-12-20', 'Scheduled'),
    ('Frontend Development with React', 'A training program focusing on building modern web apps using React.js.', '2024-12-15', '2024-12-25', 'Scheduled'),
    ('Project Management Essentials', 'A program designed to teach the basics of project management and Agile methodologies.', '2024-12-01', '2024-12-10', 'Scheduled'),
    ('Database Management Systems', 'An introduction to relational databases and SQL for managing data efficiently.', '2024-12-20', '2024-12-31', 'Scheduled'),
    ('DevOps and CI/CD Pipeline', 'Learn DevOps practices and how to implement continuous integration and deployment.', '2024-12-10', '2024-12-18', 'Scheduled'),
    ('Cloud Computing with AWS', 'An introductory program on cloud technologies and AWS services.', '2024-12-12', '2024-12-22', 'Scheduled'),
    ('Machine Learning Introduction', 'A beginner-friendly course on machine learning and data science.', '2024-12-05', '2024-12-15', 'Scheduled'),
    ('Cybersecurity Fundamentals', 'Learn the basics of cybersecurity and how to protect systems from potential threats.', '2024-12-15', '2024-12-25', 'Scheduled');



