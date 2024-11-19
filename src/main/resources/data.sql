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
