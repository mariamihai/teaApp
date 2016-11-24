package tea.dao.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import app.util.ConfigProfil;
import tea.dao.entities.TeaCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles(ConfigProfil.TEST)
public class TeaCategoryTest {

	
	@Autowired
	TeaCategoryRepository repo;
	
	
	@Test
	public void testGetCategory() {
		TeaCategory category = repo.findOne(1L);
		
		Assert.notNull(category);
	}
	
	@Test
	public void testGetCategories() {
		List<TeaCategory> categories = repo.findAll();
		
		assertThat(categories.size(), is(5));
	}
	
	@Test
	public void testCreateCategory() {
		TeaCategory newCategory = new TeaCategory(6L, "testData");
		TeaCategory savedCategory = repo.saveAndFlush(newCategory);
		
		assertThat(savedCategory != null);
	}
	
	@Test
	public void testUpdateCategory() {
		TeaCategory category = repo.findOne(1L);
		category.setName("Changed Named");
		
		TeaCategory savedCategory = repo.saveAndFlush(category);
		
		assertThat(savedCategory.getId(), is(1L));
		assertThat(savedCategory.getName(), is("Changed Named"));
	}
	
	@Test
	public void testDeleteCategory() {
		repo.delete(1L);
		
		List<TeaCategory> categories = repo.findAll();		
		assertThat(categories.size(), is(4));
	}
	
	@Test
	public void testDeleteAllCategories() {
		repo.deleteAll();
		
		List<TeaCategory> categories = repo.findAll();		
		assertThat(categories.size(), is(0));
	}
}
