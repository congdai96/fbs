package com.atom.fbs.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atom.fbs.dao.CategoryDAO;
import com.atom.fbs.dto.Category;



public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDAO categoryDAO;
	
	
	private Category category;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.atom.fbs");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	
	/*@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("TV");
		category.setDescription("This is some description for TV!");
		category.setImageURL("CAT_105.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		
	}*/
	
	
	/*@Test
	public void testGetCategory() {
		
		category = categoryDAO.get(2);
		
		
		assertEquals("Successfully fetched a single category from the table!","Television",category.getName());
		
		
	}*/
	
	
	@Test
	public void testUpdateCategory() throws Exception {
		
		category = categoryDAO.findById(2);
		
		category.setName("Television");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
		
		
	}
	

/*	@Test
	public void testDeleteCategory() {
		
		category = categoryDAO.get(3);		
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
	}
*/	
/*	
	@Test
	public void testListCategory() {
					
		assertEquals("Successfully fetched the list of categories from the table!",3,categoryDAO.list().size());
		
		
	}
	
*/
	
	
	
}
