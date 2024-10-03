**Schema (MySQL v8.0)**

    CREATE TABLE Pets (
      pet_id INT PRIMARY KEY AUTO_INCREMENT,
      name VARCHAR(50),
      type VARCHAR(15),
      birthdate DATE,
      commands TEXT
    );
    
    CREATE TABLE PackAnimals (
      pack_id INT PRIMARY KEY AUTO_INCREMENT,
      name VARCHAR(50),
      type VARCHAR(15),
      birthdate DATE,
      commands TEXT
    );
    
    INSERT INTO Pets (name, type, birthdate, commands) VALUES
    ("Fido", "Dog", "2020-01-01", "Trot, Canter, Gallop"),
    ("Sandy","Cat","2019-05-15","Sit, Pounce"),
    ("Hammy", "Hamster" ,"2021-03-10", "Roll, Hide"),
    ("Buddy","Dog","2018-12-10","Sit, Paw, Bark"),
    ("Smudge","Cat","2020-02-20","Sit, Pounce, Scratch"),
    ("Peanut","Hamster","2021-08-01","Roll, Spin"),
    ("Bella","Dog","2019-11-11","Sit, Stay, Roll"),
    ("Oliver","Cat","2020-06-30","Meow, Scratch, Jump");
    
    INSERT INTO PackAnimals (name, type, birthdate, commands) VALUES
    ("Thunder", "Horse", "2015-07-21", "Sit, Stay, Fetch"),
    ("Whiskers","Camel","2016-11-03","Walk, Carry Load"),
    ("Eeyore", "Donkey" ,"2017-09-18", "Walk, Carry Load, Bray"),
    ("Storm","Horse","2014-05-05","Trot, Canter"),
    ("Dune","Camel","2018-12-12","Walk, Sit"),
    ("Burro","Donkey","2019-01-23","Walk, Bray, Kick"),
    ("Blaze","Horse","2016-02-29","Trot, Jump, Gallop"),
    ("Sahara","Camel","2015-08-14","Walk, Run");
    
    -- Удалить из таблицы верблюдов
    DELETE FROM PackAnimals WHERE type = "Camel";
    
    -- Создать новую таблицу “молодые животные”
    CREATE TABLE YoungAnimals AS 
    SELECT  * FROM Pets 
    WHERE TIMESTAMPDIFF(YEAR, birthdate, NOW()) BETWEEN 1 AND 3
    UNION
    SELECT * FROM PackAnimals 
    WHERE TIMESTAMPDIFF(YEAR, birthdate, NOW()) BETWEEN 1 AND 3;
    
    -- Объединить все таблицы в одну
    CREATE TABLE AllAnimals AS 
    SELECT  * FROM Pets 
    UNION
    SELECT * FROM PackAnimals 
    
    
    
    
    
    
    
    
    
    
    
    
    

---

**Query #1**

    SELECT * FROM Pets;

| pet_id | name   | type    | birthdate  | commands             |
| ------ | ------ | ------- | ---------- | -------------------- |
| 1      | Fido   | Dog     | 2020-01-01 | Trot, Canter, Gallop |
| 2      | Sandy  | Cat     | 2019-05-15 | Sit, Pounce          |
| 3      | Hammy  | Hamster | 2021-03-10 | Roll, Hide           |
| 4      | Buddy  | Dog     | 2018-12-10 | Sit, Paw, Bark       |
| 5      | Smudge | Cat     | 2020-02-20 | Sit, Pounce, Scratch |
| 6      | Peanut | Hamster | 2021-08-01 | Roll, Spin           |
| 7      | Bella  | Dog     | 2019-11-11 | Sit, Stay, Roll      |
| 8      | Oliver | Cat     | 2020-06-30 | Meow, Scratch, Jump  |

---
**Query #2**

    SELECT * FROM PackAnimals;

| pack_id | name    | type   | birthdate  | commands               |
| ------- | ------- | ------ | ---------- | ---------------------- |
| 1       | Thunder | Horse  | 2015-07-21 | Sit, Stay, Fetch       |
| 3       | Eeyore  | Donkey | 2017-09-18 | Walk, Carry Load, Bray |
| 4       | Storm   | Horse  | 2014-05-05 | Trot, Canter           |
| 6       | Burro   | Donkey | 2019-01-23 | Walk, Bray, Kick       |
| 7       | Blaze   | Horse  | 2016-02-29 | Trot, Jump, Gallop     |

---
**Query #3**

    SELECT * FROM YoungAnimals;

| pet_id | name   | type    | birthdate  | commands   |
| ------ | ------ | ------- | ---------- | ---------- |
| 3      | Hammy  | Hamster | 2021-03-10 | Roll, Hide |
| 6      | Peanut | Hamster | 2021-08-01 | Roll, Spin |

---
**Query #4**

    SELECT * FROM AllAnimals;

| pet_id | name    | type    | birthdate  | commands               |
| ------ | ------- | ------- | ---------- | ---------------------- |
| 1      | Fido    | Dog     | 2020-01-01 | Trot, Canter, Gallop   |
| 2      | Sandy   | Cat     | 2019-05-15 | Sit, Pounce            |
| 3      | Hammy   | Hamster | 2021-03-10 | Roll, Hide             |
| 4      | Buddy   | Dog     | 2018-12-10 | Sit, Paw, Bark         |
| 5      | Smudge  | Cat     | 2020-02-20 | Sit, Pounce, Scratch   |
| 6      | Peanut  | Hamster | 2021-08-01 | Roll, Spin             |
| 7      | Bella   | Dog     | 2019-11-11 | Sit, Stay, Roll        |
| 8      | Oliver  | Cat     | 2020-06-30 | Meow, Scratch, Jump    |
| 1      | Thunder | Horse   | 2015-07-21 | Sit, Stay, Fetch       |
| 3      | Eeyore  | Donkey  | 2017-09-18 | Walk, Carry Load, Bray |
| 4      | Storm   | Horse   | 2014-05-05 | Trot, Canter           |
| 6      | Burro   | Donkey  | 2019-01-23 | Walk, Bray, Kick       |
| 7      | Blaze   | Horse   | 2016-02-29 | Trot, Jump, Gallop     |

---

[View on DB Fiddle](https://www.db-fiddle.com/f/cebPf6QNUTbwUeFGKBWeAZ/4)