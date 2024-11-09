-- Thêm dữ liệu vào bảng Departments
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

-- Thêm dữ liệu vào bảng user (cần thêm created_at và updated_at)
INSERT INTO user (full_name, email, gender, phone, department_id, position, skill, password, created_at, updated_at)
VALUES
    ('Nguyễn Văn A', 'nguyenvana@example.com', 'Male', '0901234567', 1, 'Developer', 'Java, Spring Boot', 'password123', NOW(), NOW()),
    ('Trần Thị B', 'tranthib@example.com', 'Female', '0902345678', 2, 'Sales Manager', 'Sales, Communication', 'password123', NOW(), NOW()),
    ('Lê Minh C', 'leminhc@example.com', 'Male', '0903456789', 3, 'HR Specialist', 'Recruitment, Payroll', 'password123', NOW(), NOW()),
    ('Phạm Thanh D', 'phamthanhd@example.com', 'Male', '0904567890', 4, 'Financial Analyst', 'Accounting, Excel', 'password123', NOW(), NOW()),
    ('Đỗ Thị E', 'dothie@example.com', 'Female', '0905678901', 5, 'Marketing Manager', 'SEO, Content', 'password123', NOW(), NOW()),
    ('Vũ Minh F', 'vuminhf@example.com', 'Male', '0906789012', 6, 'Customer Support', 'Problem Solving, Communication', 'password123', NOW(), NOW()),
    ('Hoàng Văn G', 'hoangvang@example.com', 'Male', '0907890123', 7, 'R&D Manager', 'Innovation, Research', 'password123', NOW(), NOW()),
    ('Nguyễn Thị H', 'nguyenhi@example.com', 'Female', '0908901234', 8, 'Admin Officer', 'Organizational Skills, Office Management', 'password123', NOW(), NOW()),
    ('Lê Minh I', 'leminhi@example.com', 'Male', '0909012345', 9, 'Trainer', 'Teaching, Leadership', 'password123', NOW(), NOW()),
    ('Trần Thị J', 'tranthij@example.com', 'Female', '0900123456', 10, 'Security Officer', 'Surveillance, Security', 'password123', NOW(), NOW());
