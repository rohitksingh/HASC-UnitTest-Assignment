package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hacs.ClassCourseList;
import hacs.Course;
import hacs.Facade;
import hacs.Person;
import hacs.UserInfoItem;

class TestFacade {

	Facade facade;
	UserInfoItem userInfo;
	
	@BeforeEach
	public void init() {
		facade = new Facade();
        userInfo = new UserInfoItem();
	}
	
	@Test
	@DisplayName("test create course list")
    void testcreateCourseList() {
    	
        Facade facade = new Facade();
        facade.createCourseList();
        ClassCourseList courses = facade.theCourseList;
        String course1 = "CSE870";
        String courseName = courses.findCourseByCourseName(course1).toString();
        assertEquals(course1, courseName);
        
    }
	
	@Test
	@DisplayName("test attach course to user")
    void testAttachCourseToUser() {
    	
        String username = "Inst1";
        userInfo.setStrUserName(username);
        userInfo.setUserType(UserInfoItem.USER_TYPE.Student);
        facade.createUser(userInfo);
        facade.createCourseList();
        facade.attachCourseToUser();
        Person person = facade.getPerson();
        person.addCourse(new Course("CSE880",0));
        String course = "CSE880";
        String courseName = person.getCourseList().findCourseByCourseName(course).toString();
        assertEquals(course, courseName);    
    }
	
	@Test
	@DisplayName("test create user")
    void testCreateUser() {
		Facade facade = new Facade();
        UserInfoItem userInfo = new UserInfoItem();
        String name = "Student1";
        userInfo.setStrUserName(name);
        facade.createUser(userInfo);
        assertEquals(name, userInfo.getStrUserName());  
	}
	
}
