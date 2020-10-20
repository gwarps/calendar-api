create table calendar.users (	id int auto_increment PRIMARY KEY, 
				first_name char(50), 
				last_name char(50),
				email char(100) UNIQUE,
				password char(50));

create table calendar.events ( id int auto_increment PRIMARY KEY, 
				user_id int,
				start_time DATETIME,
				end_time DATETIME,
				title varchar(20),
				description varchar(200),
				priority ENUM('low', 'medium', 'high'),
			        INDEX user_indx(user_id),
			        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE);
					
			
