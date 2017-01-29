CREATE OR REPLACE PROCEDURE show_students(RC OUT SYS_REFCURSOR) AS
BEGIN
    OPEN rc FOR SELECT   *
                FROM     students;              
END;
/
--variable rc refcursor;
--exec show_students( :rc );
--print rc;
--show errors


CREATE OR REPLACE PROCEDURE show_courses(RC OUT SYS_REFCURSOR) AS
BEGIN
    OPEN rc FOR SELECT   *
                FROM     courses;
END;
/
--variable rc refcursor;
--exec show_courses( :rc );
--print rc;
--show errors


CREATE OR REPLACE PROCEDURE show_course_credit(RC OUT SYS_REFCURSOR) AS
BEGIN
    OPEN rc FOR SELECT   *
                FROM    course_credit;
END;
/
--variable rc refcursor;
--exec show_course_credit( :rc );
--print rc;
--show errors




CREATE OR REPLACE PROCEDURE show_classes(RC OUT SYS_REFCURSOR) AS
BEGIN
    OPEN rc FOR SELECT   *
                FROM     classes;
END;
/
--variable rc refcursor;
--exec show_classes( :rc );
--print rc;


CREATE OR REPLACE PROCEDURE show_enrollments(RC OUT SYS_REFCURSOR) AS
BEGIN
    OPEN rc FOR SELECT   *
                FROM    enrollments;
END;
/
--variable rc refcursor;
--exec show_enrollments( :rc );
--print rc;

CREATE OR REPLACE PROCEDURE show_grades(RC OUT SYS_REFCURSOR) AS
BEGIN
    OPEN rc FOR SELECT   *
                FROM     grades;
END;
/
--variable rc refcursor;
--exec show_grades( :rc );
--print rc;


CREATE OR REPLACE PROCEDURE show_prerequisites(RC OUT SYS_REFCURSOR) AS
BEGIN
    OPEN rc FOR SELECT   *
                FROM     prerequisites;
END;
/
--variable rc refcursor;
--exec show_prerequisites( :rc );
--print rc;



CREATE OR REPLACE PROCEDURE show_logs(RC OUT SYS_REFCURSOR) AS
BEGIN
    OPEN rc FOR SELECT   *
                FROM     logs;
END;
/
--variable rc refcursor;
--exec show_logs( :rc );
--print rc;










