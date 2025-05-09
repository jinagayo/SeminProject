package sitemesh;
import javax.servlet.annotation.WebFilter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

@WebFilter("/*")
public class Sitemesh extends ConfigurableSiteMeshFilter{
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/professor/*", "/view/professor/professorLayout.jsp").addDecoratorPath("/student/*", "/view/student/studentLayout.jsp");;
	}
}
