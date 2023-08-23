CREATE TABLE members
(
    id VARCHAR(255) NOT NULL,
    pw VARCHAR(255) NULL,
    CONSTRAINT pk_members PRIMARY KEY (id)
);
INSERT INTO studyboard.members (id, pw) VALUES ("hong1", 1111);
INSERT INTO studyboard.members (id, pw) VALUES ("hong2", 1111);
INSERT INTO studyboard.members (id, pw) VALUES ("hong3", 1111);
