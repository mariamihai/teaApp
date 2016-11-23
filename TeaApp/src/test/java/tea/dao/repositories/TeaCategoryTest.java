package tea.dao.repositories;

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
	public void test1() {
		TeaCategory category = repo.findOne(1L);
		
		Assert.notNull(category);
	}
}
