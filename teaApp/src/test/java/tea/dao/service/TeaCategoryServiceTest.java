package tea.dao.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tea.dto.TeaCategoryDto;
import tea.service.TeaCategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@Profile("mysql") // hsql
public class TeaCategoryServiceTest {

	
	@Autowired
	TeaCategoryService service;
	
	
	@Test
	public void testGetCategory() throws Exception {
		TeaCategoryDto dto = service.getDto(1L, TeaCategoryDto.class);
		
		assertThat(dto != null);
//		assertThat(dto.getName(), is("Green"));
	}
}
