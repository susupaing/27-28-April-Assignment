DROP TABLE IF EXISTS DEPARTMENT;
DROP TABLE IF EXISTS POSITION;
DROP TABLE IF EXISTS JAPANESE_LEVEL;
CREATE TABLE POSITION (
    POSITION_ID        Integer        NOT NULL,
    POSITION_NAME        VARCHAR(100)    NOT NULL,
    CONSTRAINT POSITION_PK1 PRIMARY KEY(POSITION_ID)
)
;
CREATE TABLE DEPARTMENT (
    DEPARTMENT_ID        Integer         NOT NULL,
    DEPARTMENT_NAME      VARCHAR(100)    NOT NULL,
    CONSTRAINT DEPARTMENT_PK2 PRIMARY KEY(DEPARTMENT_ID)
)
;
CREATE TABLE JAPANESE_LEVEL (
    JP_LEVEL_ID        Integer         NOT NULL,
    JP_LEVEL_NAME	VARCHAR(20)    NOT NULL,
    CONSTRAINT JAPANESE_LEVEL_PK3 PRIMARY KEY(JP_LEVEL_ID)
)
;
COMMIT;