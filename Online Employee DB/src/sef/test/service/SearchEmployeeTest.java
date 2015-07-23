package sef.test.service;

import java.util.List;

import sef.interfaces.service.SearchService;
import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SearchEmployeeTest extends TestCase{
	
	private SearchService service;
	
	
	public void setUp(){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:repository-config.xml");
		service = (SearchService)context.getBean("searchService");
	}
	
	public void testListemployees(){
		List result = service.findEmployeesByName("Arnolds", "Skuja");
		assertNotNull(result);
		assertTrue(result.size() > 0);
		result = service.findEmployeesByName("random", "arnold");
		assertTrue(result.size() == 0);
	}
	
	public void testFindEmployeesByProject(){
		List result = service.findEmployeesByProject(1);
		assertNotNull(result);
		assertTrue(result.size() > 0);
		result = service.findEmployeesByProject(999);
		assertTrue(result.size() == 0);
	}
	
	public void testListAllProjects(){
		List result = service.listAllProjects();
		assertNotNull(result);
		assertTrue(result.size() > 0);
	}
}
